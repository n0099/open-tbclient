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
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.dc3;
import com.baidu.tieba.u83;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class yo2 extends hc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public final SwanAppActivity b;
    public ib2 c;
    public u83.c d;
    public final em3 e;
    public FrameLayout f;
    public fi3 g;
    public zo2 h;
    public final String i;
    public FrameLifeState j;
    public FrameLifeState k;
    public boolean l;
    public boolean m;
    public final wb3 n;
    public boolean o;

    public abstract void B0();

    public abstract void D0();

    public abstract void G0(boolean z, boolean z2);

    @NonNull
    public abstract u83.c b0();

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    public abstract void m0();

    public abstract void o0();

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
        }
    }

    public abstract void u0();

    public abstract void w0();

    public abstract void x0();

    public abstract void z0();

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo2 a;

        /* loaded from: classes8.dex */
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
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.b == null || zb3.b0() == null) {
                    return;
                }
                this.b.a.R(this.a);
            }
        }

        public d(yo2 yo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tp3.e0(new a(this, tp3.i(this.a.Z(), "SwanActivityFrame", true)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements sq3<dc3.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ yo2 c;

        public a(yo2 yo2Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo2Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yo2Var;
            this.a = z;
            this.b = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) != null) || !yb3.K().E()) {
                return;
            }
            this.c.n.g("event_first_action_launched");
            this.c.H0(this.a, this.b);
            this.c.N0();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo2 a;

        public b(yo2 yo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.N0();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo2 a;

        public c(yo2 yo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v33.g().y();
                if (yo2.p) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (this.a.b != null && zb3.M() != null) {
                    zb3 M = zb3.M();
                    ul2 l = ul2.l();
                    l.n(10);
                    mp2.c(M, l.k());
                }
                if (a63.h()) {
                    so3.m(this.a.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-254082676, "Lcom/baidu/tieba/yo2$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-254082676, "Lcom/baidu/tieba/yo2$e;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948336813, "Lcom/baidu/tieba/yo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948336813, "Lcom/baidu/tieba/yo2;");
                return;
            }
        }
        p = js1.a;
    }

    public final synchronized void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                e53.m();
                j0("onStopInternal");
                D0();
                this.h.f();
            }
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            kf3.b = null;
            e53.c = null;
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            hb3.d(this.f);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090180);
            this.f = frameLayout;
            hb3.g(this.b, frameLayout);
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
        lv1 a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (a2 = x().a().a()) != null) {
            a2.a(this.b);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c = new ib2(this.b);
            q0();
        }
    }

    public void P0() {
        ms1 ms1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            zb3 M = zb3.M();
            if (M != null) {
                ms1Var = M.N();
            } else {
                ms1Var = null;
            }
            if (ms1Var != null) {
                ms1Var.h(ms1Var.c(AppRuntime.getAppContext()));
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
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || !q().I()) {
            return;
        }
        s53.e().d(new d(this), "updateTaskDescription", false);
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
            gv2.g0().getSwitch("swan_fixed_relaunch_switch", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ww2.a Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return q().W();
        }
        return (ww2.a) invokeV.objValue;
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

    public ib2 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.c == null) {
                P();
            }
            return this.c;
        }
        return (ib2) invokeV.objValue;
    }

    @NonNull
    public em3 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.e;
        }
        return (em3) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.c.k() != 1) {
                return false;
            }
            this.b.moveTaskToBack(true);
            this.b.Z(2);
            bq3.b().e(1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return mx2.T().X();
        }
        return invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
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

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.h.a();
        }
    }

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            synchronized (this) {
                j0("onReleaseInternal");
                x0();
                mx2.a0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yo2(SwanAppActivity swanAppActivity, String str) {
        super(yb3.K());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cc3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = new em3();
        this.j = FrameLifeState.INACTIVATED;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = new wb3();
        this.o = true;
        this.b = swanAppActivity;
        this.i = str;
        this.h = new zo2();
        u(this.n);
    }

    public final synchronized void update(FrameLifeState frameLifeState, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.b.isDestroyed()) {
                    boolean z3 = false;
                    if (!this.j.hasCreated()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z4 = z | z2;
                    if (this.j.hasCreated() && z4) {
                        z3 = true;
                    }
                    boolean Y = Y();
                    this.o = Y;
                    if (Y && z3 && !q().K()) {
                        this.n.f(new a(this, z4, z3), "event_first_action_launched");
                    } else {
                        H0(z4, z3);
                    }
                    R0(frameLifeState);
                    if (z4 && (z3 || 1 == k())) {
                        e53.j(Z(), z3);
                    }
                }
            }
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            z82.o("SwanActivityFrame", "onTrimMemory level:" + i);
            d0().a(i);
        }
    }

    public void I0(xo2 xo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xo2Var) == null) {
            this.h.h(xo2Var);
        }
    }

    public final void R(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, bitmap) == null) && q().I()) {
            L0(this.b, Z().K(), bitmap, (int) Z().b0());
        }
    }

    public void T0(xo2 xo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, xo2Var) == null) {
            this.h.i(xo2Var);
        }
    }

    public boolean h0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
        }
        return invokeL.booleanValue;
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, str) == null) && p) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            k0();
        }
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

    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i, keyEvent)) == null) {
            return this.h.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final synchronized void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                HybridUbcFlow p2 = e53.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                j0("onResumeInternal");
                this.h.e();
                z82.i("SwanApp", "onResume: " + this);
                this.g = si3.c("607");
                U0();
                if (E()) {
                    q().B0(this.b);
                }
                s53.e().d(new c(this), "tryUpdateAndInsertHistory", false);
                HybridUbcFlow p3 = e53.p("startup");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p3.F(ubcFlowEvent2);
                zh3.d().i("na_page_show");
                mx2.T().v();
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

    public final synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                HybridUbcFlow p2 = e53.p("startup");
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

    public final synchronized void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            synchronized (this) {
                if (!this.j.hasCreated()) {
                    n0();
                    z82.i("SwanApp", "onPostCreate: " + this);
                    w0();
                    this.j = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final synchronized void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p2 = e53.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                j0("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
                if (z) {
                    ww2.a Z = Z();
                    if (!z2) {
                        s0();
                    }
                    if (!TextUtils.isEmpty(Z.g0())) {
                        q92.g(Z.g0());
                    }
                }
                mx2.T().l(this.b);
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

    public final synchronized FrameLifeState N(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        FrameLifeState frameLifeState2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !q().K() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.j)) {
                    if (this.j.hasCreated()) {
                        frameLifeState2 = this.j;
                    } else {
                        frameLifeState2 = FrameLifeState.JUST_CREATED;
                    }
                    return frameLifeState2;
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
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                T();
                            } else {
                                V();
                            }
                        } else {
                            U();
                            W();
                        }
                    } else {
                        X();
                        S();
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

    public final synchronized void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            synchronized (this) {
                j0("onPauseInternal");
                u0();
                mx2.T().w();
                this.h.b();
                z82.i("SwanApp", "onPause: " + this);
                if (this.g != null && E()) {
                    xi3 xi3Var = new xi3();
                    ww2.a Z = Z();
                    xi3Var.a = si3.n(k());
                    xi3Var.f = Z.H();
                    xi3Var.c = Z.T();
                    xi3Var.i(Z);
                    xi3Var.d(Z.s0().getString("ubc"));
                    xi3Var.b(si3.k(Z.W()));
                    si3.i(this.g, xi3Var);
                    this.g = null;
                }
            }
        }
    }

    public final void Q(cj3 cj3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, cj3Var) == null) && cj3Var != null && E()) {
            ww2.a Z = Z();
            cj3Var.a = si3.n(k());
            cj3Var.f = Z.H();
            cj3Var.c = Z.T();
            cj3Var.b(si3.k(Z.W()));
            if (TextUtils.isEmpty(cj3Var.b)) {
                cj3Var.b = "click";
            }
            cj3Var.d(Z.s0().getString("ubc"));
            if (TextUtils.equals(cj3Var.b, "click")) {
                ii3.b(cj3Var);
            } else {
                si3.onEvent(cj3Var);
            }
        }
    }

    public final synchronized void R0(@NonNull FrameLifeState frameLifeState) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, frameLifeState) == null) {
            synchronized (this) {
                j0(" transLifeState: target=" + frameLifeState + " holdon=" + this.l + " locked=" + this.m + " thread=" + Thread.currentThread());
                if (!this.m) {
                    this.k = frameLifeState;
                    if (FrameLifeState.INACTIVATED == frameLifeState) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.m = z;
                }
                if (this.l) {
                    return;
                }
                this.l = true;
                tp3.e0(new b(this));
            }
        }
    }

    @DebugTrace
    public final synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            synchronized (this) {
                j0("onCreateInternal");
                HybridUbcFlow p2 = e53.p("startup");
                p2.F(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p2.F(ubcFlowEvent);
                this.h.g();
                z82.i("SwanApp", "onCreate: " + this);
                if (q92.d()) {
                    ti2.N0(false);
                }
                P();
                yb3 K = yb3.K();
                if (K.E() && K.q().I()) {
                    O();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p2.F(ubcFlowEvent2);
                    m0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p2.F(ubcFlowEvent3);
                    ho3 X = this.b.X();
                    if (X != null) {
                        X.r();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p2.F(ubcFlowEvent4);
                    return;
                }
                sn3 sn3Var = new sn3();
                sn3Var.k(5L);
                sn3Var.i(11L);
                sn3Var.f("aiapp data is invalid");
                wn3.a().f(sn3Var);
                aj3 aj3Var = new aj3();
                aj3Var.q(si3.n(k()));
                aj3Var.p(sn3Var);
                aj3Var.r(Z());
                si3.R(aj3Var);
                e53.k(sn3Var);
                io3.j(this.b);
            }
        }
    }

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            synchronized (this) {
                j0("onDestroyInternal");
                o0();
                this.h.c();
                z82.i("SwanApp", "onDestroy: " + this);
                v33.g().u();
                jh2.k().v();
                x32.c().d();
                q63.f();
                J0();
                S0();
                mx2.a0();
                wl2.b().a();
            }
        }
    }
}
