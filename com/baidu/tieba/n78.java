package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class n78 extends d28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o38 h;
    public boolean i;
    public HashMap<Integer, xs7> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public qt7 q;

    /* loaded from: classes7.dex */
    public class f implements qt7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.a.m0() != null && this.a.a.f != null && this.a.a.a.m0().getVisibility() != 0) {
                    this.a.a.f.o();
                }
            }
        }

        public f(n78 n78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n78Var;
        }

        @Override // com.baidu.tieba.qt7
        public void O0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.i && this.a.b.V4() != null) {
                    if (!this.a.k) {
                        this.a.b.V4().i0();
                    }
                    this.a.i = false;
                }
                if (this.a.h != null && this.a.b.u2() != null && this.a.b.u2().c0() != null && !this.a.b.u2().c0().m() && this.a.b.V4() != null && !this.a.b.V4().Y()) {
                    this.a.h.b();
                }
                if (this.a.a != null && this.a.f != null && this.a.d != null && this.a.h != null) {
                    this.a.a.o0().n(0, 0, true, true);
                    this.a.b.G5();
                    this.a.b.W5(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                    if (!TbadkCoreApplication.isLogin() || this.a.b.N4().getVisibility() != 0 || ListUtils.isEmpty(this.a.b.Q1().getThreadList())) {
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qt7
        public void a2() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.i = true;
            if (this.a.a != null && this.a.f != null && this.a.d != null && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.a != null && this.a.a.o0() != null) {
                    this.a.a.o0().y();
                }
                this.a.b.W5(false);
                SafeHandler.getInst().postDelayed(new a(this), 110L);
                this.a.a.A1(1, true);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.b.refresh();
                    this.a.b.W5(true);
                } else {
                    this.a.b.k6();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.a.b.C0()).param("obj_locate", "1"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n78 n78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var, Integer.valueOf(i)};
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
            this.a = n78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.k = false;
                return;
            }
            this.a.k = true;
            this.a.b.V4().O();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n78 n78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var, Integer.valueOf(i)};
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
            this.a = n78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.a != null) {
                this.a.a.c2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(n78 n78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var, Integer.valueOf(i)};
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
            this.a = n78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xs7)) {
                this.a.a.e2();
                xs7 xs7Var = (xs7) customResponsedMessage.getData();
                qt7 qt7Var = xs7Var.b;
                if (qt7Var == null) {
                    int i = xs7Var.a;
                    if (i == 1) {
                        n78 n78Var = this.a;
                        n78Var.Z(i, n78Var.q);
                    } else {
                        this.a.Z(i, null);
                    }
                } else {
                    this.a.Z(xs7Var.a, qt7Var);
                }
                this.a.c0(xs7Var.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(n78 n78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var, Integer.valueOf(i)};
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
            this.a = n78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xs7)) {
                xs7 xs7Var = (xs7) customResponsedMessage.getData();
                this.a.a0(xs7Var.a, xs7Var.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(n78 n78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n78Var, Integer.valueOf(i)};
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
            this.a = n78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qs7)) {
                qs7 qs7Var = (qs7) customResponsedMessage.getData();
                this.a.b0(qs7Var.a, qs7Var.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n78(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.h = frsFragment.I4();
        this.j = new HashMap<>();
        this.a.o1(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public final void b0(int i, boolean z) {
        ms7 ms7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (ms7Var = this.a) != null) {
            ms7Var.A1(i, z);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.a == null) {
            return;
        }
        r78 r78Var = this.c;
        if ((r78Var instanceof FrsTabViewController) && ((FrsTabViewController) r78Var).B() != null && (((FrsTabViewController) this.c).B().b instanceof qt7)) {
            FrsTabViewController.i B = ((FrsTabViewController) this.c).B();
            Z(B.a, (qt7) B.b);
            c0(B.a);
            return;
        }
        this.a.w1(this.q);
    }

    public final void Z(int i, qt7 qt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, qt7Var) == null) {
            xs7 xs7Var = this.j.get(Integer.valueOf(i));
            if (xs7Var == null) {
                xs7 xs7Var2 = new xs7();
                xs7Var2.a = i;
                xs7Var2.b = qt7Var;
                this.j.put(Integer.valueOf(i), xs7Var2);
            } else {
                xs7Var.b = qt7Var;
            }
            ms7 ms7Var = this.a;
            if (ms7Var != null) {
                ms7Var.w1(qt7Var);
            }
        }
    }

    public final void a0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            xs7 xs7Var = this.j.get(Integer.valueOf(i));
            if (xs7Var == null) {
                xs7 xs7Var2 = new xs7();
                xs7Var2.a = i;
                xs7Var2.c = z;
                this.j.put(Integer.valueOf(i), xs7Var2);
            } else {
                xs7Var.c = z;
            }
            ms7 ms7Var = this.a;
            if (ms7Var != null) {
                ms7Var.L1(z);
            }
        }
    }

    public final void c0(int i) {
        xs7 xs7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.a != null && (xs7Var = this.j.get(Integer.valueOf(i))) != null) {
            this.a.o1(i);
            this.a.w1(xs7Var.b);
            this.a.L1(xs7Var.c);
            if (xs7Var.b == null) {
                this.a.L1(false);
            }
        }
    }
}
