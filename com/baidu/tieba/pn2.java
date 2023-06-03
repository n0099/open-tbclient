package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public class pn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 1 ? "key_is_need_update_game_ext_preset" : "key_is_need_update_preset" : (String) invokeI.objValue;
    }

    /* loaded from: classes7.dex */
    public static class a implements FilenameFilter {
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

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return TextUtils.isDigitsOnly(str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<File> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                long lastModified = file.lastModified();
                long lastModified2 = file2.lastModified();
                if (lastModified == lastModified2) {
                    return 0;
                }
                if (lastModified - lastModified2 > 0) {
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067733, "Lcom/baidu/tieba/pn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067733, "Lcom/baidu/tieba/pn2;");
                return;
            }
        }
        a = is1.a;
    }

    public static void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, bundle) != null) || bundle == null) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            o83 e = o83.e();
            q83 q83Var = new q83(18, bundle);
            q83Var.f(true);
            e.h(q83Var);
            return;
        }
        String string = bundle.getString("arg_dst_folder");
        if (!TextUtils.isEmpty(string)) {
            b(new File(string), bundle.getLongArray("arg_ignore_vers"));
        }
    }

    public static void b(File file, long... jArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, file, jArr) == null) {
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_dst_folder", file.getPath());
                if (jArr != null && jArr.length > 0) {
                    bundle.putLongArray("arg_ignore_vers", jArr);
                }
                a(bundle);
            } else if (file != null && file.exists() && file.isDirectory()) {
                ArrayList arrayList = new ArrayList();
                if (jArr != null) {
                    for (long j : jArr) {
                        if (j > 0) {
                            arrayList.add(Long.valueOf(j));
                        }
                    }
                }
                arrayList.addAll(e());
                arrayList.addAll(d(file, 3));
                if (a) {
                    Log.d("ExtCore-Utils", "deleteOldExtensionCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(arrayList.toArray()));
                }
                for (File file2 : file.listFiles()) {
                    if (!g(file2, arrayList)) {
                        if (a) {
                            Log.d("ExtCore-Utils", "deleteOldExtensionCores deleteFolder: " + file2);
                        }
                        cs4.L(file2);
                    }
                }
            }
        }
    }

    public static List<Long> d(File file, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, file, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i > 0 && file != null && file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles(new a());
                if (listFiles == null) {
                    return arrayList;
                }
                Arrays.sort(listFiles, new b());
                int min = Math.min(listFiles.length, i);
                for (int i2 = 0; i2 < min; i2++) {
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(listFiles[i2].getName())));
                    } catch (NumberFormatException e) {
                        y82.l("ExtCore-Utils", "get extension version fail", e);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static ArrayList<Long> e() {
        InterceptResult invokeV;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (x83 x83Var : z83.k().q()) {
                SwanAppCores m = x83Var.m();
                if (m != null && x83Var.T() && (extensionCore = m.getExtensionCore()) != null && !arrayList.contains(Long.valueOf(extensionCore.extensionCoreVersionCode))) {
                    arrayList.add(Long.valueOf(extensionCore.extensionCoreVersionCode));
                }
            }
            if (a) {
                Log.d("ExtCore-Utils", "SwanCoreVersion usedVersions: " + Arrays.toString(arrayList.toArray()));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i == 1) {
                return x73.z();
            }
            return x73.y();
        }
        return invokeI.booleanValue;
    }

    public static boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            return mk3.a().getBoolean(c(i), false);
        }
        return invokeI.booleanValue;
    }

    public static boolean g(File file, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, list)) == null) {
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

    public static void i(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            mk3.a().putBoolean(c(i), z);
        }
    }
}
