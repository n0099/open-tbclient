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
import com.baidu.tieba.k23;
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
import com.baidu.tieba.xi2;
import com.baidu.tieba.y42;
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
/* loaded from: classes7.dex */
public class ri2 extends oi2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.oi2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oi2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.x53, com.baidu.tieba.s53
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.oi2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oi2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oi2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ri2 a;

        public a(ri2 ri2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ri2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && yh3.d(this.a.b)) {
                w93.g();
                cr2.V().E(this.a.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ri2 ri2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var};
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
                lx2.g().y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements b72<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ri2 a;

        public c(ri2 ri2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ri2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements xi2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ri2 a;

        public d(ri2 ri2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ri2Var;
        }

        @Override // com.baidu.tieba.xi2.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.moveTaskToBack(true);
                rj3.b().e(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements k23.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ri2 a;

        public e(ri2 ri2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ri2Var;
        }

        @Override // com.baidu.tieba.k23.c
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
                                                    vh3.r(message);
                                                    return true;
                                                case 124:
                                                    vh3.q(message);
                                                    return true;
                                                case 125:
                                                    i23.b(message);
                                                    return true;
                                                default:
                                                    return false;
                                            }
                                        }
                                        r82.a(message);
                                        return true;
                                    }
                                    o53.K().s();
                                    return true;
                                }
                                p53 M = p53.M();
                                if (M != null) {
                                    M.f0().i();
                                    lx2.g().v();
                                }
                                this.a.Q0();
                                this.a.l1();
                                return true;
                            }
                            boolean a = wo2.M().a();
                            wo2.M().d(a);
                            if (this.a.b != null) {
                                this.a.b.y(a, false);
                            }
                            return true;
                        }
                        int p = vh3.m().p();
                        p22.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                        if (this.a.b != null && this.a.b.f0() && p != -1 && this.a.b.getTaskId() != p) {
                            p22.i("SwanAppFrame", "resetCore: purgeSwanApp");
                            o53.K().s();
                        }
                        return true;
                    }
                    int d = lv2.d();
                    int a2 = lv2.a(d);
                    if (!lv2.f()) {
                        kv2.a(Integer.valueOf(d), String.valueOf(a2));
                    }
                    return true;
                }
                f23.e().h(new h23(4));
                this.a.Q0();
                this.a.m1();
                o53.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
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
                le3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948122510, "Lcom/baidu/tieba/ri2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948122510, "Lcom/baidu/tieba/ri2;");
                return;
            }
        }
        q = am1.a;
    }

    @Override // com.baidu.tieba.oi2
    @NonNull
    public k23.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new e(this);
        }
        return (k23.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void l1() {
        f r1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (r1 = r1()) != null) {
            r1.a();
        }
    }

    public final void m1() {
        f r1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (r1 = r1()) != null) {
            r1.b();
        }
    }

    @Override // com.baidu.tieba.oi2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            w93.j();
            w93.h();
            dw2.e().o();
            wo2.a0().a();
            cr2.V().l(this.b);
        }
    }

    public final xi2.b p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new d(this);
        }
        return (xi2.b) invokeV.objValue;
    }

    public final String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return mq2.n1(Z(), cr2.V().t());
        }
        return (String) invokeV.objValue;
    }

    @Inject(force = false)
    public final f r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new f();
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.s0();
            if (jc2.V().X() != null) {
                jc2.V().X().attachActivity(this.b);
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && t1()) {
            iz2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    @Override // com.baidu.tieba.oi2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    @Override // com.baidu.tieba.oi2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            uy2.o().F(new UbcFlowEvent("frame_start_end"));
            pb3.d().i("frame_start_end");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ri2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.oi2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.oi2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            p22.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String q1 = q1();
            JSONObject d2 = pi3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + q1);
            }
            String w1 = w1(q1);
            if (z) {
                zb3.w();
                dw2.e().l(z2);
                HybridUbcFlow p = uy2.p("startup");
                mq2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + w1);
                    }
                    za2.k().x(Z.I(), true);
                    hc3.d(2);
                    String str = "relaunch";
                    if (!TextUtils.isEmpty(w1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            y83.f("backtohome", "message", w1);
                        } else {
                            boolean i = y83.i(w1);
                            zb3.u(w1, Z);
                            r52.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = c83.b().a(pv2.d(w1, cr2.V().A()));
                            if (a2) {
                                str = "message";
                            }
                            y83.f("backtohome", str, w1);
                            if (i && !a2) {
                                y83.q("reLaunch");
                                cx1.d().i();
                                un2.d("2");
                            } else {
                                un2.d("3");
                            }
                        }
                    } else if (zc3.a()) {
                        y83.f("backtohome", "relaunch", cr2.V().g());
                    } else {
                        dw2.e().m();
                        dw2.e().l(false);
                        r52.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        un2.d("3");
                        zb3.s(Z);
                        zb3.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        pb3.d().i("na_page_show");
                    }
                    pb3.d().i("frame_new_intent");
                    p53 q2 = o53.K().q();
                    q2.f0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.R();
                    if (q) {
                        za2.k().w();
                    }
                    ic3.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    kl3.b("0");
                }
                v1();
            }
        }
    }

    @Override // com.baidu.tieba.oi2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            p22.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            o1(i);
            v42 m = this.c.m();
            if (m != null && m.G()) {
                return;
            }
            if (e0()) {
                p53 M = p53.M();
                if (M != null) {
                    M.Q().E();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, p53.h0());
                cr2.V().v(new rf2(hashMap));
                p22.i("SwanAppFrame", "onBack");
                dr2.a().d(false);
                return;
            }
            dc3.f(UUID.randomUUID().toString(), 1);
            zh3.a(c0(), this.b);
            y42.b i2 = this.c.i("navigateBack");
            i2.n(y42.i, y42.h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.tieba.oi2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setRequestedOrientation(1);
            yh3.a(this.b);
            if (c42.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            pb3.d().a();
            pb3.d().i("frame_create");
            dw2.e().l(true);
            dw2.e().n();
            x1();
            s1();
            V8Engine.setCrashKeyValue("app_title", Z().L());
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (o53.K().q().z0()) {
                p22.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            zb3.z();
            if (!E()) {
                return;
            }
            u1();
            mq2.a Z = Z();
            if (n1(Z)) {
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                cr2.V().d(Z, null);
                return;
            }
            if (q) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            cr2.V().G(Z, null);
        }
    }

    public final boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            o53 K = o53.K();
            if (!K.E()) {
                return false;
            }
            mq2.a Z = K.q().Z();
            String U = Z.U();
            String V = Z.V();
            if (TextUtils.isEmpty(Z.U()) || TextUtils.equals(U, V)) {
                return false;
            }
            r53 V2 = q().V();
            if (!V2.b(Z.U())) {
                return true;
            }
            return !V2.c(U, Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean n1(mq2 mq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mq2Var)) == null) {
            if (mq2Var != null && !o13.B(mq2Var)) {
                if (mq2Var.H() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData R = o53.K().q().R();
                if (R == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!lo2.e.i(mq2Var.I(), mq2Var.x1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !e93.q(mq2Var, R);
                }
            }
            if (q) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o1(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i != 2) {
                if (i != 3) {
                    str = "virtual";
                } else {
                    str = AppFrameworkConstants.VALUE_GESTURE_BACK;
                }
            } else {
                str = "click";
            }
            rc3 rc3Var = new rc3();
            rc3Var.e = "back";
            y42 y42Var = this.c;
            boolean z = true;
            if ((y42Var == null || y42Var.k() <= 1) ? false : false) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            rc3Var.g = str2;
            rc3Var.b = str;
            yb3.a(rc3Var, Z());
            yb3.c(rc3Var);
        }
    }

    @Override // com.baidu.tieba.oi2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (vi2.b().c()) {
                    vi2.b().f(this.b, new c(this));
                    return true;
                }
                y42 y42Var = this.c;
                if (y42Var != null && y42Var.k() == 1) {
                    wi2 wi2Var = new wi2();
                    wi2Var.h();
                    if (wi2Var.j()) {
                        xi2.a().c(this.b, wi2Var.f(), wi2Var.e(), wi2Var, p1());
                        return true;
                    }
                    dw2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void u1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            mq2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (ej3.f(Z.b0())) {
                jc2.O0(true);
            } else {
                SwanCoreVersion k0 = Z.k0();
                ExtensionCore U = jc2.V().U();
                ExtensionCore P = Z.P();
                boolean z2 = false;
                if (k0 != null && ej3.f(k0.swanCoreVersionName) && lq2.a(Z.T())) {
                    z = true;
                } else {
                    z = false;
                }
                if (U != null && P != null && U.extensionCoreVersionCode < P.extensionCoreVersionCode && lq2.b(Z.T())) {
                    z2 = true;
                }
                if (z || z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    jc2.O0(true);
                }
            }
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            mq2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.k0());
            }
            if (Z.k0() == null || !Z.k0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.a1(ue3.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.k0());
                }
            }
        }
    }

    public final String w1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            mq2.a Z = Z();
            if (TextUtils.isEmpty(str) && Z != null && h0(Z.I())) {
                return cr2.V().g();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
