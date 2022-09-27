package com.baidu.tieba;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.g03;
import com.baidu.tieba.io2;
import com.baidu.tieba.p33;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class kg2 extends t33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public final SwanAppActivity b;
    public u22 c;
    public g03.c d;
    public final qd3 e;
    public FrameLayout f;
    public r93 g;
    public lg2 h;
    public final String i;
    public FrameLifeState j;
    public FrameLifeState k;
    public boolean l;
    public boolean m;
    public final i33 n;
    public boolean o;

    /* loaded from: classes4.dex */
    public class a implements ei3<p33.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ kg2 c;

        public a(kg2 kg2Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg2Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kg2Var;
            this.a = z;
            this.b = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(p33.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && k33.K().E()) {
                this.c.n.g("event_first_action_launched");
                this.c.H0(this.a, this.b);
                this.c.N0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg2 a;

        public b(kg2 kg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg2 a;

        public c(kg2 kg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hv2.g().y();
                if (kg2.p) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (this.a.b != null && l33.M() != null) {
                    l33 M = l33.M();
                    gd2 l = gd2.l();
                    l.n(10);
                    yg2.c(M, l.k());
                }
                if (mx2.h()) {
                    eg3.m(this.a.b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg2 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ d b;

            public a(d dVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.b == null || l33.b0() == null) {
                    return;
                }
                this.b.a.R(this.a);
            }
        }

        public d(kg2 kg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fh3.e0(new a(this, fh3.i(this.a.Z(), "SwanActivityFrame", true)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-662278958, "Lcom/baidu/tieba/kg2$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-662278958, "Lcom/baidu/tieba/kg2$e;");
                    return;
                }
            }
            int[] iArr = new int[FrameLifeState.values().length];
            a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947912051, "Lcom/baidu/tieba/kg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947912051, "Lcom/baidu/tieba/kg2;");
                return;
            }
        }
        p = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kg2(SwanAppActivity swanAppActivity, String str) {
        super(k33.K());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = new qd3();
        this.j = FrameLifeState.INACTIVATED;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = new i33();
        this.o = true;
        this.b = swanAppActivity;
        this.i = str;
        this.h = new lg2();
        u(this.n);
    }

    public static void L0(Activity activity, String str, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65542, null, activity, str, bitmap, i) == null) {
            if (i != 0 && Color.alpha(i) != 255) {
                i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
            }
        }
    }

    public final synchronized void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                HybridUbcFlow p2 = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                j0("onResumeInternal");
                this.h.e();
                l02.i("SwanApp", "onResume: " + this);
                this.g = ea3.c("607");
                U0();
                if (E()) {
                    q().B0(this.b);
                }
                ex2.e().d(new c(this), "tryUpdateAndInsertHistory", false);
                HybridUbcFlow p3 = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p3.F(ubcFlowEvent2);
                l93.d().i("na_page_show");
                yo2.U().v();
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
                ubcFlowEvent3.a(true);
                p2.F(ubcFlowEvent3);
                z0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
                ubcFlowEvent4.a(true);
                p2.F(ubcFlowEvent4);
            }
        }
    }

    public abstract void B0();

    public final synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                HybridUbcFlow p2 = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                j0("onStartInternal");
                this.h.d();
                B0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
                ubcFlowEvent2.a(true);
                p2.F(ubcFlowEvent2);
            }
        }
    }

    public abstract void D0();

    public final synchronized void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                qw2.m();
                j0("onStopInternal");
                D0();
                this.h.f();
            }
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            l02.o("SwanActivityFrame", "onTrimMemory level:" + i);
            d0().a(i);
        }
    }

    public abstract void G0(boolean z, boolean z2);

    public final synchronized void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p2 = qw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                j0("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
                if (z) {
                    io2.a Z = Z();
                    if (!z2) {
                        s0();
                    }
                    if (!TextUtils.isEmpty(Z.g0())) {
                        c12.g(Z.g0());
                    }
                }
                yo2.U().l(this.b);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
                ubcFlowEvent2.a(true);
                p2.F(ubcFlowEvent2);
                G0(z, z2);
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
                ubcFlowEvent3.a(true);
                p2.F(ubcFlowEvent3);
            }
        }
    }

    public void I0(jg2 jg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jg2Var) == null) {
            this.h.h(jg2Var);
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            w63.b = null;
            qw2.c = null;
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            t23.d(this.f);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090172);
            this.f = frameLayout;
            t23.g(this.b, frameLayout);
        }
    }

    public final synchronized FrameLifeState N(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !q().K() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.j)) {
                    return this.j.hasCreated() ? this.j : FrameLifeState.JUST_CREATED;
                }
                return frameLifeState;
            }
        }
        return (FrameLifeState) invokeL.objValue;
    }

    public final synchronized void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                boolean z = true;
                this.l = true;
                while (this.k != null && f0()) {
                    FrameLifeState N = N(this.k);
                    j0("syncLifeState: pendingTarget=" + this.k + " fixedTarget=" + N);
                    this.k = null;
                    int i = e.a[N.ordinal()];
                    if (i == 1) {
                        X();
                        S();
                    } else if (i == 2) {
                        U();
                        W();
                    } else if (i != 3) {
                        T();
                    } else {
                        V();
                    }
                }
                j0("syncLifeState: done=" + this.j);
                if (FrameLifeState.INACTIVATED != this.k) {
                    z = false;
                }
                this.m = z;
                this.l = false;
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.d == null) {
                this.d = b0();
            }
            y().M(null, this.d);
        }
    }

    public final void O0() {
        xm1 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (a2 = x().a().a()) == null) {
            return;
        }
        a2.a(this.b);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c = new u22(this.b);
            q0();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            l33 M = l33.M();
            yj1 N = M != null ? M.N() : null;
            if (N != null) {
                N.h(N.c(AppRuntime.getAppContext()));
            }
        }
    }

    public final void Q(oa3 oa3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, oa3Var) == null) && oa3Var != null && E()) {
            io2.a Z = Z();
            oa3Var.a = ea3.n(k());
            oa3Var.f = Z.H();
            oa3Var.c = Z.T();
            oa3Var.b(ea3.k(Z.W()));
            if (TextUtils.isEmpty(oa3Var.b)) {
                oa3Var.b = "click";
            }
            oa3Var.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            if (TextUtils.equals(oa3Var.b, "click")) {
                u93.b(oa3Var);
            } else {
                ea3.onEvent(oa3Var);
            }
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            O0();
            P0();
        }
    }

    public final void R(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bitmap) == null) && q().I()) {
            L0(this.b, Z().K(), bitmap, (int) Z().b0());
        }
    }

    public final synchronized void R0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, frameLifeState) == null) {
            synchronized (this) {
                j0(" transLifeState: target=" + frameLifeState + " holdon=" + this.l + " locked=" + this.m + " thread=" + Thread.currentThread());
                if (!this.m) {
                    this.k = frameLifeState;
                    this.m = FrameLifeState.INACTIVATED == frameLifeState;
                }
                if (this.l) {
                    return;
                }
                this.l = true;
                fh3.e0(new b(this));
            }
        }
    }

    public final synchronized void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (this) {
                if (!this.j.hasCreated()) {
                    n0();
                    l02.i("SwanApp", "onPostCreate: " + this);
                    w0();
                    this.j = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            y().e0();
            this.d = null;
        }
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                X();
                if (this.j.hasCreated()) {
                    p0();
                    this.j = FrameLifeState.INACTIVATED;
                }
            }
        }
    }

    public void T0(jg2 jg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jg2Var) == null) {
            this.h.i(jg2Var);
        }
    }

    public final synchronized void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this) {
                if (this.j.hasResumed()) {
                    v0();
                    this.j = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && q().I()) {
            ex2.e().d(new d(this), "updateTaskDescription", false);
        }
    }

    public final synchronized void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                W();
                if (!this.j.hasResumed()) {
                    A0();
                    this.j = FrameLifeState.JUST_RESUMED;
                }
            }
        }
    }

    public final synchronized void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                S();
                if (!this.j.hasStarted()) {
                    C0();
                    this.j = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final synchronized void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                U();
                if (this.j.hasStarted()) {
                    E0();
                    this.j = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            sm2.g0().getSwitch("swan_fixed_relaunch_switch", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public io2.a Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? q().W() : (io2.a) invokeV.objValue;
    }

    public synchronized FrameLifeState a0() {
        InterceptResult invokeV;
        FrameLifeState frameLifeState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            synchronized (this) {
                frameLifeState = this.j;
            }
            return frameLifeState;
        }
        return (FrameLifeState) invokeV.objValue;
    }

    @NonNull
    public abstract g03.c b0();

    public u22 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.c == null) {
                P();
            }
            return this.c;
        }
        return (u22) invokeV.objValue;
    }

    @NonNull
    public qd3 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.e : (qd3) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.c.k() != 1) {
                return false;
            }
            this.b.moveTaskToBack(true);
            this.b.Y(2);
            nh3.b().e(1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? yo2.U().Y() : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) ? TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u") : invokeL.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, str) == null) && p) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            k0();
        }
    }

    public abstract void m0();

    @DebugTrace
    public final synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            synchronized (this) {
                j0("onCreateInternal");
                HybridUbcFlow p2 = qw2.p("startup");
                p2.F(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                this.h.g();
                l02.i("SwanApp", "onCreate: " + this);
                if (c12.d()) {
                    fa2.N0(false);
                }
                P();
                k33 K = k33.K();
                if (K.E() && K.q().I()) {
                    O();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p2.F(ubcFlowEvent2);
                    m0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p2.F(ubcFlowEvent3);
                    tf3 W = this.b.W();
                    if (W != null) {
                        W.q();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p2.F(ubcFlowEvent4);
                    return;
                }
                ef3 ef3Var = new ef3();
                ef3Var.k(5L);
                ef3Var.i(11L);
                ef3Var.f("aiapp data is invalid");
                if3.a().f(ef3Var);
                ma3 ma3Var = new ma3();
                ma3Var.q(ea3.n(k()));
                ma3Var.p(ef3Var);
                ma3Var.r(Z());
                ea3.R(ma3Var);
                qw2.k(ef3Var);
                uf3.j(this.b);
            }
        }
    }

    public abstract void o0();

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            synchronized (this) {
                j0("onDestroyInternal");
                o0();
                this.h.c();
                l02.i("SwanApp", "onDestroy: " + this);
                hv2.g().u();
                v82.k().v();
                jv1.c().d();
                cy2.f();
                J0();
                S0();
                yo2.b0();
                id2.b().a();
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
        }
    }

    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i, keyEvent)) == null) ? this.h.onKeyDown(i, keyEvent) : invokeIL.booleanValue;
    }

    public final synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            synchronized (this) {
                R0(FrameLifeState.INACTIVATED);
                y0();
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.h.a();
        }
    }

    public abstract void u0();

    public final synchronized void update(FrameLifeState frameLifeState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.b.isDestroyed()) {
                    boolean z2 = false;
                    boolean z3 = z | (!this.j.hasCreated());
                    if (this.j.hasCreated() && z3) {
                        z2 = true;
                    }
                    boolean Y = Y();
                    this.o = Y;
                    if (Y && z2 && !q().K()) {
                        this.n.f(new a(this, z3, z2), "event_first_action_launched");
                    } else {
                        H0(z3, z2);
                    }
                    R0(frameLifeState);
                    if (z3 && (z2 || 1 == k())) {
                        qw2.j(Z(), z2);
                    }
                }
            }
        }
    }

    public final synchronized void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            synchronized (this) {
                j0("onPauseInternal");
                u0();
                yo2.U().w();
                this.h.b();
                l02.i("SwanApp", "onPause: " + this);
                if (this.g != null && E()) {
                    ja3 ja3Var = new ja3();
                    io2.a Z = Z();
                    ja3Var.a = ea3.n(k());
                    ja3Var.f = Z.H();
                    ja3Var.c = Z.T();
                    ja3Var.i(Z);
                    ja3Var.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                    ja3Var.b(ea3.k(Z.W()));
                    ea3.i(this.g, ja3Var);
                    this.g = null;
                }
            }
        }
    }

    public abstract void w0();

    public abstract void x0();

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            synchronized (this) {
                j0("onReleaseInternal");
                x0();
                yo2.b0();
            }
        }
    }

    public abstract void z0();
}
