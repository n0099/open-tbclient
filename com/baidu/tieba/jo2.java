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
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.c83;
import com.baidu.tieba.du2;
import com.baidu.tieba.ew2;
import com.baidu.tieba.po2;
import com.baidu.tieba.qa2;
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
/* loaded from: classes6.dex */
public class jo2 extends go2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.go2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.go2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pb3, com.baidu.tieba.kb3
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.go2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tieba.go2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.go2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;

        public a(jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && qn3.d(this.a.b)) {
                of3.g();
                uw2.T().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo2Var};
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
                d33.g().y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements tc2<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;

        public c(jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements po2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;

        public d(jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo2Var;
        }

        @Override // com.baidu.tieba.po2.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.moveTaskToBack(true);
                jp3.b().e(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements c83.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;

        public e(jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo2Var;
        }

        @Override // com.baidu.tieba.c83.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i != 127) {
                        if (i != 129) {
                            if (i != 102) {
                                if (i != 103) {
                                    if (i != 106) {
                                        if (i != 107) {
                                            switch (i) {
                                                case 123:
                                                    nn3.r(message);
                                                    return true;
                                                case 124:
                                                    nn3.q(message);
                                                    return true;
                                                case 125:
                                                    a83.b(message);
                                                    return true;
                                                default:
                                                    return false;
                                            }
                                        }
                                        je2.a(message);
                                        return true;
                                    }
                                    gb3.K().s();
                                    return true;
                                }
                                hb3 M = hb3.M();
                                if (M != null) {
                                    M.e0().i();
                                    d33.g().v();
                                }
                                this.a.Q0();
                                this.a.k1();
                                return true;
                            }
                            boolean a = ou2.M().a();
                            ou2.M().d(a);
                            if (this.a.b != null) {
                                this.a.b.y(a, false);
                            }
                            return true;
                        }
                        int p = nn3.m().p();
                        h82.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                        if (this.a.b != null && this.a.b.f0() && p != -1 && this.a.b.getTaskId() != p) {
                            h82.i("SwanAppFrame", "resetCore: purgeSwanApp");
                            gb3.K().s();
                        }
                        return true;
                    }
                    int d = d13.d();
                    int a2 = d13.a(d);
                    if (!d13.f()) {
                        c13.a(Integer.valueOf(d), String.valueOf(a2));
                    }
                    return true;
                }
                x73.e().h(new z73(4));
                this.a.Q0();
                this.a.l1();
                gb3.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dk3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889948, "Lcom/baidu/tieba/jo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889948, "Lcom/baidu/tieba/jo2;");
                return;
            }
        }
        q = rr1.a;
    }

    @Override // com.baidu.tieba.go2
    @NonNull
    public c83.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new e(this);
        }
        return (c83.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.go2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (q1 = q1()) != null) {
            q1.a();
        }
    }

    public final void l1() {
        f q1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (q1 = q1()) != null) {
            q1.b();
        }
    }

    @Override // com.baidu.tieba.go2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            of3.j();
            of3.h();
            v13.e().o();
            ou2.a0().a();
            uw2.T().unregisterReceiver(this.b);
        }
    }

    public final po2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new d(this);
        }
        return (po2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return ew2.m1(Z(), uw2.T().s());
        }
        return (String) invokeV.objValue;
    }

    @Inject(force = false)
    public final f q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return new f();
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.go2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (bi2.U().W() != null) {
                bi2.U().W().attachActivity(this.b);
            }
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            a53.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    @Override // com.baidu.tieba.go2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    @Override // com.baidu.tieba.go2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            m43.o().F(new UbcFlowEvent("frame_start_end"));
            hh3.d().i("frame_start_end");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.go2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.go2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            h82.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = ho3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                rh3.w();
                v13.e().l(z2);
                HybridUbcFlow p = m43.p("startup");
                ew2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    rg2.k().x(Z.H(), true);
                    zh3.d(2);
                    String str = "relaunch";
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            qe3.f("backtohome", "message", v1);
                        } else {
                            boolean i = qe3.i(v1);
                            rh3.u(v1, Z);
                            jb2.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = ud3.b().a(h13.d(v1, uw2.T().z()));
                            if (a2) {
                                str = "message";
                            }
                            qe3.f("backtohome", str, v1);
                            if (i && !a2) {
                                qe3.q("reLaunch");
                                t22.d().i();
                                mt2.d("2");
                            } else {
                                mt2.d("3");
                            }
                        }
                    } else if (ri3.a()) {
                        qe3.f("backtohome", "relaunch", uw2.T().g());
                    } else {
                        v13.e().m();
                        v13.e().l(false);
                        jb2.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        mt2.d("3");
                        rh3.s(Z);
                        rh3.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        hh3.d().i("na_page_show");
                    }
                    hh3.d().i("frame_new_intent");
                    hb3 q2 = gb3.K().q();
                    q2.e0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.Q();
                    if (q) {
                        rg2.k().w();
                    }
                    ai3.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    cr3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.baidu.tieba.go2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            h82.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            na2 m = this.c.m();
            if (m != null && m.H()) {
                return;
            }
            if (e0()) {
                hb3 M = hb3.M();
                if (M != null) {
                    M.P().E();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, hb3.g0());
                uw2.T().u(new jl2(hashMap));
                h82.i("SwanAppFrame", "onBack");
                vw2.a().d(false);
                return;
            }
            vh3.f(UUID.randomUUID().toString(), 1);
            rn3.a(c0(), this.b);
            qa2.b i2 = this.c.i("navigateBack");
            i2.n(qa2.i, qa2.h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.tieba.go2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            qn3.a(this.b);
            if (u92.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            hh3.d().a();
            hh3.d().i("frame_create");
            v13.e().l(true);
            v13.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (gb3.K().q().y0()) {
                h82.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            rh3.z();
            if (!E()) {
                return;
            }
            t1();
            ew2.a Z = Z();
            if (m1(Z)) {
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                uw2.T().d(Z, null);
                return;
            }
            if (q) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            uw2.T().E(Z, null);
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            gb3 K = gb3.K();
            if (!K.E()) {
                return false;
            }
            ew2.a Y = K.q().Y();
            String T2 = Y.T();
            String U = Y.U();
            if (TextUtils.isEmpty(Y.T()) || TextUtils.equals(T2, U)) {
                return false;
            }
            jb3 U2 = q().U();
            if (!U2.b(Y.T())) {
                return true;
            }
            return !U2.c(T2, Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean m1(ew2 ew2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ew2Var)) == null) {
            if (ew2Var != null && !g73.B(ew2Var)) {
                if (ew2Var.G() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData Q = gb3.K().q().Q();
                if (Q == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!du2.e.i(ew2Var.H(), ew2Var.v1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !we3.q(ew2Var, Q);
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
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i != 2) {
                if (i != 3) {
                    str = "virtual";
                } else {
                    str = AppFrameworkConstants.VALUE_GESTURE_BACK;
                }
            } else {
                str = "click";
            }
            ji3 ji3Var = new ji3();
            ji3Var.e = "back";
            qa2 qa2Var = this.c;
            boolean z = true;
            if ((qa2Var == null || qa2Var.k() <= 1) ? false : false) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            ji3Var.g = str2;
            ji3Var.b = str;
            qh3.a(ji3Var, Z());
            qh3.c(ji3Var);
        }
    }

    @Override // com.baidu.tieba.go2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (no2.b().c()) {
                    no2.b().f(this.b, new c(this));
                    return true;
                }
                qa2 qa2Var = this.c;
                if (qa2Var != null && qa2Var.k() == 1) {
                    oo2 oo2Var = new oo2();
                    oo2Var.h();
                    if (oo2Var.j()) {
                        po2.a().c(this.b, oo2Var.f(), oo2Var.e(), oo2Var, o1());
                        return true;
                    }
                    v13.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void t1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ew2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (wo3.f(Z.a0())) {
                bi2.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T2 = bi2.U().T();
                ExtensionCore O = Z.O();
                boolean z2 = false;
                if (j0 != null && wo3.f(j0.swanCoreVersionName) && dw2.a(Z.S())) {
                    z = true;
                } else {
                    z = false;
                }
                if (T2 != null && O != null && T2.extensionCoreVersionCode < O.extensionCoreVersionCode && dw2.b(Z.S())) {
                    z2 = true;
                }
                if (z || z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    bi2.N0(true);
                }
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ew2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(mk3.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ew2.a Z = Z();
            if (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) {
                return uw2.T().g();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
