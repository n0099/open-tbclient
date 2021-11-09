package com.baidu.tieba.themeCenter.bubble.list;

import b.a.e.a.f;
import b.a.r0.r3.h.e;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleListModel extends BdBaseModel<BubbleListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BubbleListActivity f54570e;

    /* renamed from: f  reason: collision with root package name */
    public e f54571f;

    /* renamed from: g  reason: collision with root package name */
    public List<DressItemData> f54572g;

    /* renamed from: h  reason: collision with root package name */
    public List<DressItemData> f54573h;

    /* renamed from: i  reason: collision with root package name */
    public c f54574i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public b.a.e.c.g.a n;
    public final HttpMessageListener o;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleListModel f54575a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BubbleListModel bubbleListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f54575a = bubbleListModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BubbleListHttpResponseMessage;
            if (z || (responsedMessage instanceof BubbleListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        BubbleListHttpResponseMessage bubbleListHttpResponseMessage = (BubbleListHttpResponseMessage) responsedMessage;
                        this.f54575a.f54571f = bubbleListHttpResponseMessage.getRecommand();
                        this.f54575a.f54572g = bubbleListHttpResponseMessage.getBubbleList();
                        this.f54575a.k = bubbleListHttpResponseMessage.hasMore();
                        this.f54575a.l = bubbleListHttpResponseMessage.isDefault();
                    } else if (responsedMessage instanceof BubbleListSocketResponseMessage) {
                        BubbleListSocketResponseMessage bubbleListSocketResponseMessage = (BubbleListSocketResponseMessage) responsedMessage;
                        this.f54575a.f54571f = bubbleListSocketResponseMessage.getRecommand();
                        this.f54575a.f54572g = bubbleListSocketResponseMessage.getBubbleList();
                        this.f54575a.k = bubbleListSocketResponseMessage.hasMore();
                        this.f54575a.l = bubbleListSocketResponseMessage.isDefault();
                    }
                    if (this.f54575a.f54573h == null) {
                        this.f54575a.f54573h = new ArrayList();
                    }
                    if (this.f54575a.j == 1) {
                        this.f54575a.f54573h.clear();
                        DressItemData dressItemData = new DressItemData();
                        dressItemData.setPropsId(0);
                        dressItemData.setInUse(this.f54575a.l);
                        this.f54575a.f54573h.add(dressItemData);
                    }
                    if (this.f54575a.f54572g != null) {
                        this.f54575a.f54573h.addAll(this.f54575a.f54572g);
                    }
                } else {
                    BubbleListModel.y(this.f54575a);
                }
                if (this.f54575a.f54574i != null) {
                    this.f54575a.f54574i.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f54575a.f54571f, this.f54575a.f54573h);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleListModel f54576a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BubbleListModel bubbleListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleListModel, Integer.valueOf(i2)};
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
            this.f54576a = bubbleListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003056) {
                BubbleSetResponseMessage bubbleSetResponseMessage = (BubbleSetResponseMessage) httpResponsedMessage;
                if (bubbleSetResponseMessage.getError() != 0) {
                    this.f54576a.f54570e.showToast(bubbleSetResponseMessage.getErrorString());
                    return;
                }
                this.f54576a.O(((Integer) ((HttpMessage) httpResponsedMessage.getmOrginalMessage()).getExtra()).intValue());
                this.f54576a.f54574i.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f54576a.f54571f, this.f54576a.f54573h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<DressItemData> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleListModel(BubbleListActivity bubbleListActivity) {
        super(bubbleListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleListActivity};
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
        this.j = 0;
        this.k = true;
        this.l = false;
        this.n = new a(this, CmdConfigHttp.CMD_BUBBLE_LIST, 309031);
        this.o = new b(this, CmdConfigHttp.CMD_BUBBLE_SET);
        this.f54570e = bubbleListActivity;
        this.m = bubbleListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.n);
        M();
        registerListener(this.o);
    }

    public static /* synthetic */ int y(BubbleListModel bubbleListModel) {
        int i2 = bubbleListModel.j;
        bubbleListModel.j = i2 - 1;
        return i2;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BUBBLE_SET, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
            tbHttpMessageTask.setResponsedClass(BubbleSetResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void N(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f54574i = cVar;
        }
    }

    public final void O(int i2) {
        List<DressItemData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (list = this.f54573h) == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.f54573h) {
            if (dressItemData != null) {
                if (dressItemData.getPropsId() == i2) {
                    dressItemData.setInUse(true);
                } else {
                    dressItemData.setInUse(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
            this.j = 1;
            bubbleListRequestMessage.setPn(1);
            bubbleListRequestMessage.setRn(15);
            sendMessage(bubbleListRequestMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.r0.l3.f0.a.h(309031, BubbleListSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(309031, CmdConfigHttp.CMD_BUBBLE_LIST, TbConfig.BUBBLE_LIST_PAGE, BubbleListHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.k) {
            this.j++;
            BubbleListRequestMessage bubbleListRequestMessage = new BubbleListRequestMessage();
            bubbleListRequestMessage.setPn(this.j);
            bubbleListRequestMessage.setRn(16);
            sendMessage(bubbleListRequestMessage);
        }
    }
}
