package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.f26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class v98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public w98 c;
    public int d;
    public final CustomMessageListener e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a implements f26.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ v98 b;

        public a(v98 v98Var, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v98Var, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v98Var;
            this.a = threadData;
        }

        @Override // com.baidu.tieba.f26.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    fj.M(this.b.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1401);
                }
                this.b.h(z, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v98 v98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ThreadData) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != this.a.b || this.a.c == null || !this.a.c.T0()) {
                return;
            }
            this.a.k((ThreadData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v98 v98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(v98 v98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public v98(TbPageContext tbPageContext, BdUniqueId bdUniqueId, w98 w98Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, w98Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new b(this, 2921428);
        this.f = new c(this, 2016557);
        this.g = new d(this, 2921436);
        this.a = tbPageContext;
        this.b = bdUniqueId;
        this.c = w98Var;
        this.d = i;
        this.e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f);
        this.g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g);
    }

    public final void h(boolean z, ThreadData threadData) {
        w98 w98Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, threadData) == null) && threadData != null && (w98Var = this.c) != null && !ListUtils.isEmpty(w98Var.getListData()) && this.c.getMainView() != null && this.c.getMainView().e() != null) {
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= this.c.getListData().size()) {
                    break;
                }
                eo eoVar = (eo) this.c.getListData().get(i);
                if (eoVar != null && (e = x98.e(eoVar)) != null && !StringUtils.isNull(e.tid) && e.tid.equals(threadData.tid)) {
                    e.isPrivacy = z;
                    w26 d2 = x98.d(e);
                    if (d2 != null) {
                        this.c.getListData().set(i, d2);
                        z2 = true;
                        break;
                    }
                }
                i++;
            }
            if (z2) {
                this.c.getMainView().n(this.c.getListData());
            }
        }
    }

    public final void i(String str) {
        w98 w98Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !StringUtils.isNull(str) && (w98Var = this.c) != null && !ListUtils.isEmpty(w98Var.getListData()) && this.c.getMainView() != null && this.c.getMainView().e() != null) {
            boolean z = false;
            Iterator it = this.c.getListData().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eo eoVar = (eo) it.next();
                if (eoVar != null && (e = x98.e(eoVar)) != null && e.getBaijiahaoData() != null && !StringUtils.isNull(e.getBaijiahaoData().oriUgcNid) && e.getBaijiahaoData().oriUgcNid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.c.getMainView().n(this.c.getListData());
            }
        }
    }

    public final void j(String str) {
        w98 w98Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !StringUtils.isNull(str) && (w98Var = this.c) != null && !ListUtils.isEmpty(w98Var.getListData()) && this.c.getMainView() != null && this.c.getMainView().e() != null) {
            boolean z = false;
            Iterator it = this.c.getListData().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eo eoVar = (eo) it.next();
                if (eoVar != null && (e = x98.e(eoVar)) != null && !StringUtils.isNull(e.tid) && e.tid.equals(str)) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            if (z) {
                this.c.getMainView().n(this.c.getListData());
            }
        }
    }

    public final void k(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.p = threadData;
            cardPersonDynamicThreadData.a = String.valueOf(threadData.getFid());
            cardPersonDynamicThreadData.b = threadData.tid;
            cardPersonDynamicThreadData.e = threadData.person_center_post_id;
            cardPersonDynamicThreadData.o = threadData.isPrivacy;
            if (threadData != null && threadData.getBaijiahaoData() != null) {
                cardPersonDynamicThreadData.G = threadData.getBaijiahaoData().oriUgcNid;
            }
            f26 f26Var = new f26(this.a);
            boolean z = true;
            if (this.d != 1) {
                z = false;
            }
            f26Var.t(z);
            f26Var.o();
            f26Var.s(new a(this, threadData));
            f26Var.n(cardPersonDynamicThreadData, false);
            f26Var.u();
        }
    }
}
