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
import com.baidu.tieba.kp6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class it9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public jt9 c;
    public int d;
    public final CustomMessageListener e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a implements kp6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ it9 b;

        public a(it9 it9Var, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it9Var, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = it9Var;
            this.a = threadData;
        }

        @Override // com.baidu.tieba.kp6.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    yi.Q(this.b.a.getPageActivity(), R.string.thread_has_hide);
                }
                this.b.h(z, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ it9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(it9 it9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it9Var, Integer.valueOf(i)};
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
            this.a = it9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ThreadData) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != this.a.b || this.a.c == null || !this.a.c.j1()) {
                return;
            }
            this.a.k((ThreadData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ it9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(it9 it9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it9Var, Integer.valueOf(i)};
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
            this.a = it9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
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
        public final /* synthetic */ it9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(it9 it9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it9Var, Integer.valueOf(i)};
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
            this.a = it9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public it9(TbPageContext tbPageContext, BdUniqueId bdUniqueId, jt9 jt9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, jt9Var, Integer.valueOf(i)};
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
        this.c = jt9Var;
        this.d = i;
        this.e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f);
        this.g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g);
    }

    public final void h(boolean z, ThreadData threadData) {
        jt9 jt9Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, threadData) == null) && threadData != null && (jt9Var = this.c) != null && !ListUtils.isEmpty(jt9Var.getListData()) && this.c.getMainView() != null && this.c.getMainView().e() != null) {
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= this.c.getListData().size()) {
                    break;
                }
                yn ynVar = this.c.getListData().get(i);
                if (ynVar != null && (e = kt9.e(ynVar)) != null && !StringUtils.isNull(e.tid) && e.tid.equals(threadData.tid)) {
                    e.isPrivacy = z;
                    cq6 d2 = kt9.d(e);
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
        jt9 jt9Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !StringUtils.isNull(str) && (jt9Var = this.c) != null && !ListUtils.isEmpty(jt9Var.getListData()) && this.c.getMainView() != null && this.c.getMainView().e() != null) {
            boolean z = false;
            Iterator<yn> it = this.c.getListData().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yn next = it.next();
                if (next != null && (e = kt9.e(next)) != null && e.getBaijiahaoData() != null && !StringUtils.isNull(e.getBaijiahaoData().oriUgcNid) && e.getBaijiahaoData().oriUgcNid.equals(str)) {
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
        jt9 jt9Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !StringUtils.isNull(str) && (jt9Var = this.c) != null && !ListUtils.isEmpty(jt9Var.getListData()) && this.c.getMainView() != null && this.c.getMainView().e() != null) {
            boolean z = false;
            Iterator<yn> it = this.c.getListData().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yn next = it.next();
                if (next != null && (e = kt9.e(next)) != null && !StringUtils.isNull(e.tid) && e.tid.equals(str)) {
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
            kp6 kp6Var = new kp6(this.a);
            boolean z = true;
            if (this.d != 1) {
                z = false;
            }
            kp6Var.t(z);
            kp6Var.o();
            kp6Var.s(new a(this, threadData));
            kp6Var.n(cardPersonDynamicThreadData, false);
            kp6Var.u();
        }
    }
}
