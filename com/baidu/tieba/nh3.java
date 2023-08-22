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
import com.baidu.tieba.aw2;
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
public final class nh3 {
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
        public final /* synthetic */ gi3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(gi3 gi3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(wh3.k(this.b));
                this.a.d(this.c);
                wh3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(gi3 gi3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d(this.b);
                this.a.b(wh3.k(this.c));
                wh3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(gi3 gi3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(wh3.k(this.b));
                this.a.d(this.c);
                wh3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements wp3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;

        public e(gi3 gi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.a.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                wh3.onEvent(this.a);
                d82.k("SwanAppLaunchUbc", jSONObject.toString());
                ku2.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948002416, "Lcom/baidu/tieba/nh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948002416, "Lcom/baidu/tieba/nh3;");
                return;
            }
        }
        a = nr1.a;
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
            synchronized (nh3.class) {
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
        db3 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65562, null) != null) || (M = db3.M()) == null) {
            return;
        }
        s(M.W());
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
            synchronized (nh3.class) {
                c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (nh3.class) {
                d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (nh3.class) {
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

    public static void o(aw2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, aVar) == null) && aVar != null && !f) {
            D(true);
            k(aVar, "naarrsuccess");
        }
    }

    public static void q(aw2.a aVar) {
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
            q13.e(str);
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

    public static void k(aw2.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void G() {
        ma2 U;
        jx1 q3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, null) != null) || (U = qw2.T().U()) == null) {
            return;
        }
        ja2 m = U.m();
        if ((m instanceof la2) && (q3 = ((la2) m).q3()) != null) {
            i = q3.a();
        }
    }

    public static void H() {
        HybridUbcFlow d2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || (d2 = i43.d("startup")) == null) {
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

    public static void a(ux1 ux1Var) {
        db3 M;
        aw2.a W;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, ux1Var) != null) || f() || g() || ux1Var == null || (M = db3.M()) == null || (W = M.W()) == null) {
            return;
        }
        if (a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(W, ux1Var.b, "0", ux1Var.c, b(ux1Var.g), false);
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

    public static void d(@NonNull aw2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(0);
            gi3Var.b = "launch";
            gi3Var.e = "narendersuccess";
            gi3Var.h(aVar);
            w43.e().d(new d(gi3Var, aVar.W(), aVar.s0().getString("ubc")), "handleNaRenderSuccess", true);
        }
    }

    public static void v(@NonNull aw2 aw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, aw2Var) == null) {
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(0);
            gi3Var.f = aw2Var.H();
            gi3Var.c = aw2Var.T();
            gi3Var.b = "show";
            w43.e().d(new b(gi3Var, aw2Var.W(), aw2Var.s0().getString("ubc")), "onShow606", true);
        }
    }

    public static void c(aw2.a aVar, long j, String str, long j2, String str2, boolean z) {
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

    public static void l(aw2.a aVar, String str, long j, JSONObject jSONObject) {
        String H;
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, str, Long.valueOf(j), jSONObject}) == null) && (H = aVar.H()) != null && aVar != null) {
            long j2 = 0;
            if (j != -1) {
                long l = aVar.l("launch_time", 0L);
                if (j <= 0) {
                    j = System.currentTimeMillis();
                }
                j2 = j - l;
            }
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(aVar.G());
            gi3Var.f = H;
            if (u82.d()) {
                gi3Var.c = "remote-debug";
            } else if (c73.D()) {
                gi3Var.c = "local-debug";
            } else {
                gi3Var.c = aVar.T();
            }
            gi3Var.b = "launch";
            gi3Var.e = str;
            gi3Var.a("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                gi3Var.e(jSONObject);
            }
            Bundle P = aVar.P();
            if (P != null) {
                gi3Var.d(P.getString("ubc"));
            }
            gi3Var.b(wh3.k(aVar.W()));
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
            wh3.onEvent(gi3Var);
        }
    }

    public static void m(@NonNull aw2 aw2Var, int i2, @NonNull wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, aw2Var, i2, wm3Var) == null) {
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(i2);
            gi3Var.b = "launch";
            gi3Var.e = "fail";
            gi3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, String.valueOf(wm3Var.a()));
            gi3Var.a("msg", wm3Var.g().toString());
            gi3Var.h(aw2Var);
            gi3Var.d(aw2Var.s0().getString("ubc"));
            gi3Var.b(wh3.k(aw2Var.W()));
            tn3.d(aw2Var, new e(gi3Var));
        }
    }

    public static void n(gi3 gi3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, gi3Var, str, str2) == null) {
            w43.e().d(new c(gi3Var, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void p(aw2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            if (a) {
                Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
            }
            q13.e(i);
            if (!i()) {
                d(aVar);
            }
            if (!f() && !g()) {
                c(aVar, -1L, "1", -1L, "1", true);
            }
        }
    }

    public static void s(aw2 aw2Var) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, null, aw2Var) == null) && aw2Var != null && e() && (P = aw2Var.P()) != null) {
            long j = P.getLong("page_display_flag_for_statistic");
            long l = aw2Var.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0) {
                gi3 gi3Var = new gi3();
                gi3Var.a = wh3.n(aw2Var.G());
                gi3Var.f = aw2Var.H();
                gi3Var.c = aw2Var.T();
                gi3Var.b = "launch";
                gi3Var.e = "realsuccess";
                gi3Var.r = String.valueOf(currentTimeMillis - l);
                gi3Var.d(P.getString("ubc"));
                wh3.onEvent(gi3Var);
                xo3.e0(new a(P));
                H();
            }
        }
    }

    public static void u(String str, aw2.a aVar) {
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
