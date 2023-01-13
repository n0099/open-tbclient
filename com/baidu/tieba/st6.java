package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import com.baidu.tieba.rt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class st6 implements tt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public ut6 c;
    public List<xt6> d;
    public final HashMap<String, pt6> e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public long j;
    public Handler k;
    public rt6 l;
    public rt6.c m;
    public rb n;

    /* loaded from: classes6.dex */
    public class a implements rt6.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st6 a;

        public a(st6 st6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st6Var;
        }

        @Override // com.baidu.tieba.rt6.c
        public void a(List<xt6> list, List<yn> list2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) && this.a.d != null && this.a.c != null) {
                this.a.c.a(0, 0, list2, list, z, true, -1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(st6 st6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = st6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.rb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<yn> threadList;
            boolean hasMore;
            int i;
            xt6 xt6Var;
            nt6 nt6Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            this.a.i = false;
            if (responsedMessage.hasError()) {
                if (this.a.c != null) {
                    this.a.c.b(this.a.f, this.a.g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.d == null) {
                    this.a.d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (responsedMessage instanceof FrsGameStrategyHttpResponseMessage) {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.d == null) {
                    this.a.d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            } else {
                return;
            }
            int i2 = this.a.f;
            int i3 = this.a.g;
            if (this.a.f == 0 && this.a.g == 0 && !ListUtils.isEmpty(this.a.d) && (xt6Var = (xt6) this.a.d.get(0)) != null) {
                i2 = xt6Var.a;
                Object obj = xt6Var.c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (nt6Var = labelDataList.get(0)) != null) {
                        i3 = nt6Var.a;
                    }
                }
            }
            String p = this.a.p(i2, i3);
            pt6 pt6Var = (pt6) this.a.e.get(p);
            if (pt6Var == null) {
                pt6Var = new pt6();
                this.a.e.put(p, pt6Var);
                this.a.e.put(p, pt6Var);
            }
            pt6Var.e = hasMore;
            pt6Var.f = this.a.h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.h == 0) {
                    if (ListUtils.isEmpty(pt6Var.d)) {
                        pt6Var.d = threadList;
                    } else {
                        i = pt6Var.a(threadList);
                        if (this.a.c == null) {
                            this.a.c.a(this.a.f, this.a.g, pt6Var.d, this.a.d, pt6Var.e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    pt6Var.d.addAll(threadList);
                }
            }
            i = -1;
            if (this.a.c == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ st6 c;

        public c(st6 st6Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = st6Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ st6 c;

        public d(st6 st6Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = st6Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.c(this.a, this.b);
            }
        }
    }

    public st6(Context context, BdUniqueId bdUniqueId, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.b = bdUniqueId;
        this.j = j;
        this.e = new HashMap<>();
        rt6 rt6Var = new rt6();
        this.l = rt6Var;
        rt6Var.e(this.m);
        s();
        t();
    }

    public void u(ut6 ut6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ut6Var) == null) {
            this.c = ut6Var;
        }
    }

    public final String p(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return i + "_" + i2;
        }
        return (String) invokeII.objValue;
    }

    public pt6 q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            return this.e.get(p(i, i2));
        }
        return (pt6) invokeII.objValue;
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            qw8.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, qw8.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.tt6
    public xt6 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (xt6 xt6Var : this.d) {
                if (xt6Var != null && xt6Var.a == i) {
                    return xt6Var;
                }
            }
            return null;
        }
        return (xt6) invokeI.objValue;
    }

    public final xt6 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            for (xt6 xt6Var : this.d) {
                if (xt6Var != null && xt6Var.a == i) {
                    return xt6Var;
                }
            }
            return null;
        }
        return (xt6) invokeI.objValue;
    }

    @Override // com.baidu.tieba.tt6
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new c(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            this.g = i2;
            if (i == 0 && i2 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String p = p(i, i2);
                pt6 pt6Var = this.e.get(p);
                if (pt6Var == null) {
                    pt6Var = new pt6();
                    this.e.put(p, pt6Var);
                }
                pt6Var.a = p;
                pt6Var.b = this.f;
                pt6Var.c = this.g;
                pt6Var.f = 0;
                pt6Var.e = true;
            }
            this.h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.baidu.tieba.tt6
    public void c(int i, int i2) {
        nt6 nt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new d(this, i, i2), 1000L);
                return;
            }
            this.f = i;
            if (i == 0 && i2 == 0) {
                xt6 o = o(i);
                if (o != null) {
                    Object obj = o.c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (nt6Var = labelDataList.get(0)) != null) {
                            this.g = nt6Var.a;
                        }
                    }
                }
            } else {
                this.g = i2;
            }
            String p = p(i, i2);
            pt6 pt6Var = this.e.get(p);
            if (pt6Var == null) {
                pt6Var = new pt6();
                this.e.put(p, pt6Var);
                pt6Var.e = true;
                this.e.put(p, pt6Var);
            }
            int i3 = pt6Var.f + 1;
            this.h = i3;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f, this.g);
            frsGameStrategyRequestMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // com.baidu.tieba.tt6
    public boolean d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            pt6 q = q(i, i2);
            if (q != null && !ListUtils.isEmpty(q.d)) {
                ut6 ut6Var = this.c;
                if (ut6Var != null) {
                    ut6Var.a(i, i2, q.d, this.d, q.e, false, -1);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // com.baidu.tieba.tt6
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return String.valueOf(this.j);
        }
        return (String) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setTag(this.b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }
}
