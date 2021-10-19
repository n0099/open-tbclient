package com.baidu.tieba.themeCenter.bubble.group;

import c.a.e.a.f;
import c.a.r0.q3.h.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleSetResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class BubbleGroupModel extends BdBaseModel<BubbleGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BubbleGroupActivity f57507e;

    /* renamed from: f  reason: collision with root package name */
    public e f57508f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.r0.q3.f.b.b> f57509g;

    /* renamed from: h  reason: collision with root package name */
    public c f57510h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57511i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f57512j;
    public final HttpMessageListener k;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleGroupModel f57513a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BubbleGroupModel bubbleGroupModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleGroupModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57513a = bubbleGroupModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BubbleGroupHttpResponseMessage;
            if (z || (responsedMessage instanceof BubbleGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (this.f57513a.f57510h != null) {
                        this.f57513a.f57510h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f57513a.f57508f, this.f57513a.f57509g);
                        return;
                    }
                    return;
                }
                if (z) {
                    BubbleGroupHttpResponseMessage bubbleGroupHttpResponseMessage = (BubbleGroupHttpResponseMessage) responsedMessage;
                    this.f57513a.f57508f = bubbleGroupHttpResponseMessage.getRecommand();
                    this.f57513a.f57509g = bubbleGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BubbleGroupSocketResponseMessage) {
                    BubbleGroupSocketResponseMessage bubbleGroupSocketResponseMessage = (BubbleGroupSocketResponseMessage) responsedMessage;
                    this.f57513a.f57508f = bubbleGroupSocketResponseMessage.getRecommand();
                    this.f57513a.f57509g = bubbleGroupSocketResponseMessage.getGroupList();
                }
                if (this.f57513a.f57510h != null) {
                    this.f57513a.f57510h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f57513a.f57508f, this.f57513a.f57509g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleGroupModel f57514a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BubbleGroupModel bubbleGroupModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleGroupModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57514a = bubbleGroupModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
                BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
                if (bubbleSetResponseMessage.getError() != 0) {
                    this.f57514a.f57507e.showToast(bubbleSetResponseMessage.getErrorString());
                    return;
                }
                this.f57514a.H(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
                this.f57514a.f57510h.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f57514a.f57508f, this.f57514a.f57509g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<c.a.r0.q3.f.b.b> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleGroupModel(BubbleGroupActivity bubbleGroupActivity) {
        super(bubbleGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleGroupActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57512j = new a(this, CmdConfigHttp.CMD_BUBBLE_CATEGORY, 309030);
        this.k = new b(this, CmdConfigHttp.CMD_BUBBLE_SET);
        this.f57507e = bubbleGroupActivity;
        this.f57511i = bubbleGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        E();
        registerListener(this.f57512j);
        F();
        registerListener(this.k);
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57511i : invokeV.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.k3.e0.a.h(309030, BubbleGroupSocketResponseMessage.class, false, false);
            c.a.r0.k3.e0.a.c(309030, CmdConfigHttp.CMD_BUBBLE_CATEGORY, TbConfig.BUBBLE_GROUP_PAGE, BubbleGroupHttpResponseMessage.class, false, false, false, false);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
            tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void G(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f57510h = cVar;
        }
    }

    public final void H(int i2) {
        List<c.a.r0.q3.f.b.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (list = this.f57509g) == null || list.size() <= 0) {
            return;
        }
        for (c.a.r0.q3.f.b.b bVar : this.f57509g) {
            if (bVar != null && bVar.a() != null) {
                for (DressItemData dressItemData : bVar.a()) {
                    if (dressItemData != null) {
                        if (dressItemData.getPropsId() == i2) {
                            dressItemData.setInUse(true);
                        } else {
                            dressItemData.setInUse(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sendMessage(new BubbleGroupRequestMessage());
            return false;
        }
        return invokeV.booleanValue;
    }
}
