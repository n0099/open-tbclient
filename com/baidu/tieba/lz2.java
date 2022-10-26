package com.baidu.tieba;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.im2;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public final class lz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static tb3 b;
    public static final Set c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947960101, "Lcom/baidu/tieba/lz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947960101, "Lcom/baidu/tieba/lz2;");
                return;
            }
        }
        a = wj1.a;
        HashSet hashSet = new HashSet();
        c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        c.add("aiapps_server_domains_debug_key");
        c.add("aiapps_use_extension_debug_key");
        c.add("aiapps_emit_live_debug_key");
        c.add("aiapps_emit_https_debug_key");
        c.add("aiapps_emit_wss_debug_key");
        c.add("aiapps_load_cts_debug_key");
        c.add("aiapps_env_data");
        c.add("aiapps_js_native_switch_key");
        c.add("aiapps_emit_game_core_debug_key");
        c.add("aiapps_emit_game_launch_mode_key");
    }

    public static jo2.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return (jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) ((jo2.a) new jo2.a().S0(new PMSAppInfo())).B1("小程序测试")).v0("10985873")).O0(Color.parseColor("#FF308EF0"))).I0("1230000000000000")).y1("小程序简介")).E1("测试服务类目")).F1("测试主体信息")).A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N")).H1("1.0")).C1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
        }
        return (jo2.a) invokeV.objValue;
    }

    public lz2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return d("aiapps_websafe_debug_key", true);
        }
        return invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            m33 b0 = m33.b0();
            if (b0 != null) {
                return b0.W().p0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static Boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false));
        }
        return (Boolean) invokeV.objValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (!p02.e() && !p02.f()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return u().getBoolean("swan_debug_forbid_sample", true);
        }
        return invokeV.booleanValue;
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return u().getBoolean("swan_debug_force_ab", false);
        }
        return invokeV.booleanValue;
    }

    public static void Z() {
        v22 V;
        s22 m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65563, null) != null) || (V = zo2.U().V()) == null || (m = V.m()) == null) {
            return;
        }
        m.S2();
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return d("aiapps_close_view_disable_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return d("aiapps_dashboard_enable_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return u().getString("aiapps_env_data", "");
        }
        return (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return d("aiapps_emit_game_core_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return u().getString("swan_debug_so_url_key", "");
        }
        return (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return u().getInt("swan_debug_open_so_key", -1);
        }
        return invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return rc3.j();
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return d("aiapps_force_authorized_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return d("swan_game_fps_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return d("aiapps_emit_https_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return d("aiapps_js_native_switch_key", true);
        }
        return invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return d("aiapps_emit_wss_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            return d("aiapps_emit_live_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return d("aiapps_load_cts_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return u().getInt("aiapps_pms_host_env", 0);
        }
        return invokeV.intValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            return d("aiapps_sconsole_scan_mode_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            return d("aiapps_server_domains_debug_key", true);
        }
        return invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            return d("aiapps_emit_game_launch_mode_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return d("aiapps_use_extension_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            return d("aiapps_use_game_extension_debug_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean B(jo2 jo2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jo2Var)) == null) {
            if ((!a || !jo2Var.n0()) && !F(jo2Var.g0()) && !p02.e() && !p02.f() && !jo2Var.p0() && (!x() || !jo2Var.R())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean C(ko2 ko2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ko2Var)) == null) {
            if ((!a || !ko2Var.n0()) && !F(ko2Var.g0()) && !p02.e() && !p02.f() && !ko2Var.p0() && (!x() || !ko2Var.R())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (!s() && !r() && !o() && !y() && A() && !k() && !h() && !q() && !x() && !ae2.b(t())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str) && !d12.d()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            u().putString("aiapps_env_data", str);
        }
    }

    public static void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            J("aiapps_emit_game_core_debug_key", z);
        }
    }

    public static void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            rc3.q(z);
        }
    }

    public static void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            J("aiapps_emit_https_debug_key", z);
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            J("aiapps_js_native_switch_key", z);
        }
    }

    public static void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            J("aiapps_emit_wss_debug_key", z);
        }
    }

    public static void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            J("aiapps_emit_live_debug_key", z);
        }
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            J("aiapps_load_cts_debug_key", z);
        }
    }

    public static void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, null, i) == null) {
            u().putInt("aiapps_pms_host_env", i);
        }
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            J("aiapps_server_domains_debug_key", z);
        }
    }

    public static void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            J("aiapps_emit_game_launch_mode_key", z);
        }
    }

    public static void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            J("aiapps_use_extension_debug_key", z);
        }
    }

    public static void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            J("aiapps_websafe_debug_key", z);
        }
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, extensionCore)) == null) {
            if (extensionCore == null) {
                return null;
            }
            extensionCore.extensionCoreVersionCode = 4294967297L;
            extensionCore.extensionCoreVersionName = "1.0.1";
            return extensionCore;
        }
        return (ExtensionCore) invokeL.objValue;
    }

    public static Bundle I(ko2 ko2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ko2Var)) == null) {
            if (C(ko2Var)) {
                jo2.a b2 = b();
                b2.v0(ko2Var.H());
                b2.I0(ko2Var.T());
                b2.R0(ko2Var.e0());
                b2.A0(ko2Var.n0());
                b2.L0(ko2Var.p0());
                b2.y0(ko2Var.L());
                b2.D0(ko2Var.s0());
                b2.K0(ko2Var.W());
                b2.P0(ko2Var.c0());
                b2.Z0(ko2Var.j0());
                b2.C0(ko2Var.O());
                b2.a1(ko2Var.k0());
                b2.T0(ko2Var.g0());
                b2.H1("0");
                b2.u0(ko2Var.G());
                b2.Q0(ko2Var.d0());
                if (F(ko2Var.g0()) || H() || ko2Var.p0()) {
                    b2.A1(ko2Var.H());
                }
                return b2.D();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static void J(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            u().putBoolean(str, z);
        }
    }

    public static boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65567, null, str, z)) == null) {
            return u().getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public static im2.g c(jo2 jo2Var, sh3 sh3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, jo2Var, sh3Var)) == null) {
            if (a && jo2Var.n0()) {
                return im2.b.a(jo2Var, sh3Var);
            }
            if (F(jo2Var.g0())) {
                return im2.f.a(jo2Var);
            }
            if (p02.e()) {
                return q02.a(jo2Var);
            }
            if (p02.f()) {
                return f12.a(jo2Var);
            }
            if (jo2Var.p0()) {
                return t02.a(jo2Var);
            }
            return null;
        }
        return (im2.g) invokeLL.objValue;
    }

    public static String l(jo2 jo2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, jo2Var)) == null) {
            if (a && jo2Var.n0()) {
                return im2.b.g().getPath();
            }
            if (F(jo2Var.g0())) {
                return im2.f.e().getPath();
            }
            if (p02.e()) {
                return q02.b().getPath();
            }
            if (p02.f()) {
                return f12.e().getPath();
            }
            if (jo2Var.p0()) {
                return t02.d().getPath();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static tb3 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (b == null) {
                synchronized (lz2.class) {
                    if (b == null) {
                        tb3 tb3Var = new tb3("swan_app_debug");
                        b = tb3Var;
                        tb3Var.f.addAll(c);
                    }
                }
            }
            return b;
        }
        return (tb3) invokeV.objValue;
    }
}
