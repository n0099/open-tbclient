package com.baidu.tieba;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.g03;
import com.baidu.tieba.hm2;
import com.baidu.tieba.io2;
import com.baidu.tieba.tg2;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
@Autowired
/* loaded from: classes5.dex */
public class ng2 extends kg2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng2 a;

        public a(ng2 ng2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && uf3.d(this.a.b)) {
                s73.g();
                yo2.U().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ng2 ng2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hv2.g().y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements x42<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng2 a;

        public c(ng2 ng2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x42
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements tg2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng2 a;

        public d(ng2 ng2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng2Var;
        }

        @Override // com.baidu.tieba.tg2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.moveTaskToBack(true);
            nh3.b().e(1);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements g03.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng2 a;

        public e(ng2 ng2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng2Var;
        }

        @Override // com.baidu.tieba.g03.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 100) {
                    b03.e().h(new d03(4));
                    this.a.Q0();
                    this.a.l1();
                    k33.K().s();
                    return true;
                } else if (i == 127) {
                    int d = ht2.d();
                    int a = ht2.a(d);
                    if (!ht2.f()) {
                        gt2.a(Integer.valueOf(d), String.valueOf(a));
                    }
                    return true;
                } else if (i == 129) {
                    int p = rf3.m().p();
                    l02.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.a.b != null && this.a.b.e0() && p != -1 && this.a.b.getTaskId() != p) {
                        l02.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        k33.K().s();
                    }
                    return true;
                } else if (i == 102) {
                    boolean a2 = sm2.M().a();
                    sm2.M().d(a2);
                    if (this.a.b != null) {
                        this.a.b.x(a2, false);
                    }
                    return true;
                } else if (i == 103) {
                    l33 M = l33.M();
                    if (M != null) {
                        M.e0().i();
                        hv2.g().v();
                    }
                    this.a.Q0();
                    this.a.k1();
                    return true;
                } else if (i == 106) {
                    k33.K().s();
                    return true;
                } else if (i != 107) {
                    switch (i) {
                        case 123:
                            rf3.r(message);
                            return true;
                        case 124:
                            rf3.q(message);
                            return true;
                        case 125:
                            e03.b(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    n62.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hc3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948001424, "Lcom/baidu/tieba/ng2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948001424, "Lcom/baidu/tieba/ng2;");
                return;
            }
        }
        q = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ng2(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.kg2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            l02.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = lg3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                v93.w();
                zt2.e().l(z2);
                HybridUbcFlow p = qw2.p("startup");
                io2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    v82.k().x(Z.H(), true);
                    da3.d(2);
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            u63.f("backtohome", "message", v1);
                        } else {
                            boolean i = u63.i(v1);
                            v93.u(v1, Z);
                            n32.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = y53.b().a(lt2.d(v1, yo2.U().z()));
                            u63.f("backtohome", a2 ? "message" : "relaunch", v1);
                            if (i && !a2) {
                                u63.q("reLaunch");
                                xu1.d().i();
                                ql2.d("2");
                            } else {
                                ql2.d("3");
                            }
                        }
                    } else if (va3.a()) {
                        u63.f("backtohome", "relaunch", yo2.U().g());
                    } else {
                        zt2.e().m();
                        zt2.e().l(false);
                        n32.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        ql2.d("3");
                        v93.s(Z);
                        v93.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        l93.d().i("na_page_show");
                    }
                    l93.d().i("frame_new_intent");
                    l33 q2 = k33.K().q();
                    q2.e0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.Q();
                    if (q) {
                        v82.k().w();
                    }
                    ea3.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    gj3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    @NonNull
    public g03.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (g03.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t33, com.baidu.tieba.o33
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.kg2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.a();
    }

    @Override // com.baidu.tieba.kg2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l02.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            r22 m = this.c.m();
            if (m == null || !m.I()) {
                if (e0()) {
                    l33 M = l33.M();
                    if (M != null) {
                        M.P().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, l33.g0());
                    yo2.U().u(new nd2(hashMap));
                    l02.i("SwanAppFrame", "onBack");
                    zo2.a().d(false);
                    return;
                }
                z93.f(UUID.randomUUID().toString(), 1);
                vf3.a(c0(), this.b);
                u22.b i2 = this.c.i("navigateBack");
                i2.n(u22.i, u22.h);
                i2.g();
                i2.a();
            }
        }
    }

    public final void l1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.b();
    }

    @Override // com.baidu.tieba.kg2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            uf3.a(this.b);
            if (y12.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            l93.d().a();
            l93.d().i("frame_create");
            zt2.e().l(true);
            zt2.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final boolean m1(io2 io2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, io2Var)) == null) {
            if (io2Var != null && !kz2.B(io2Var)) {
                if (io2Var.G() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData Q = k33.K().q().Q();
                if (Q == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!hm2.e.i(io2Var.H(), io2Var.v1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !a73.q(io2Var, Q);
                }
            }
            if (q) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = i != 2 ? i != 3 ? "virtual" : "gesture" : "click";
            na3 na3Var = new na3();
            na3Var.e = "back";
            u22 u22Var = this.c;
            boolean z = true;
            na3Var.g = (u22Var == null || u22Var.k() <= 1) ? false : false ? "1" : "0";
            na3Var.b = str;
            u93.a(na3Var, Z());
            u93.c(na3Var);
        }
    }

    @Override // com.baidu.tieba.kg2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s73.j();
            s73.h();
            zt2.e().o();
            sm2.a0().a();
            yo2.U().unregisterReceiver(this.b);
        }
    }

    public final tg2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (tg2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? io2.m1(Z(), yo2.U().s()) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kg2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Inject(force = false)
    public final f q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kg2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (rg2.b().c()) {
                    rg2.b().f(this.b, new c(this));
                    return true;
                }
                u22 u22Var = this.c;
                if (u22Var != null && u22Var.k() == 1) {
                    sg2 sg2Var = new sg2();
                    sg2Var.h();
                    if (sg2Var.j()) {
                        tg2.a().c(this.b, sg2Var.f(), sg2Var.e(), sg2Var, o1());
                        return true;
                    }
                    zt2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k33.K().q().y0()) {
                l02.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            v93.z();
            if (E()) {
                t1();
                io2.a Z = Z();
                if (m1(Z)) {
                    if (q) {
                        Log.i("SwanAppFrame", "start load aiapps sync ");
                    }
                    yo2.U().d(Z, null);
                    return;
                }
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps async ");
                }
                yo2.U().E(Z, null);
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (fa2.U().W() != null) {
                fa2.U().W().attachActivity(this.b);
            }
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            k33 K = k33.K();
            if (K.E()) {
                io2.a Y = K.q().Y();
                String T = Y.T();
                String U = Y.U();
                if (TextUtils.isEmpty(Y.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                n33 U2 = q().U();
                if (U2.b(Y.T())) {
                    return !U2.c(T, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            io2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (ah3.f(Z.a0())) {
                fa2.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = fa2.U().T();
                ExtensionCore O = Z.O();
                boolean z = false;
                boolean z2 = j0 != null && ah3.f(j0.swanCoreVersionName) && ho2.a(Z.S());
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && ho2.b(Z.S())) {
                    z = true;
                }
                if (z2 || z) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    fa2.N0(true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            ex2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            io2.a Z = Z();
            return (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) ? yo2.U().g() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kg2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            io2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(qc3.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    @Override // com.baidu.tieba.kg2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kg2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            qw2.o().F(new UbcFlowEvent("frame_start_end"));
            l93.d().i("frame_start_end");
        }
    }
}
