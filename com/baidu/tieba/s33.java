package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.pq2;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class s33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ag3 b;
    public static final Set<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100438, "Lcom/baidu/tieba/s33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100438, "Lcom/baidu/tieba/s33;");
                return;
            }
        }
        a = do1.a;
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

    @SuppressLint({"BDOfflineUrl"})
    public static qs2.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return ((qs2.a) ((qs2.a) ((qs2.a) new qs2.a().S0(new PMSAppInfo())).B1("小程序测试").v0("10985873").O0(Color.parseColor("#FF308EF0"))).I0("1230000000000000")).y1("小程序简介").E1("测试服务类目").F1("测试主体信息").A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").H1("1.0").C1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
        }
        return (qs2.a) invokeV.objValue;
    }

    public s33() {
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
            t73 b0 = t73.b0();
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
            if (!w42.e() && !w42.f()) {
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
        c72 V;
        z62 m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65563, null) != null) || (V = gt2.U().V()) == null || (m = V.m()) == null) {
            return;
        }
        m.V2();
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
            return yg3.j();
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

    public static boolean B(qs2 qs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qs2Var)) == null) {
            if ((!a || !qs2Var.n0()) && !F(qs2Var.g0()) && !w42.e() && !w42.f() && !qs2Var.p0() && (!x() || !qs2Var.R())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean C(rs2 rs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rs2Var)) == null) {
            if ((!a || !rs2Var.n0()) && !F(rs2Var.g0()) && !w42.e() && !w42.f() && !rs2Var.p0() && (!x() || !rs2Var.R())) {
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
            if (!s() && !r() && !o() && !y() && A() && !k() && !h() && !q() && !x() && !hi2.b(t())) {
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
            if (TextUtils.isEmpty(str) && !k52.d()) {
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
            yg3.q(z);
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

    public static Bundle I(rs2 rs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, rs2Var)) == null) {
            if (C(rs2Var)) {
                qs2.a b2 = b();
                b2.v0(rs2Var.H());
                b2.I0(rs2Var.T());
                b2.R0(rs2Var.e0());
                b2.A0(rs2Var.n0());
                b2.L0(rs2Var.p0());
                b2.y0(rs2Var.L());
                b2.D0(rs2Var.s0());
                b2.K0(rs2Var.W());
                b2.P0(rs2Var.c0());
                b2.Z0(rs2Var.j0());
                b2.C0(rs2Var.O());
                b2.a1(rs2Var.k0());
                b2.T0(rs2Var.g0());
                b2.H1("0");
                b2.u0(rs2Var.G());
                b2.Q0(rs2Var.d0());
                if (F(rs2Var.g0()) || H() || rs2Var.p0()) {
                    b2.A1(rs2Var.H());
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

    public static pq2.g c(qs2 qs2Var, zl3 zl3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, qs2Var, zl3Var)) == null) {
            if (a && qs2Var.n0()) {
                return pq2.b.a(qs2Var, zl3Var);
            }
            if (F(qs2Var.g0())) {
                return pq2.f.a(qs2Var);
            }
            if (w42.e()) {
                return x42.a(qs2Var);
            }
            if (w42.f()) {
                return m52.a(qs2Var);
            }
            if (qs2Var.p0()) {
                return a52.a(qs2Var);
            }
            return null;
        }
        return (pq2.g) invokeLL.objValue;
    }

    public static String l(qs2 qs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, qs2Var)) == null) {
            if (a && qs2Var.n0()) {
                return pq2.b.g().getPath();
            }
            if (F(qs2Var.g0())) {
                return pq2.f.e().getPath();
            }
            if (w42.e()) {
                return x42.b().getPath();
            }
            if (w42.f()) {
                return m52.e().getPath();
            }
            if (qs2Var.p0()) {
                return a52.d().getPath();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static ag3 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (b == null) {
                synchronized (s33.class) {
                    if (b == null) {
                        ag3 ag3Var = new ag3("swan_app_debug");
                        b = ag3Var;
                        ag3Var.f.addAll(c);
                    }
                }
            }
            return b;
        }
        return (ag3) invokeV.objValue;
    }
}
