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
import com.baidu.tieba.l16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class x88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public y88 c;
    public int d;
    public final CustomMessageListener e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;

    /* loaded from: classes6.dex */
    public class a implements l16.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadData a;
        public final /* synthetic */ x88 b;

        public a(x88 x88Var, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x88Var, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x88Var;
            this.a = threadData;
        }

        @Override // com.baidu.tieba.l16.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ej.M(this.b.a.getPageActivity(), R.string.obfuscated_res_0x7f0f13ec);
                }
                this.b.h(z, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x88 x88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x88Var, Integer.valueOf(i)};
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
            this.a = x88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.a.b && this.a.c != null && this.a.c.T0()) {
                this.a.k((ThreadData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x88 x88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x88Var, Integer.valueOf(i)};
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
            this.a = x88Var;
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
        public final /* synthetic */ x88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x88 x88Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x88Var, Integer.valueOf(i)};
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
            this.a = x88Var;
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

    public x88(TbPageContext tbPageContext, BdUniqueId bdUniqueId, y88 y88Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, y88Var, Integer.valueOf(i)};
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
        this.c = y88Var;
        this.d = i;
        this.e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
        this.f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f);
        this.g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g);
    }

    public final void h(boolean z, ThreadData threadData) {
        y88 y88Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, threadData) == null) || threadData == null || (y88Var = this.c) == null || ListUtils.isEmpty(y88Var.getListData()) || this.c.getMainView() == null || this.c.getMainView().e() == null) {
            return;
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= this.c.getListData().size()) {
                break;
            }
            Cdo cdo = this.c.getListData().get(i);
            if (cdo != null && (e = z88.e(cdo)) != null && !StringUtils.isNull(e.tid) && e.tid.equals(threadData.tid)) {
                e.isPrivacy = z;
                c26 d2 = z88.d(e);
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

    public final void i(String str) {
        y88 y88Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (y88Var = this.c) == null || ListUtils.isEmpty(y88Var.getListData()) || this.c.getMainView() == null || this.c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<Cdo> it = this.c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Cdo next = it.next();
            if (next != null && (e = z88.e(next)) != null && e.getBaijiahaoData() != null && !StringUtils.isNull(e.getBaijiahaoData().oriUgcNid) && e.getBaijiahaoData().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.c.getMainView().n(this.c.getListData());
        }
    }

    public final void j(String str) {
        y88 y88Var;
        ThreadData e;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (y88Var = this.c) == null || ListUtils.isEmpty(y88Var.getListData()) || this.c.getMainView() == null || this.c.getMainView().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<Cdo> it = this.c.getListData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Cdo next = it.next();
            if (next != null && (e = z88.e(next)) != null && !StringUtils.isNull(e.tid) && e.tid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.c.getMainView().n(this.c.getListData());
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
            l16 l16Var = new l16(this.a);
            l16Var.t(this.d == 1);
            l16Var.o();
            l16Var.s(new a(this, threadData));
            l16Var.n(cardPersonDynamicThreadData, false);
            l16Var.u();
        }
    }
}
