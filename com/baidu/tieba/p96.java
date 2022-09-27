package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.t36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class p96 implements t36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumModel a;
    public t36.a b;
    public final EnterForumModel.f c;
    public pb d;

    /* loaded from: classes5.dex */
    public class a implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p96 a;

        public a(p96 p96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p96Var;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            b96 b96Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || this.a.b == null) {
                return;
            }
            if (eVar == null || !eVar.b || (b96Var = eVar.d) == null || b96Var.e() == null) {
                this.a.b.a(null, false, 1, 0);
                return;
            }
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            ArrayList<d96> b = eVar.d.e().b();
            if (ListUtils.getCount(b) > 0) {
                Iterator<d96> it = b.iterator();
                while (it.hasNext()) {
                    d96 next = it.next();
                    if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.r())) {
                        TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.r(), false, 1, next.h());
                        transmitForumData.tabItemDatas = next.w();
                        arrayList.add(transmitForumData);
                    }
                }
            }
            this.a.b.a(arrayList, true, 1, 0);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p96 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p96 p96Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p96Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p96Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ForumGuideSocketResponseMessage;
                if ((z || (responsedMessage instanceof ForumGuideHttpResponseMessage)) && this.a.a.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                    if (z) {
                        this.a.a.R((ForumGuideSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                        this.a.a.Q((ForumGuideHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    public p96() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = new a(this);
        this.d = new b(this, CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683);
        EnterForumModel enterForumModel = new EnterForumModel(null);
        this.a = enterForumModel;
        enterForumModel.Y(this.c);
        MessageManager.getInstance().registerListener(this.d);
    }

    @Override // com.baidu.tieba.t36
    public void a(t36.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.b = aVar;
        }
    }

    @Override // com.baidu.tieba.t36
    public void b() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.b == null || (enterForumModel = this.a) == null) {
            return;
        }
        enterForumModel.K(true);
    }
}
