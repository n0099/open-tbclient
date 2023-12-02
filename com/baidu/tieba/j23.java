package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.gp2;
import com.baidu.tieba.hr2;
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
public final class j23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static re3 b;
    public static final Set<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947831358, "Lcom/baidu/tieba/j23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947831358, "Lcom/baidu/tieba/j23;");
                return;
            }
        }
        a = vm1.a;
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
    public static hr2.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return ((hr2.a) ((hr2.a) ((hr2.a) new hr2.a().T0(new PMSAppInfo())).D1("小程序测试").w0("10985873").P0(Color.parseColor("#FF308EF0"))).J0("1230000000000000")).A1("小程序简介").G1("测试服务类目").H1("测试主体信息").C1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").J1("1.0").E1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
        }
        return (hr2.a) invokeV.objValue;
    }

    public j23() {
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
            k63 c0 = k63.c0();
            if (c0 != null) {
                return c0.X().q0();
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
            if (!n32.e() && !n32.f()) {
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
        t52 W;
        q52 m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65563, null) != null) || (W = xr2.V().W()) == null || (m = W.m()) == null) {
            return;
        }
        m.Z2();
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
            return pf3.j();
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

    public static boolean B(hr2 hr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hr2Var)) == null) {
            if ((!a || !hr2Var.o0()) && !F(hr2Var.h0()) && !n32.e() && !n32.f() && !hr2Var.q0() && (!x() || !hr2Var.S())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean C(ir2 ir2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ir2Var)) == null) {
            if ((!a || !ir2Var.o0()) && !F(ir2Var.h0()) && !n32.e() && !n32.f() && !ir2Var.q0() && (!x() || !ir2Var.S())) {
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
            if (!s() && !r() && !o() && !y() && A() && !k() && !h() && !q() && !x() && !yg2.b(t())) {
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
            if (TextUtils.isEmpty(str) && !b42.d()) {
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
            pf3.q(z);
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

    public static Bundle I(ir2 ir2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ir2Var)) == null) {
            if (C(ir2Var)) {
                hr2.a b2 = b();
                b2.w0(ir2Var.I());
                b2.J0(ir2Var.U());
                b2.S0(ir2Var.f0());
                b2.B0(ir2Var.o0());
                b2.M0(ir2Var.q0());
                b2.z0(ir2Var.M());
                b2.E0(ir2Var.t0());
                b2.L0(ir2Var.X());
                b2.Q0(ir2Var.d0());
                b2.a1(ir2Var.k0());
                b2.D0(ir2Var.P());
                b2.b1(ir2Var.l0());
                b2.U0(ir2Var.h0());
                b2.J1("0");
                b2.v0(ir2Var.H());
                b2.R0(ir2Var.e0());
                if (F(ir2Var.h0()) || H() || ir2Var.q0()) {
                    b2.C1(ir2Var.I());
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

    public static gp2.g c(hr2 hr2Var, qk3 qk3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, hr2Var, qk3Var)) == null) {
            if (a && hr2Var.o0()) {
                return gp2.b.a(hr2Var, qk3Var);
            }
            if (F(hr2Var.h0())) {
                return gp2.f.a(hr2Var);
            }
            if (n32.e()) {
                return o32.a(hr2Var);
            }
            if (n32.f()) {
                return d42.a(hr2Var);
            }
            if (hr2Var.q0()) {
                return r32.a(hr2Var);
            }
            return null;
        }
        return (gp2.g) invokeLL.objValue;
    }

    public static String l(hr2 hr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, hr2Var)) == null) {
            if (a && hr2Var.o0()) {
                return gp2.b.g().getPath();
            }
            if (F(hr2Var.h0())) {
                return gp2.f.e().getPath();
            }
            if (n32.e()) {
                return o32.b().getPath();
            }
            if (n32.f()) {
                return d42.e().getPath();
            }
            if (hr2Var.q0()) {
                return r32.d().getPath();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static re3 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (b == null) {
                synchronized (j23.class) {
                    if (b == null) {
                        re3 re3Var = new re3("swan_app_debug");
                        b = re3Var;
                        re3Var.f.addAll(c);
                    }
                }
            }
            return b;
        }
        return (re3) invokeV.objValue;
    }
}
