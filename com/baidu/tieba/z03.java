package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class z03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Timer b;
    public static String c;
    @Deprecated
    public static volatile t03 d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        /* loaded from: classes7.dex */
        public class a implements om3<j83> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.om3
            /* renamed from: a */
            public j83 create() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return ht2.U().f(this.a);
                }
                return (j83) invokeV.objValue;
            }
        }

        public b(rs2 rs2Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String T;
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow p = z03.p("startup");
                if (TextUtils.isEmpty(this.a.T())) {
                    T = "NA";
                } else {
                    T = this.a.T();
                }
                if (this.a.G() == 1) {
                    p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                }
                String str4 = "swan";
                p.E("from", "swan");
                p.E("source", T);
                p.D("appid", this.a.H());
                p.D("swan", zg3.i(this.a.j0(), this.a.G()));
                p.D("mobile", kk3.c());
                long l = this.a.l("box_cold_launch", -1L);
                if (l < 0) {
                    l = u03.c();
                }
                if (l > 0) {
                    p.D("box_cold_launch", String.valueOf(l));
                }
                p.D("net", SwanAppNetworkUtils.f().type);
                p.D("appversion", this.a.v1());
                p.D("thirdversion", this.a.w1());
                String str5 = "1";
                if (ex1.i()) {
                    str = "1";
                } else {
                    str = "0";
                }
                p.D("useNaRequest", str);
                if (this.a.G() == 1) {
                    str4 = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
                }
                p.E("from", str4);
                p.D("scheme", this.a.W());
                HashSet hashSet = new HashSet();
                hashSet.add(WebChromeClient.KEY_ARG_CALLBACK);
                hashSet.add("upgrade");
                String i = ml3.i(this.b, hashSet);
                if (!TextUtils.isEmpty(i) && i.startsWith(File.separator)) {
                    i = i.substring(1);
                }
                if (TextUtils.isEmpty(i)) {
                    str2 = "";
                } else {
                    str2 = i;
                }
                p.D("path", str2);
                if (z03.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PerformanceUbc path: ");
                    if (TextUtils.isEmpty(i)) {
                        i = "";
                    }
                    sb.append(i);
                    Log.v("SwanAppPerformanceUBC", sb.toString());
                }
                p.D("view_mode", ((j83) lm3.b(new a(this, ml3.f(this.b)))).r);
                if (this.c) {
                    p.E("value", "arrive_success");
                }
                p.D("launchid", this.a.V());
                p.D("isPreDownloading", this.a.s0().getString("aiapp_extra_pkg_downloading", "0"));
                if (this.a.c("launch_by_reload")) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                p.D("isReloadApp", str3);
                p.D("preAppReadyState", String.valueOf(je2.a(this.a)));
                if (this.a.G() == 0) {
                    if (!zx2.g().h(this.a.f0())) {
                        str5 = "0";
                    }
                    p.D("is_opti", str5);
                    p.A();
                }
                u42.k("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;
        public final /* synthetic */ boolean b;

        public a(rs2 rs2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z03.i(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z03.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends we3 {
        public static /* synthetic */ Interceptable $ic = null;
        public static int n = 35;
        public transient /* synthetic */ FieldHolder $fh;
        public final String k;
        public JSONObject l;
        public boolean m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-283605588, "Lcom/baidu/tieba/z03$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-283605588, "Lcom/baidu/tieba/z03$d;");
            }
        }

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.m = true;
            this.k = str;
        }

        @Override // com.baidu.tieba.we3
        public JSONObject f() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.c)) {
                    str = "NA";
                } else {
                    str = this.c;
                }
                this.c = str;
                if (this.h == null) {
                    this.h = new JSONObject();
                }
                try {
                    if (this.l != null) {
                        if (this.m) {
                            String z = ol3.z(n);
                            if (!TextUtils.isEmpty(z)) {
                                this.l.put("stacktrace", z);
                            }
                        }
                        this.h.put("info", this.l);
                    }
                } catch (JSONException e) {
                    if (we3.j) {
                        e.printStackTrace();
                    }
                }
                return super.f();
            }
            return (JSONObject) invokeV.objValue;
        }

        public d g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (d) invokeL.objValue;
        }

        public d i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (d) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948306092, "Lcom/baidu/tieba/z03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948306092, "Lcom/baidu/tieba/z03;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            Timer timer = new Timer();
            b = timer;
            timer.schedule(new c(), 15000L);
        }
    }

    @Deprecated
    public static synchronized HybridUbcFlow o() {
        InterceptResult invokeV;
        HybridUbcFlow p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            synchronized (z03.class) {
                p = p("startup");
            }
            return p;
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public static void t() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, null) == null) && (timer = b) != null) {
            timer.cancel();
            b = null;
        }
    }

    public static synchronized HybridUbcFlow e(String str, String str2) {
        InterceptResult invokeLL;
        HybridUbcFlow c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            synchronized (z03.class) {
                c2 = f().c(str, str2);
            }
            return c2;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public static synchronized void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            synchronized (z03.class) {
                HybridUbcFlow b2 = f().b(str);
                if (b2 != null) {
                    f().e(str2).z(b2);
                    r(str);
                }
            }
        }
    }

    public static void i(rs2 rs2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, rs2Var, z) == null) {
            u42.k("SwanAppPerformanceUBC", "recordForStartup");
            if (rs2Var == null || rs2Var.P() == null) {
                return;
            }
            ok3.j(new b(rs2Var, c(rs2Var), z), "recordFromLaunchInfo");
        }
    }

    public static void j(rs2 rs2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, rs2Var, z) == null) {
            t73.M().post(new a(rs2Var, z));
        }
    }

    public static synchronized HybridUbcFlow q(String str, String str2) {
        InterceptResult invokeLL;
        HybridUbcFlow f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) {
            synchronized (z03.class) {
                f = f().f(str, str2);
            }
            return f;
        }
        return (HybridUbcFlow) invokeLL.objValue;
    }

    public static synchronized void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (z03.class) {
                f().h(str, str2);
            }
        }
    }

    public static String c(rs2 rs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rs2Var)) == null) {
            String e0 = rs2Var.e0();
            if (TextUtils.isEmpty(e0)) {
                if (TextUtils.isEmpty(c)) {
                    c = fb3.c();
                    if (a) {
                        Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + c);
                    }
                } else if (a) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + c);
                }
            } else {
                c = e0;
                if (a) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + c);
                }
            }
            return c;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void l(String str) {
        char c2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            switch (str.hashCode()) {
                case -952207494:
                    if (str.equals("independent")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -533350585:
                    if (str.equals("subNormal")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -285446714:
                    if (str.equals("dynamicLib")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3343801:
                    if (str.equals("main")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            str2 = "-1";
                        } else {
                            str2 = "3";
                        }
                    } else {
                        str2 = "1";
                    }
                } else {
                    str2 = "2";
                }
            } else {
                str2 = "0";
            }
            p("startup").D("package_type", str2);
        }
    }

    public static synchronized HybridUbcFlow d(String str) {
        InterceptResult invokeL;
        HybridUbcFlow b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            synchronized (z03.class) {
                b2 = f().b(str);
            }
            return b2;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public static synchronized HybridUbcFlow p(String str) {
        InterceptResult invokeL;
        HybridUbcFlow e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            synchronized (z03.class) {
                e = f().e(str);
            }
            return e;
        }
        return (HybridUbcFlow) invokeL.objValue;
    }

    public static synchronized void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            synchronized (z03.class) {
                f().g(str);
            }
        }
    }

    public static t03 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (d == null) {
                synchronized (t03.class) {
                    if (d == null) {
                        d = new t03();
                        g(d);
                    }
                }
            }
            return d;
        }
        return (t03) invokeV.objValue;
    }

    public static void g(t03 t03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, t03Var) == null) {
            t03Var.d("preload", new y13());
            t03Var.d("startup", new a23());
            t03Var.d("route", new z13());
            t03Var.d("video", new c23());
            t03Var.d(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB, new b23());
            t03Var.d(PrefetchEvent.MODULE, new uc2());
        }
    }

    public static synchronized void k(nj3 nj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, nj3Var) == null) {
            synchronized (z03.class) {
                HybridUbcFlow m = m();
                if (m != null) {
                    m.E("value", SmsLoginView.f.l);
                    if (nj3Var != null) {
                        m.D(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(nj3Var.a()));
                        m.D("launchid", t73.K().q().W().V());
                    }
                    m.n();
                }
            }
        }
    }

    public static synchronized HybridUbcFlow m() {
        InterceptResult invokeV;
        c72 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (z03.class) {
                t();
                zp2.a();
                HybridUbcFlow d2 = d("startup");
                au1 au1Var = null;
                if (d2 == null) {
                    return null;
                }
                d2.F(new UbcFlowEvent("performanceEnd"));
                if (!d2.s()) {
                    d2.A();
                }
                d72 V = ht2.U().V();
                if (V != null && (o = V.o()) != null) {
                    au1Var = o.r3();
                }
                d2.C(au1Var);
                if (!d2.x()) {
                    d2.T();
                }
                if (!d2.w()) {
                    d2.S();
                }
                return d2;
            }
        }
        return (HybridUbcFlow) invokeV.objValue;
    }

    public static void onEvent(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dVar) == null) {
            if (a) {
                Log.i("SwanAppPerformanceUBC", "onEvent " + dVar);
            }
            be3.k(dVar.k, dVar.f());
        }
    }
}
