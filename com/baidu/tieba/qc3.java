package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static HashMap<String, String> h;
    public static String i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove("page_display_flag_for_statistic");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(jd3 jd3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(zc3.k(this.b));
                this.a.d(this.c);
                zc3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(jd3 jd3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d(this.b);
                this.a.b(zc3.k(this.c));
                zc3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(jd3 jd3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(zc3.k(this.b));
                this.a.d(this.c);
                zc3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements zk3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public e(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.a.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                zc3.onEvent(this.a);
                g32.k("SwanAppLaunchUbc", jSONObject.toString());
                np2.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086984, "Lcom/baidu/tieba/qc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086984, "Lcom/baidu/tieba/qc3;");
                return;
            }
        }
        a = rm1.a;
        b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
    }

    public static synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (qc3.class) {
                z = b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return d;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return f;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return e;
        }
        return invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return g;
        }
        return invokeV.booleanValue;
    }

    public static void r() {
        g63 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65562, null) != null) || (M = g63.M()) == null) {
            return;
        }
        s(M.X());
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            B(false);
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            A(false);
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            C(false);
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, null) == null) {
            y();
            D(false);
            x();
            w();
            E(false);
        }
    }

    public static synchronized void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            synchronized (qc3.class) {
                c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (qc3.class) {
                d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (qc3.class) {
                b = z;
            }
        }
    }

    public static void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f = z;
        }
    }

    public static void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            e = z;
        }
    }

    public static void o(dr2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, aVar) == null) && aVar != null && !f) {
            D(true);
            k(aVar, "naarrsuccess");
        }
    }

    public static void q(dr2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, aVar) == null) && aVar != null && !g()) {
            B(true);
            k(aVar, "arrivecancel");
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && g) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            tw2.e(str);
            g = false;
        }
    }

    public static void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (h == null) {
                h = new HashMap<>();
            }
            h.put(str, str2);
        }
    }

    public static void k(dr2.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void G() {
        p52 W;
        ns1 v3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, null) != null) || (W = tr2.V().W()) == null) {
            return;
        }
        m52 m = W.m();
        if ((m instanceof o52) && (v3 = ((o52) m).v3()) != null) {
            i = v3.a();
        }
    }

    public static void H() {
        HybridUbcFlow d2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || (d2 = lz2.d("startup")) == null) {
            return;
        }
        if (!d2.w() && !d2.t()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            d2.E("value", "fe_success");
        }
    }

    public static void a(ys1 ys1Var) {
        g63 M;
        dr2.a X;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, ys1Var) != null) || f() || g() || ys1Var == null || (M = g63.M()) == null || (X = M.X()) == null) {
            return;
        }
        if (a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(X, ys1Var.b, "0", ys1Var.c, b(ys1Var.g), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 1) {
                return "2";
            }
            if (c2 == 2) {
                return "3";
            }
            if (c2 != 3) {
                return "0";
            }
            return "4";
        }
        return (String) invokeL.objValue;
    }

    public static void d(@NonNull dr2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            jd3 jd3Var = new jd3();
            jd3Var.a = zc3.n(0);
            jd3Var.b = "launch";
            jd3Var.e = "narendersuccess";
            jd3Var.h(aVar);
            zz2.e().d(new d(jd3Var, aVar.X(), aVar.t0().getString("ubc")), "handleNaRenderSuccess", true);
        }
    }

    public static void v(@NonNull dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, dr2Var) == null) {
            jd3 jd3Var = new jd3();
            jd3Var.a = zc3.n(0);
            jd3Var.f = dr2Var.I();
            jd3Var.c = dr2Var.U();
            jd3Var.b = "show";
            zz2.e().d(new b(jd3Var, dr2Var.X(), dr2Var.t0().getString("ubc")), "onShow606", true);
        }
    }

    public static void c(dr2.a aVar, long j, String str, long j2, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{aVar, Long.valueOf(j), str, Long.valueOf(j2), str2, Boolean.valueOf(z)}) == null) && aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            A(true);
            if (z || j > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("valuetype", str);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                l(aVar, "arrivesuccess", j, jSONObject);
            }
            if (z || j2 > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("valuetype", str2);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                l(aVar, "fmparrsuccess", j2, jSONObject2);
            }
        }
    }

    public static void l(dr2.a aVar, String str, long j, JSONObject jSONObject) {
        String I;
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, str, Long.valueOf(j), jSONObject}) == null) && (I = aVar.I()) != null && aVar != null) {
            long j2 = 0;
            if (j != -1) {
                long l = aVar.l("launch_time", 0L);
                if (j <= 0) {
                    j = System.currentTimeMillis();
                }
                j2 = j - l;
            }
            jd3 jd3Var = new jd3();
            jd3Var.a = zc3.n(aVar.H());
            jd3Var.f = I;
            if (x32.d()) {
                jd3Var.c = "remote-debug";
            } else if (f23.D()) {
                jd3Var.c = "local-debug";
            } else {
                jd3Var.c = aVar.U();
            }
            jd3Var.b = "launch";
            jd3Var.e = str;
            jd3Var.a("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                jd3Var.e(jSONObject);
            }
            Bundle Q = aVar.Q();
            if (Q != null) {
                jd3Var.d(Q.getString("ubc"));
            }
            jd3Var.b(zc3.k(aVar.X()));
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("handle record arrival event, arrivalValue ");
                sb.append(str);
                sb.append(" arrive time : ");
                sb.append(j2);
                sb.append(" extJson :");
                if (jSONObject == null) {
                    jSONObject2 = "";
                } else {
                    jSONObject2 = jSONObject.toString();
                }
                sb.append(jSONObject2);
                Log.d("SwanAppLaunchUbc", sb.toString());
            }
            zc3.onEvent(jd3Var);
        }
    }

    public static void m(@NonNull dr2 dr2Var, int i2, @NonNull zh3 zh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, dr2Var, i2, zh3Var) == null) {
            jd3 jd3Var = new jd3();
            jd3Var.a = zc3.n(i2);
            jd3Var.b = "launch";
            jd3Var.e = "fail";
            jd3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, String.valueOf(zh3Var.a()));
            jd3Var.a("msg", zh3Var.g().toString());
            jd3Var.h(dr2Var);
            jd3Var.d(dr2Var.t0().getString("ubc"));
            jd3Var.b(zc3.k(dr2Var.X()));
            wi3.d(dr2Var, new e(jd3Var));
        }
    }

    public static void n(jd3 jd3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, jd3Var, str, str2) == null) {
            zz2.e().d(new c(jd3Var, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void p(dr2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            if (a) {
                Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
            }
            tw2.e(i);
            if (!i()) {
                d(aVar);
            }
            if (!f() && !g()) {
                c(aVar, -1L, "1", -1L, "1", true);
            }
        }
    }

    public static void s(dr2 dr2Var) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, null, dr2Var) == null) && dr2Var != null && e() && (Q = dr2Var.Q()) != null) {
            long j = Q.getLong("page_display_flag_for_statistic");
            long l = dr2Var.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0) {
                jd3 jd3Var = new jd3();
                jd3Var.a = zc3.n(dr2Var.H());
                jd3Var.f = dr2Var.I();
                jd3Var.c = dr2Var.U();
                jd3Var.b = "launch";
                jd3Var.e = "realsuccess";
                jd3Var.r = String.valueOf(currentTimeMillis - l);
                jd3Var.d(Q.getString("ubc"));
                zc3.onEvent(jd3Var);
                ak3.e0(new a(Q));
                H();
            }
        }
    }

    public static void u(String str, dr2.a aVar) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, aVar) == null) {
            HashMap<String, String> hashMap = h;
            String str3 = "";
            if (hashMap == null) {
                str2 = "";
            } else {
                str2 = hashMap.get(i);
            }
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("handle relaunch , launchPage : ");
                sb.append(str);
                sb.append(" lastSlavePath ：");
                if (str2 != null) {
                    str3 = str2;
                }
                sb.append(str3);
                Log.d("SwanAppLaunchUbc", sb.toString());
            }
            if (TextUtils.equals(str, str2)) {
                p(aVar);
                return;
            }
            x();
            g = true;
        }
    }
}
