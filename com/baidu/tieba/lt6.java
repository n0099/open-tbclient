package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class lt6 extends tp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hr6 h;
    public boolean i;
    public HashMap<Integer, hh6> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public zh6 q;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lt6 lt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt6Var, Integer.valueOf(i)};
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
            this.a = lt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.k = false;
                return;
            }
            this.a.k = true;
            this.a.b.E3().P();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lt6 lt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt6Var, Integer.valueOf(i)};
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
            this.a = lt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.a == null) {
                return;
            }
            this.a.a.V1();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(lt6 lt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt6Var, Integer.valueOf(i)};
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
            this.a = lt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hh6)) {
                this.a.a.X1();
                hh6 hh6Var = (hh6) customResponsedMessage.getData();
                zh6 zh6Var = hh6Var.b;
                if (zh6Var != null) {
                    this.a.c0(hh6Var.a, zh6Var);
                } else {
                    int i = hh6Var.a;
                    if (i != 1) {
                        this.a.c0(i, null);
                    } else {
                        lt6 lt6Var = this.a;
                        lt6Var.c0(i, lt6Var.q);
                    }
                }
                this.a.f0(hh6Var.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(lt6 lt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt6Var, Integer.valueOf(i)};
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
            this.a = lt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hh6)) {
                hh6 hh6Var = (hh6) customResponsedMessage.getData();
                this.a.d0(hh6Var.a, hh6Var.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(lt6 lt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt6Var, Integer.valueOf(i)};
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
            this.a = lt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ah6)) {
                ah6 ah6Var = (ah6) customResponsedMessage.getData();
                this.a.e0(ah6Var.a, ah6Var.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements zh6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt6 a;

        /* loaded from: classes4.dex */
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.a.j0() == null || this.a.a.f == null || this.a.a.a.j0().getVisibility() == 0) {
                    return;
                }
                this.a.a.f.o();
            }
        }

        public f(lt6 lt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lt6Var;
        }

        @Override // com.baidu.tieba.zh6
        public void U0() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i = true;
                if (this.a.a == null || this.a.f == null || this.a.d == null || this.a.b == null || !this.a.b.isAdded()) {
                    return;
                }
                if (this.a.a != null && this.a.a.l0() != null) {
                    this.a.a.l0().x();
                }
                this.a.b.E4(false);
                gh.a().postDelayed(new a(this), 110L);
                this.a.a.t1(1, true);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.b.refresh();
                    this.a.b.E4(true);
                } else {
                    this.a.b.V4();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.a.b.U()).param("obj_locate", "1"));
            }
        }

        @Override // com.baidu.tieba.zh6
        public void d0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.i && this.a.b.E3() != null) {
                    if (!this.a.k && !this.a.a0()) {
                        this.a.b.E3().j0();
                    }
                    this.a.i = false;
                }
                if (this.a.h != null && this.a.b.j1() != null && this.a.b.j1().Z() != null && !this.a.b.j1().Z().p() && this.a.b.E3() != null && !this.a.b.E3().a0()) {
                    this.a.h.b();
                }
                if (this.a.a == null || this.a.f == null || this.a.d == null || this.a.h == null) {
                    return;
                }
                this.a.a.l0().n(0, 0, true, true);
                this.a.b.n4();
                this.a.b.E4(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                this.a.d.u0();
                if (!TbadkCoreApplication.isLogin() || this.a.b.y3().getVisibility() != 0 || ListUtils.isEmpty(this.a.b.O0().getThreadList())) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lt6(FrsFragment frsFragment) {
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
        this.h = frsFragment.t3();
        this.j = new HashMap<>();
        this.a.h1(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b.O0() == null || this.b.O0().getUserData() == null || this.b.O0().forumRule == null || this.b.O0().getForum() == null || !this.b.O0().getForum().getIsShowRule()) {
                return false;
            }
            return this.b.O0().getUserData().getIs_manager() == 1 ? this.b.O0().forumRule.has_forum_rule.intValue() != 1 && this.b.O0().forumRule.audit_status.intValue() == 0 && bx4.k().l("key_forum_rule_first_show_frs_manager", 0) <= 0 : this.b.O0().forumRule.has_forum_rule.intValue() == 1 && bx4.k().l("key_forum_rule_first_show_frs", 0) <= 0;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        pt6 pt6Var = this.c;
        if ((pt6Var instanceof FrsTabViewController) && ((FrsTabViewController) pt6Var).C() != null && (((FrsTabViewController) this.c).C().b instanceof zh6)) {
            FrsTabViewController.p C = ((FrsTabViewController) this.c).C();
            c0(C.a, (zh6) C.b);
            f0(C.a);
            return;
        }
        this.a.p1(this.q);
    }

    public final void c0(int i, zh6 zh6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, zh6Var) == null) {
            hh6 hh6Var = this.j.get(Integer.valueOf(i));
            if (hh6Var == null) {
                hh6 hh6Var2 = new hh6();
                hh6Var2.a = i;
                hh6Var2.b = zh6Var;
                this.j.put(Integer.valueOf(i), hh6Var2);
            } else {
                hh6Var.b = zh6Var;
            }
            wg6 wg6Var = this.a;
            if (wg6Var != null) {
                wg6Var.p1(zh6Var);
            }
        }
    }

    public final void d0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            hh6 hh6Var = this.j.get(Integer.valueOf(i));
            if (hh6Var == null) {
                hh6 hh6Var2 = new hh6();
                hh6Var2.a = i;
                hh6Var2.c = z;
                this.j.put(Integer.valueOf(i), hh6Var2);
            } else {
                hh6Var.c = z;
            }
            wg6 wg6Var = this.a;
            if (wg6Var != null) {
                wg6Var.E1(z);
            }
        }
    }

    public final void e0(int i, boolean z) {
        wg6 wg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (wg6Var = this.a) == null) {
            return;
        }
        wg6Var.t1(i, z);
    }

    public final void f0(int i) {
        hh6 hh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.a == null || (hh6Var = this.j.get(Integer.valueOf(i))) == null) {
            return;
        }
        this.a.h1(i);
        this.a.p1(hh6Var.b);
        this.a.E1(hh6Var.c);
        if (hh6Var.b == null) {
            this.a.E1(false);
        }
    }
}
