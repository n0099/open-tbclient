package com.baidu.tieba;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.pq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class pq2<SelfT extends pq2<SelfT>> extends sq2<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Pair<String, JSONObject> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070616, "Lcom/baidu/tieba/pq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070616, "Lcom/baidu/tieba/pq2;");
                return;
            }
        }
        c = am1.a;
    }

    public pq2() {
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

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return n("launch_app_download_url");
        }
        return (String) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return h("appFrameType");
        }
        return invokeV.intValue;
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return o("mAppId", "");
        }
        return (String) invokeV.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return n("mAppKey");
        }
        return (String) invokeV.objValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return n("launch_app_open_url");
        }
        return (String) invokeV.objValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return n("mAppTitle");
        }
        return (String) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return n("mClickId");
        }
        return (String) invokeV.objValue;
    }

    public long O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return k("last_start_timestamp");
        }
        return invokeV.longValue;
    }

    public ExtensionCore P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (ExtensionCore) m("extensionCore");
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public Bundle Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return e("mExtraData");
        }
        return (Bundle) invokeV.objValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return n("app_icon_url");
        }
        return (String) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return d("cts_launch_mode", false);
        }
        return invokeV.booleanValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return i("launchFlags", 0);
        }
        return invokeV.intValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return n("mFrom");
        }
        return (String) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return n("mFromLast");
        }
        return (String) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return n("launch_id");
        }
        return (String) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return n("launchScheme");
        }
        return (String) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return n("local_debug_ws_host");
        }
        return (String) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return n("local_debug_ws_port");
        }
        return (String) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return n("max_swan_version");
        }
        return (String) invokeV.objValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return n("min_swan_version");
        }
        return (String) invokeV.objValue;
    }

    public long c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return l("navigate_bar_color_key", 2147483648L);
        }
        return invokeV.longValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return n("notInHistory");
        }
        return (String) invokeV.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            int i = i("appFrameOrientation", -1);
            if (-1 >= i) {
                return -1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return n("mPage");
        }
        return (String) invokeV.objValue;
    }

    public PMSAppInfo g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return (PMSAppInfo) m("pms_db_info_onload");
        }
        return (PMSAppInfo) invokeV.objValue;
    }

    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return n("remoteDebugUrl");
        }
        return (String) invokeV.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return n("swan_app_sub_root_path");
        }
        return (String) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return n("mSubscribeWithoutClick");
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return (SwanCoreVersion) m("swanCoreVersion");
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return n("targetSwanVersion");
        }
        return (String) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (b("pms_db_info_onload") && g0() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return d("console_switch", false);
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return d("mIsDebug", false);
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return d("swan_app_independent", false);
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return d("local_debug_switch", false);
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public Bundle t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            Bundle Q = Q();
            if (Q == null) {
                Bundle bundle = new Bundle();
                E0(bundle);
                return bundle;
            }
            return Q;
        }
        return (Bundle) invokeV.objValue;
    }

    public SelfT A0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            return (SelfT) t("console_switch", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT B0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            return (SelfT) t("mIsDebug", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT C0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            return (SelfT) x("last_start_timestamp", j);
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT D0(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, extensionCore)) == null) {
            return (SelfT) y("extensionCore", extensionCore);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT E0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            return (SelfT) u("mExtraData", bundle);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return I0(i | T());
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT F0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            z("app_icon_url", str);
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT G0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            return (SelfT) t("swan_app_independent", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT H0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            t("cts_launch_mode", z);
            return (SelfT) j();
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT I0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return (SelfT) w("launchFlags", i);
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT J0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            z("mFromLast", U());
            return (SelfT) z("mFrom", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT K0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            return (SelfT) z("launch_id", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT L0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            return (SelfT) z("launchScheme", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT M0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            return (SelfT) t("local_debug_switch", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT N0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            return (SelfT) z("local_debug_ws_host", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            return (SelfT) z("local_debug_ws_port", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT P0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048602, this, j)) == null) {
            if (2147483648L != j) {
                x("navigate_bar_color_key", j);
            }
            return (SelfT) j();
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT Q0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return (SelfT) z("notInHistory", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT R0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            return (SelfT) w("appFrameOrientation", i);
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT S0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            return (SelfT) z("mPage", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT T0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, pMSAppInfo)) == null) {
            return (SelfT) y("pms_db_info_onload", pMSAppInfo);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT U0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            return (SelfT) z("remoteDebugUrl", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT V0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT W0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            return (SelfT) z("swan_app_sub_root_path", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT X0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT Y0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            return (SelfT) z("mSubscribeWithoutClick", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT Z0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048622, this, j)) == null) {
            return (SelfT) j();
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT a1(SwanCoreVersion swanCoreVersion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, swanCoreVersion)) == null) {
            return (SelfT) y("swanCoreVersion", swanCoreVersion);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT b1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            return (SelfT) z("targetSwanVersion", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT c1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT d1(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, pMSAppInfo)) == null) {
            if (pMSAppInfo != null) {
                y("pms_db_info_updated", pMSAppInfo);
                if (!m0()) {
                    T0(pMSAppInfo);
                }
            }
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT v0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i)) == null) {
            return (SelfT) w("appFrameType", i);
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT w0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, str)) == null) {
            z("mAppId", str);
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT x0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            z("mAppKey", str);
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT y0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, str)) == null) {
            z("mAppTitle", str);
            return (SelfT) j();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT z0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, str)) == null) {
            return (SelfT) z("mClickId", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public JSONObject N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String X = X();
            Pair<String, JSONObject> pair = this.b;
            if (pair != null && TextUtils.equals((CharSequence) pair.first, X)) {
                return (JSONObject) this.b.second;
            }
            this.b = null;
            if (TextUtils.isEmpty(X)) {
                this.b = null;
                return null;
            }
            String queryParameter = Uri.parse(X).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    this.b = new Pair<>(X, new JSONObject(queryParameter).optJSONObject("ext"));
                } catch (JSONException e) {
                    if (c) {
                        e.printStackTrace();
                    }
                }
            }
            Pair<String, JSONObject> pair2 = this.b;
            if (pair2 == null) {
                return null;
            }
            return (JSONObject) pair2.second;
        }
        return (JSONObject) invokeV.objValue;
    }

    public SelfT r0(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048644, this, str, j)) == null) {
            t0().putLong(str, j);
            return (SelfT) j();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT s0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                t0().putString(str, str2);
            }
            return (SelfT) j();
        }
        return (SelfT) invokeLL.objValue;
    }
}
