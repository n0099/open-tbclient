package com.baidu.tieba;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes5.dex */
public final class m72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final int g;
    public static final Set h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(TiebaStatic.LogFields.RESULT, m72.h());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        boolean e2;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925505, "Lcom/baidu/tieba/m72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925505, "Lcom/baidu/tieba/m72;");
                return;
            }
        }
        a = wj1.a;
        if (ProcessUtils.isMainProcess()) {
            e2 = j("swan_prefetch_app_data", 1);
        } else {
            e2 = e();
        }
        b = e2;
        c = j("swan_prefetch_slave_data", 0);
        d = j("swan_prefetch_click", 0);
        e = j("swan_prefetch_event_on", 1);
        f = j("swan_prefetch_sub_pkg", 0);
        g = d("swan_prefetch_app_data_multi", 0);
        if (a) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + b);
            Log.i("PrefetchABSwitcher", "master prefetch switch -  " + e);
            Log.i("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f);
            Log.i("PrefetchABSwitcher", "master multi preload switch -  " + g);
        }
        h = qh3.a("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", "3mHyKpYFH6SF5FTWTLVaVdgi3lDGrxYy");
    }

    public static void k() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            m02.k("PrefetchABSwitcher", "preload master is on = " + b);
            m02.k("PrefetchABSwitcher", "preload slave is on = " + c);
            m33 b0 = m33.b0();
            if (b0 != null && m(b0.W().f0())) {
                z = true;
            } else {
                z = false;
            }
            m02.k("PrefetchABSwitcher", "prefetch master show is on = " + z);
            m02.k("PrefetchABSwitcher", "prefetch master click is on = " + d);
            m02.k("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f);
            o52 a2 = v52.b().a();
            if (a2 != null) {
                m02.k("PrefetchABSwitcher", "current running master id = " + a2.i().a());
            }
            m02.k("PrefetchABSwitcher", "master multi preload switch -  " + g);
        }
    }

    public static boolean a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) {
            if (d && m(pMSAppInfo)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt(str, -1);
        }
        return invokeL.intValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && h.contains(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_event", -1);
        }
        return invokeV.intValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            boolean z = !bh3.f("3.290.0");
            if (a && b("swan_prefetch_app_data_multi") > 0) {
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return g;
        }
        return invokeV.intValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return f;
        }
        return invokeV.booleanValue;
    }

    public static int d(String str, int i) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            if (a && (b2 = b(str)) != -1) {
                return b2;
            }
            tm2.g0().getSwitch(str, i);
            if (a) {
                Log.d("PrefetchABSwitcher", str + " value from AB : " + i);
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            b03 c2 = zz2.c(a.class, null);
            boolean z = false;
            if (c2.a() && c2.a.getBoolean(TiebaStatic.LogFields.RESULT, false)) {
                z = true;
            }
            if (a) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (currentTimeMillis - j) + "ms");
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (!a) {
                return false;
            }
            int c2 = c();
            Log.d("PrefetchABSwitcher", "prefetch switch in debug sp - " + c2);
            if (c2 != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(String str, int i) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            if (a) {
                if (lz2.Y() || (b2 = b(str)) == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
            }
            if (d(str, i) != 1) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static boolean m(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        boolean z;
        SwanAppConfigData Q;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (!h()) {
                return false;
            }
            if (a) {
                int c2 = c();
                if (c2 == 1) {
                    return true;
                }
                if (c2 == 0) {
                    return false;
                }
            }
            if (pMSAppInfo != null && e) {
                if (ov1.b(pMSAppInfo.appId) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                m33 b0 = m33.b0();
                if (b0 == null) {
                    Q = null;
                } else {
                    Q = b0.Q();
                }
                if (Q != null && !Q.u) {
                    SwanAppConfigData.h hVar = Q.t;
                    if (hVar != null && hVar.a) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z) {
                        return z2;
                    }
                    if (!z2 && !g(pMSAppInfo.appKey)) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3 || !rt2.g().i(pMSAppInfo)) {
                        return false;
                    }
                    return true;
                } else if (a) {
                    Log.d("PrefetchABSwitcher", "NA View not support prefetch");
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        SwanAppConfigData Q;
        boolean z;
        SwanAppConfigData.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, pMSAppInfo)) == null) {
            boolean z2 = false;
            if (pMSAppInfo == null) {
                return false;
            }
            boolean m = m(pMSAppInfo);
            if (a) {
                Log.d("PrefetchABSwitcher", "appId - " + pMSAppInfo.appKey + ", prefetch on - " + m);
            }
            if (!m) {
                return false;
            }
            if (a) {
                int c2 = c();
                if (c2 == 1) {
                    return true;
                }
                if (c2 == 0) {
                    return false;
                }
            }
            m33 b0 = m33.b0();
            if (b0 == null) {
                Q = null;
            } else {
                Q = b0.Q();
            }
            if (Q != null && (hVar = Q.t) != null && TextUtils.equals(hVar.b, "show")) {
                z = true;
            } else {
                z = false;
            }
            z2 = (z || g(pMSAppInfo.appKey)) ? true : true;
            if (a) {
                Log.d("PrefetchABSwitcher", "appId - " + pMSAppInfo.appKey + ", show prefetch - " + z2);
            }
            return z2;
        }
        return invokeL.booleanValue;
    }
}
