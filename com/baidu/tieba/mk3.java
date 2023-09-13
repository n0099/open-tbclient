package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.ph3;
import com.baidu.tieba.sk3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public final class mk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public a(int i, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ph3.b bVar = new ph3.b(10014);
                bVar.k(String.valueOf(this.a));
                bVar.l(String.valueOf(this.b));
                bVar.j(String.valueOf(this.c));
                bVar.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Nullable
        public static SwanCoreVersion d(Bundle bundle, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bundle, i)) == null) {
                if (bundle == null) {
                    return null;
                }
                bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
                if (i == 1) {
                    return (SwanCoreVersion) bundle.getParcelable("aiapps_game_core");
                }
                return (SwanCoreVersion) bundle.getParcelable("aiapps_swan_core");
            }
            return (SwanCoreVersion) invokeLI.objValue;
        }

        public SwanCoreVersion c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                SwanCoreVersion e = mk3.e(i);
                if (!e.isAvailable()) {
                    qk3.b().f(i);
                    return mk3.e(i);
                }
                return e;
            }
            return (SwanCoreVersion) invokeI.objValue;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("aiapps_swan_core", c(0));
                bundle2.putParcelable("aiapps_game_core", c(1));
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947975508, "Lcom/baidu/tieba/mk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947975508, "Lcom/baidu/tieba/mk3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            rk3.b(0);
            pk3.b(0);
            rk3.b(1);
            pk3.b(1);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ok3.e();
        }
        return invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return vj3.a().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false);
        }
        return invokeV.booleanValue;
    }

    public static void b(File file, List<Long> list) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, file, list) != null) || file == null) {
            return;
        }
        h82.k("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (a) {
                Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores versionFolder: " + file2);
            }
            if (!k(file2, list)) {
                if (a) {
                    Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                }
                lr4.j(file2);
            }
        }
    }

    public static File d(int i) {
        InterceptResult invokeI;
        File b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i == 1 && (b2 = pu2.g().b()) != null) {
                return new File(b2, "game_core");
            }
            return new File(du2.g(), "swan_core");
        }
        return (File) invokeI.objValue;
    }

    public static SwanCoreVersion e(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (j() && z) {
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = ok3.c().getPath();
                swanCoreVersion.swanCoreType = 2;
                long b2 = ok3.b();
                swanCoreVersion.swanCoreVersionCode = b2;
                swanCoreVersion.swanCoreVersionName = wo3.d(b2);
                boolean isAvailable = swanCoreVersion.isAvailable();
                if (a) {
                    Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode-debugCoreAvailable:" + isAvailable);
                }
                if (isAvailable) {
                    return swanCoreVersion;
                }
                q(false);
            }
            SwanCoreVersion m = pk3.m(i);
            SwanCoreVersion d = rk3.d(i);
            if (a) {
                Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVerName=" + m.swanCoreVersionName + ", presetVerCode=" + m.swanCoreVersionCode + ", remoteVerName=" + d.swanCoreVersionName + ", remoteVerCode=" + d.swanCoreVersionCode);
            }
            if (m.swanCoreVersionCode < d.swanCoreVersionCode && d.isAvailable()) {
                return d;
            }
            return m;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static long f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            SwanCoreVersion e = e(i);
            if (e != null) {
                return e.swanCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            return i(null, i);
        }
        return (String) invokeI.objValue;
    }

    public static void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            o(i, null);
        }
    }

    public static void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            vj3.a().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
        }
    }

    @Nullable
    public static SwanCoreVersion g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return e(i);
            }
            w73 c = u73.c(b.class, null);
            if (a) {
                Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + b.d(c.a, i));
            }
            return b.d(c.a, i);
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static String i(SwanCoreVersion swanCoreVersion, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, swanCoreVersion, i)) == null) {
            if (swanCoreVersion == null) {
                swanCoreVersion = e(i);
            }
            if (swanCoreVersion.swanCoreVersionCode > 0) {
                return swanCoreVersion.swanCoreVersionName;
            }
            String e = pk3.k(i).e();
            if (a) {
                Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionName preset config: " + e);
            }
            if (TextUtils.isEmpty(e)) {
                return "0";
            }
            return e;
        }
        return (String) invokeLI.objValue;
    }

    public static void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i, i2) == null) {
            if (a) {
                Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            if (!"com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) && i == i2) {
                return;
            }
            a();
            pk3.v(true, 0);
            pk3.v(true, 1);
            pk3.w(false, 0);
            du2.F(false);
        }
    }

    public static boolean k(File file, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, file, list)) == null) {
            if (list == null) {
                return false;
            }
            String name = file.getName();
            for (Long l : list) {
                if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void m(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            bo3.k(new a(i2, j, i), "reportZipFileCheckFailed");
        }
    }

    public static void p(sk3 sk3Var, int i, aq3<Exception> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65552, null, sk3Var, i, aq3Var) == null) {
            om4 om4Var = new om4(i);
            if (i == 0) {
                ri4.l(om4Var, new ke2(aq3Var));
                return;
            }
            pe2 o = pu2.i().o(aq3Var);
            if (o != null) {
                ri4.m(om4Var, new ke2(null), o);
            } else if (aq3Var != null) {
                aq3Var.a(null);
            }
        }
    }

    public static void o(int i, aq3<Exception> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65551, null, i, aq3Var) == null) {
            sk3.b b2 = sk3.b.b();
            b2.c(true);
            b2.d("openSwanApp");
            p(b2.a(), i, aq3Var);
        }
    }
}
