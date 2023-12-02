package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class uf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) ? i == 1 ? "aigames_cur_remote_ver_key" : "aiapps_cur_remote_ver_key" : (String) invokeI.objValue;
    }

    public static String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? i == 1 ? "aigames_cur_remote_ver_name_key" : "aiapps_cur_remote_ver_name_key" : (String) invokeI.objValue;
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;

        public a(long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    of3.c().a(this.a, this.b);
                } catch (Exception e) {
                    if (uf3.a) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;

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
                    return;
                }
            }
            this.a = 0;
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return a(0, "");
            }
            return (b) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static b a(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
                b bVar = new b();
                bVar.a = i;
                bVar.b = str;
                return bVar;
            }
            return (b) invokeIL.objValue;
        }

        public static b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return a(1, str);
            }
            return (b) invokeL.objValue;
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteCoreUpdateStatus{statusCode=" + this.a + ", message='" + this.b + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948209031, "Lcom/baidu/tieba/uf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948209031, "Lcom/baidu/tieba/uf3;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            l("0", 0L, i);
        }
    }

    public static long e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            return ye3.a().getLong(i(i), 0L);
        }
        return invokeI.longValue;
    }

    public static String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            return ye3.a().getString(j(i), "");
        }
        return (String) invokeI.objValue;
    }

    public static File g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return new File(pf3.d(i), com.baidu.mobads.sdk.internal.cl.b);
        }
        return (File) invokeI.objValue;
    }

    public static b c(hf4 hf4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, hf4Var, i)) == null) {
            k32.k("RemoteSwanCoreControl", "doRemoteUpdate start. framework: " + hf4Var);
            if (hf4Var == null) {
                return b.b("framework is null.");
            }
            long j = hf4Var.i;
            if (j == 0) {
                return b.b("invalid version code : " + hf4Var.j);
            } else if (!xj3.a(new File(hf4Var.a), hf4Var.m)) {
                return b.b("sign failed.");
            } else {
                String path = h(j, i).getPath();
                if (!nm4.U(hf4Var.a, path)) {
                    return b.b("unzip bundle failed.");
                }
                if (i == 0) {
                    boolean B = nm4.B(hf4Var.a, path);
                    if (a) {
                        Log.d("RemoteSwanCoreControl", "isZipFileMatchUnzipResult:" + B + ",path:" + path);
                    }
                    if (!B) {
                        pf3.m(1, i, j);
                        nm4.M(path);
                        if (!nm4.U(hf4Var.a, path)) {
                            return b.b("unzip bundle failed.");
                        }
                    }
                }
                if (a) {
                    String b2 = pm4.b(new File(hf4Var.a), false);
                    if (!TextUtils.isEmpty(b2)) {
                        ye3.a().putString(of3.d(i), b2);
                    }
                }
                if (ProcessUtils.isMainProcess()) {
                    pf3.b(g(i), k(e(i), j));
                }
                l(hf4Var.j, hf4Var.i, i);
                k32.k("RemoteSwanCoreControl", "doRemoteUpdate end. version = " + j);
                return b.d();
            }
        }
        return (b) invokeLI.objValue;
    }

    public static SwanCoreVersion d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCoreType = 1;
            swanCoreVersion.swanCoreVersionCode = e(i);
            swanCoreVersion.swanCoreVersionName = f(i);
            swanCoreVersion.swanCorePath = h(swanCoreVersion.swanCoreVersionCode, i).getPath();
            return swanCoreVersion;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static File h(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return new File(g(i), String.valueOf(j));
        }
        return (File) invokeCommon.objValue;
    }

    public static ArrayList<Long> k(long j, long j2) {
        InterceptResult invokeCommon;
        SwanCoreVersion swanCoreVersion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            if (j != 0) {
                arrayList.add(Long.valueOf(j));
            }
            arrayList.add(Long.valueOf(j2));
            for (j33 j33Var : l33.k().q()) {
                SwanAppCores m = j33Var.m();
                if (j33Var.T() && m != null && (swanCoreVersion = m.getSwanCoreVersion()) != null && !arrayList.contains(Long.valueOf(swanCoreVersion.swanCoreVersionCode))) {
                    arrayList.add(Long.valueOf(swanCoreVersion.swanCoreVersionCode));
                }
            }
            if (a) {
                Log.d("RemoteSwanCoreControl", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static void l(String str, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            ye3.a().putString(j(i), str);
            ye3.a().putLong(i(i), j);
            ej3.k(new a(j, i), "cacheSwanCoreInfo");
        }
    }
}
