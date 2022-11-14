package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.tieba.cp2;
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
/* loaded from: classes5.dex */
public final class pa3 {
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(ib3 ib3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ya3.k(this.b));
                this.a.d(this.c);
                ya3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(ib3 ib3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d(this.b);
                this.a.b(ya3.k(this.c));
                ya3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(ib3 ib3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ya3.k(this.b));
                this.a.d(this.c);
                ya3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements yi3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib3 a;

        public e(ib3 ib3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ib3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.a.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                ya3.onEvent(this.a);
                f12.k("SwanAppLaunchUbc", jSONObject.toString());
                mn2.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055271, "Lcom/baidu/tieba/pa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055271, "Lcom/baidu/tieba/pa3;");
                return;
            }
        }
        a = pk1.a;
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
            synchronized (pa3.class) {
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
        f43 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65562, null) != null) || (M = f43.M()) == null) {
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
            synchronized (pa3.class) {
                c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (pa3.class) {
                d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (pa3.class) {
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

    public static void o(cp2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, aVar) == null) && aVar != null && !f) {
            D(true);
            k(aVar, "naarrsuccess");
        }
    }

    public static void q(cp2.a aVar) {
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
            su2.e(str);
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

    public static void k(cp2.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void G() {
        o32 V;
        lq1 o3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, null) != null) || (V = sp2.U().V()) == null) {
            return;
        }
        l32 m = V.m();
        if ((m instanceof n32) && (o3 = ((n32) m).o3()) != null) {
            i = o3.a();
        }
    }

    public static void H() {
        HybridUbcFlow d2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || (d2 = kx2.d("startup")) == null) {
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

    public static void a(wq1 wq1Var) {
        f43 M;
        cp2.a W;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, wq1Var) != null) || f() || g() || wq1Var == null || (M = f43.M()) == null || (W = M.W()) == null) {
            return;
        }
        if (a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(W, wq1Var.b, "0", wq1Var.c, b(wq1Var.g), false);
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

    public static void d(@NonNull cp2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            ib3 ib3Var = new ib3();
            ib3Var.a = ya3.n(0);
            ib3Var.b = "launch";
            ib3Var.e = "narendersuccess";
            ib3Var.h(aVar);
            yx2.e().d(new d(ib3Var, aVar.W(), aVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess", true);
        }
    }

    public static void v(@NonNull cp2 cp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, cp2Var) == null) {
            ib3 ib3Var = new ib3();
            ib3Var.a = ya3.n(0);
            ib3Var.f = cp2Var.H();
            ib3Var.c = cp2Var.T();
            ib3Var.b = "show";
            yx2.e().d(new b(ib3Var, cp2Var.W(), cp2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606", true);
        }
    }

    public static void c(cp2.a aVar, long j, String str, long j2, String str2, boolean z) {
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

    public static void l(cp2.a aVar, String str, long j, JSONObject jSONObject) {
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
            ib3 ib3Var = new ib3();
            ib3Var.a = ya3.n(aVar.G());
            ib3Var.f = H;
            if (w12.d()) {
                ib3Var.c = "remote-debug";
            } else if (e03.D()) {
                ib3Var.c = "local-debug";
            } else {
                ib3Var.c = aVar.T();
            }
            ib3Var.b = "launch";
            ib3Var.e = str;
            ib3Var.a("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                ib3Var.e(jSONObject);
            }
            Bundle P = aVar.P();
            if (P != null) {
                ib3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            ib3Var.b(ya3.k(aVar.W()));
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
            ya3.onEvent(ib3Var);
        }
    }

    public static void m(@NonNull cp2 cp2Var, int i2, @NonNull yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, cp2Var, i2, yf3Var) == null) {
            ib3 ib3Var = new ib3();
            ib3Var.a = ya3.n(i2);
            ib3Var.b = "launch";
            ib3Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            ib3Var.a("errcode", String.valueOf(yf3Var.a()));
            ib3Var.a("msg", yf3Var.g().toString());
            ib3Var.h(cp2Var);
            ib3Var.d(cp2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            ib3Var.b(ya3.k(cp2Var.W()));
            vg3.d(cp2Var, new e(ib3Var));
        }
    }

    public static void n(ib3 ib3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, ib3Var, str, str2) == null) {
            yx2.e().d(new c(ib3Var, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void p(cp2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            if (a) {
                Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
            }
            su2.e(i);
            if (!i()) {
                d(aVar);
            }
            if (!f() && !g()) {
                c(aVar, -1L, "1", -1L, "1", true);
            }
        }
    }

    public static void s(cp2 cp2Var) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, null, cp2Var) == null) && cp2Var != null && e() && (P = cp2Var.P()) != null) {
            long j = P.getLong("page_display_flag_for_statistic");
            long l = cp2Var.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0) {
                ib3 ib3Var = new ib3();
                ib3Var.a = ya3.n(cp2Var.G());
                ib3Var.f = cp2Var.H();
                ib3Var.c = cp2Var.T();
                ib3Var.b = "launch";
                ib3Var.e = "realsuccess";
                ib3Var.r = String.valueOf(currentTimeMillis - l);
                ib3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
                ya3.onEvent(ib3Var);
                zh3.e0(new a(P));
                H();
            }
        }
    }

    public static void u(String str, cp2.a aVar) {
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
