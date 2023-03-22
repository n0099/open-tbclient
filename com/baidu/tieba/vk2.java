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
import com.baidu.tieba.bl2;
import com.baidu.tieba.c72;
import com.baidu.tieba.o43;
import com.baidu.tieba.pq2;
import com.baidu.tieba.qs2;
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
public class vk2 extends sk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sk2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.sk2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.b83, com.baidu.tieba.w73
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sk2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tieba.sk2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.sk2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk2 a;

        public a(vk2 vk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && ck3.d(this.a.b)) {
                ac3.g();
                gt2.U().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(vk2 vk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk2Var};
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
                pz2.g().y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements f92<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk2 a;

        public c(vk2 vk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f92
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements bl2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk2 a;

        public d(vk2 vk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk2Var;
        }

        @Override // com.baidu.tieba.bl2.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.moveTaskToBack(true);
                vl3.b().e(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements o43.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk2 a;

        public e(vk2 vk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk2Var;
        }

        @Override // com.baidu.tieba.o43.c
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
                                                    zj3.r(message);
                                                    return true;
                                                case 124:
                                                    zj3.q(message);
                                                    return true;
                                                case 125:
                                                    m43.b(message);
                                                    return true;
                                                default:
                                                    return false;
                                            }
                                        }
                                        va2.a(message);
                                        return true;
                                    }
                                    s73.K().s();
                                    return true;
                                }
                                t73 M = t73.M();
                                if (M != null) {
                                    M.e0().i();
                                    pz2.g().v();
                                }
                                this.a.Q0();
                                this.a.k1();
                                return true;
                            }
                            boolean a = ar2.M().a();
                            ar2.M().d(a);
                            if (this.a.b != null) {
                                this.a.b.z(a, false);
                            }
                            return true;
                        }
                        int p = zj3.m().p();
                        t42.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                        if (this.a.b != null && this.a.b.g0() && p != -1 && this.a.b.getTaskId() != p) {
                            t42.i("SwanAppFrame", "resetCore: purgeSwanApp");
                            s73.K().s();
                        }
                        return true;
                    }
                    int d = px2.d();
                    int a2 = px2.a(d);
                    if (!px2.f()) {
                        ox2.a(Integer.valueOf(d), String.valueOf(a2));
                    }
                    return true;
                }
                j43.e().h(new l43(4));
                this.a.Q0();
                this.a.l1();
                s73.K().s();
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
                pg3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948243596, "Lcom/baidu/tieba/vk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948243596, "Lcom/baidu/tieba/vk2;");
                return;
            }
        }
        q = do1.a;
    }

    @Override // com.baidu.tieba.sk2
    @NonNull
    public o43.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new e(this);
        }
        return (o43.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sk2
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

    @Override // com.baidu.tieba.sk2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ac3.j();
            ac3.h();
            hy2.e().o();
            ar2.a0().a();
            gt2.U().unregisterReceiver(this.b);
        }
    }

    public final bl2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new d(this);
        }
        return (bl2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return qs2.m1(Z(), gt2.U().s());
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

    @Override // com.baidu.tieba.sk2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (ne2.U().W() != null) {
                ne2.U().W().attachActivity(this.b);
            }
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            m13.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    @Override // com.baidu.tieba.sk2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    @Override // com.baidu.tieba.sk2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            y03.o().F(new UbcFlowEvent("frame_start_end"));
            td3.d().i("frame_start_end");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vk2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.sk2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.sk2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            t42.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = tk3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                de3.w();
                hy2.e().l(z2);
                HybridUbcFlow p = y03.p("startup");
                qs2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    dd2.k().x(Z.H(), true);
                    le3.d(2);
                    String str = "relaunch";
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            cb3.f("backtohome", "message", v1);
                        } else {
                            boolean i = cb3.i(v1);
                            de3.u(v1, Z);
                            v72.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = ga3.b().a(tx2.d(v1, gt2.U().z()));
                            if (a2) {
                                str = "message";
                            }
                            cb3.f("backtohome", str, v1);
                            if (i && !a2) {
                                cb3.q("reLaunch");
                                fz1.d().i();
                                yp2.d("2");
                            } else {
                                yp2.d("3");
                            }
                        }
                    } else if (df3.a()) {
                        cb3.f("backtohome", "relaunch", gt2.U().g());
                    } else {
                        hy2.e().m();
                        hy2.e().l(false);
                        v72.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        yp2.d("3");
                        de3.s(Z);
                        de3.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        td3.d().i("na_page_show");
                    }
                    td3.d().i("frame_new_intent");
                    t73 q2 = s73.K().q();
                    q2.e0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.Q();
                    if (q) {
                        dd2.k().w();
                    }
                    me3.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    on3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.baidu.tieba.sk2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            t42.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            z62 m = this.c.m();
            if (m != null && m.I()) {
                return;
            }
            if (e0()) {
                t73 M = t73.M();
                if (M != null) {
                    M.P().E();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, t73.g0());
                gt2.U().u(new vh2(hashMap));
                t42.i("SwanAppFrame", "onBack");
                ht2.a().d(false);
                return;
            }
            he3.f(UUID.randomUUID().toString(), 1);
            dk3.a(c0(), this.b);
            c72.b i2 = this.c.i("navigateBack");
            i2.n(c72.i, c72.h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.tieba.sk2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            ck3.a(this.b);
            if (g62.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            td3.d().a();
            td3.d().i("frame_create");
            hy2.e().l(true);
            hy2.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (s73.K().q().y0()) {
                t42.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            de3.z();
            if (!E()) {
                return;
            }
            t1();
            qs2.a Z = Z();
            if (m1(Z)) {
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                gt2.U().d(Z, null);
                return;
            }
            if (q) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            gt2.U().E(Z, null);
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            s73 K = s73.K();
            if (!K.E()) {
                return false;
            }
            qs2.a Y = K.q().Y();
            String T = Y.T();
            String U = Y.U();
            if (TextUtils.isEmpty(Y.T()) || TextUtils.equals(T, U)) {
                return false;
            }
            v73 U2 = q().U();
            if (!U2.b(Y.T())) {
                return true;
            }
            return !U2.c(T, Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean m1(qs2 qs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, qs2Var)) == null) {
            if (qs2Var != null && !s33.B(qs2Var)) {
                if (qs2Var.G() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData Q = s73.K().q().Q();
                if (Q == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!pq2.e.i(qs2Var.H(), qs2Var.v1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !ib3.q(qs2Var, Q);
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
                    str = "gesture";
                }
            } else {
                str = "click";
            }
            ve3 ve3Var = new ve3();
            ve3Var.e = "back";
            c72 c72Var = this.c;
            boolean z = true;
            if ((c72Var == null || c72Var.k() <= 1) ? false : false) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            ve3Var.g = str2;
            ve3Var.b = str;
            ce3.a(ve3Var, Z());
            ce3.c(ve3Var);
        }
    }

    @Override // com.baidu.tieba.sk2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (zk2.b().c()) {
                    zk2.b().f(this.b, new c(this));
                    return true;
                }
                c72 c72Var = this.c;
                if (c72Var != null && c72Var.k() == 1) {
                    al2 al2Var = new al2();
                    al2Var.h();
                    if (al2Var.j()) {
                        bl2.a().c(this.b, al2Var.f(), al2Var.e(), al2Var, o1());
                        return true;
                    }
                    hy2.e().g();
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
            qs2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (il3.f(Z.a0())) {
                ne2.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = ne2.U().T();
                ExtensionCore O = Z.O();
                boolean z2 = false;
                if (j0 != null && il3.f(j0.swanCoreVersionName) && ps2.a(Z.S())) {
                    z = true;
                } else {
                    z = false;
                }
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && ps2.b(Z.S())) {
                    z2 = true;
                }
                if (z || z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    ne2.N0(true);
                }
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            qs2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(yg3.g(0));
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
            qs2.a Z = Z();
            if (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) {
                return gt2.U().g();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
