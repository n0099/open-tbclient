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
/* loaded from: classes8.dex */
public class xv7 extends rq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gs7 h;
    public boolean i;
    public HashMap<Integer, ph7> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public ii7 q;

    /* loaded from: classes8.dex */
    public class f implements ii7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv7 a;

        /* loaded from: classes8.dex */
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

        public f(xv7 xv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xv7Var;
        }

        @Override // com.baidu.tieba.ii7
        public void t0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.i && this.a.b.k4() != null) {
                    if (!this.a.k) {
                        this.a.b.k4().i0();
                    }
                    this.a.i = false;
                }
                if (this.a.h != null && this.a.b.L1() != null && this.a.b.L1().c0() != null && !this.a.b.L1().c0().m() && this.a.b.k4() != null && !this.a.b.k4().Y()) {
                    this.a.h.b();
                }
                if (this.a.a != null && this.a.f != null && this.a.d != null && this.a.h != null) {
                    this.a.a.o0().n(0, 0, true, true);
                    this.a.b.V4();
                    this.a.b.o5(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                    if (!TbadkCoreApplication.isLogin() || this.a.b.c4().getVisibility() != 0 || ListUtils.isEmpty(this.a.b.l1().getThreadList())) {
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ii7
        public void v1() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.i = true;
            if (this.a.a != null && this.a.f != null && this.a.d != null && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.a != null && this.a.a.o0() != null) {
                    this.a.a.o0().y();
                }
                this.a.b.o5(false);
                SafeHandler.getInst().postDelayed(new a(this), 110L);
                this.a.a.A1(1, true);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.b.refresh();
                    this.a.b.o5(true);
                } else {
                    this.a.b.C5();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.a.b.k0()).param("obj_locate", "1"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xv7 xv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv7Var, Integer.valueOf(i)};
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
            this.a = xv7Var;
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
            this.a.b.k4().O();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xv7 xv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv7Var, Integer.valueOf(i)};
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
            this.a = xv7Var;
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

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(xv7 xv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv7Var, Integer.valueOf(i)};
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
            this.a = xv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ph7)) {
                this.a.a.e2();
                ph7 ph7Var = (ph7) customResponsedMessage.getData();
                ii7 ii7Var = ph7Var.b;
                if (ii7Var == null) {
                    int i = ph7Var.a;
                    if (i == 1) {
                        xv7 xv7Var = this.a;
                        xv7Var.Z(i, xv7Var.q);
                    } else {
                        this.a.Z(i, null);
                    }
                } else {
                    this.a.Z(ph7Var.a, ii7Var);
                }
                this.a.c0(ph7Var.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(xv7 xv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv7Var, Integer.valueOf(i)};
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
            this.a = xv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ph7)) {
                ph7 ph7Var = (ph7) customResponsedMessage.getData();
                this.a.a0(ph7Var.a, ph7Var.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(xv7 xv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv7Var, Integer.valueOf(i)};
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
            this.a = xv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ih7)) {
                ih7 ih7Var = (ih7) customResponsedMessage.getData();
                this.a.b0(ih7Var.a, ih7Var.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xv7(FrsFragment frsFragment) {
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
        this.h = frsFragment.W3();
        this.j = new HashMap<>();
        this.a.o1(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public final void b0(int i, boolean z) {
        eh7 eh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (eh7Var = this.a) != null) {
            eh7Var.A1(i, z);
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
        bw7 bw7Var = this.c;
        if ((bw7Var instanceof FrsTabViewController) && ((FrsTabViewController) bw7Var).B() != null && (((FrsTabViewController) this.c).B().b instanceof ii7)) {
            FrsTabViewController.i B = ((FrsTabViewController) this.c).B();
            Z(B.a, (ii7) B.b);
            c0(B.a);
            return;
        }
        this.a.w1(this.q);
    }

    public final void Z(int i, ii7 ii7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ii7Var) == null) {
            ph7 ph7Var = this.j.get(Integer.valueOf(i));
            if (ph7Var == null) {
                ph7 ph7Var2 = new ph7();
                ph7Var2.a = i;
                ph7Var2.b = ii7Var;
                this.j.put(Integer.valueOf(i), ph7Var2);
            } else {
                ph7Var.b = ii7Var;
            }
            eh7 eh7Var = this.a;
            if (eh7Var != null) {
                eh7Var.w1(ii7Var);
            }
        }
    }

    public final void a0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ph7 ph7Var = this.j.get(Integer.valueOf(i));
            if (ph7Var == null) {
                ph7 ph7Var2 = new ph7();
                ph7Var2.a = i;
                ph7Var2.c = z;
                this.j.put(Integer.valueOf(i), ph7Var2);
            } else {
                ph7Var.c = z;
            }
            eh7 eh7Var = this.a;
            if (eh7Var != null) {
                eh7Var.L1(z);
            }
        }
    }

    public final void c0(int i) {
        ph7 ph7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.a != null && (ph7Var = this.j.get(Integer.valueOf(i))) != null) {
            this.a.o1(i);
            this.a.w1(ph7Var.b);
            this.a.L1(ph7Var.c);
            if (ph7Var.b == null) {
                this.a.L1(false);
            }
        }
    }
}
