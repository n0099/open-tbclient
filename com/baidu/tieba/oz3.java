package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ul2;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class oz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;
        public final /* synthetic */ sl2 b;

        public a(vn2 vn2Var, sl2 sl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn2Var, sl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn2Var;
            this.b = sl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                eh3 eh3Var = new eh3();
                if (this.a.n0() && (xy2.x() || oz3.a)) {
                    j = b.a(this.a, eh3Var);
                } else {
                    j = d.j(this.a, eh3Var);
                }
                this.b.a(0, j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static c a(vn2 vn2Var, eh3 eh3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, vn2Var, eh3Var)) == null) {
                File b = b(eh3Var);
                if (b == null) {
                    return null;
                }
                y23 M = y23.M();
                String b2 = ej4.b(b, false);
                File d = d(b2);
                if (M == null) {
                    if (!oz3.i(b, d, vn2Var, eh3Var)) {
                        q23.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        re3 re3Var = new re3();
                        re3Var.k(5L);
                        re3Var.i(7L);
                        re3Var.f("小游戏bundle解压失败! for debug");
                        ve3.a().f(re3Var);
                        if (eh3Var != null && eh3Var.a == null) {
                            eh3Var.a = re3Var;
                        }
                        return null;
                    }
                } else if (!TextUtils.equals(M.e0().q("installed_debug_game_bundle_md5", ""), b2)) {
                    if (!oz3.i(b, d, vn2Var, eh3Var)) {
                        q23.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        re3 re3Var2 = new re3();
                        re3Var2.k(5L);
                        re3Var2.i(7L);
                        re3Var2.f("小游戏bundle解压失败! for debug");
                        ve3.a().f(re3Var2);
                        if (eh3Var != null && eh3Var.a == null) {
                            eh3Var.a = re3Var2;
                        }
                        return null;
                    }
                    M.e0().B("installed_debug_game_bundle_md5", b2);
                }
                c cVar = new c();
                File file = new File(d, "game.json");
                s24 a = s24.a(cj4.E(file));
                if (a == null) {
                    return null;
                }
                cVar.a = d.getPath() + File.separator;
                cVar.c = a;
                if (!TextUtils.isEmpty(a.e)) {
                    cVar.b = cVar.a + a.e + File.separator;
                    j24.a().d(true);
                    j24.a().e(cVar.b);
                    j24.a().f(a.e);
                } else {
                    j24.a().d(false);
                }
                if (oz3.a) {
                    Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.a);
                    Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.b);
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }

        public static File b(eh3 eh3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eh3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return e(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                q23.g(appContext, c.getPath() + " 没有测试程序包!").G();
                re3 re3Var = new re3();
                re3Var.k(5L);
                re3Var.i(4L);
                re3Var.f("没有小游戏包! for debug, bundle files are empty");
                ve3.a().f(re3Var);
                if (eh3Var != null) {
                    eh3Var.a = re3Var;
                    return null;
                }
                return null;
            }
            return (File) invokeL.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File e = oz3.e("aigames_debug");
                if (!e.exists()) {
                    e.mkdirs();
                }
                return e;
            }
            return (File) invokeV.objValue;
        }

        public static File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
                file.mkdirs();
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static File e(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fileArr)) == null) {
                File file = null;
                for (File file2 : fileArr) {
                    if (file == null || file2.lastModified() > file.lastModified()) {
                        file = file2;
                    }
                }
                return file;
            }
            return (File) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends rl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public s24 c;

        public c() {
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
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class a implements FileFilter {
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

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && TextUtils.isDigitsOnly(file.getName()) : invokeL.booleanValue;
            }
        }

        @SuppressLint({"BDThrowableCheck"})
        public static long a(String str, String str2) throws IllegalArgumentException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (TextUtils.isDigitsOnly(str) && TextUtils.isDigitsOnly(str2)) {
                        return Long.parseLong(str) - Long.parseLong(str2);
                    }
                    throw new IllegalArgumentException("version is not digits only");
                }
                throw new IllegalArgumentException("version null");
            }
            return invokeLL.longValue;
        }

        public static File b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (i(str2, file.getName())) {
                    if (oz3.a) {
                        Log.i("SwanGameBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                    }
                    va4.i().d(str, file.getName());
                    cj4.j(file);
                }
            }
        }

        public static void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File e = e(str, false);
            if (e != null) {
                cj4.L(e);
            }
            cj4.L(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f(str, z, null);
            }
            return (File) invokeLZ.objValue;
        }

        public static File f(String str, boolean z, eh3 eh3Var) {
            InterceptResult invokeCommon;
            File g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, Boolean.valueOf(z), eh3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File[] listFiles = g().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    if (oz3.a && z) {
                        q23.g(AppRuntime.getAppContext(), g.getPath() + " 没有小游戏包!").G();
                    }
                    re3 re3Var = new re3();
                    re3Var.k(5L);
                    re3Var.i(4L);
                    re3Var.f("没有小游戏包! for release, bundle files are empty");
                    ve3.a().f(re3Var);
                    if (eh3Var != null) {
                        eh3Var.a = re3Var;
                    }
                    return null;
                }
                for (File file : listFiles) {
                    if (TextUtils.equals(file.getName(), str + ".aigames")) {
                        return file;
                    }
                }
                if (oz3.a && z) {
                    q23.g(AppRuntime.getAppContext(), g.getPath() + " 没有小游戏包!").G();
                }
                re3 re3Var2 = new re3();
                re3Var2.k(5L);
                re3Var2.i(4L);
                re3Var2.f("没有小游戏包! for release, no such bundle file");
                ve3.a().f(re3Var2);
                if (eh3Var != null) {
                    eh3Var.a = re3Var2;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File h(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
            }
            return (File) invokeLL.objValue;
        }

        public static boolean i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
                if (oz3.a) {
                    Log.i("SwanGameBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e) {
                    if (oz3.a) {
                        Log.e("SwanGameBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static c j(vn2 vn2Var, eh3 eh3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, vn2Var, eh3Var)) == null) {
                if (vn2Var == null) {
                    return null;
                }
                File h = h(vn2Var.H(), vn2Var.v1());
                if (!h.exists()) {
                    File f = f(vn2Var.H(), true, eh3Var);
                    if (f == null) {
                        tz2.Q().a0(8, new SwanAppDeleteInfo(vn2Var.H(), 1).setPurgerScenes(5));
                        return null;
                    }
                    b(h);
                    if (!oz3.i(f, h, vn2Var, eh3Var)) {
                        q23.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        re3 re3Var = new re3();
                        re3Var.k(5L);
                        re3Var.i(7L);
                        re3Var.f("小游戏bundle解压失败! for release");
                        ve3.a().f(re3Var);
                        if (eh3Var != null && eh3Var.a == null) {
                            eh3Var.a = re3Var;
                        }
                        return null;
                    }
                }
                c(vn2Var.H(), vn2Var.v1());
                c cVar = new c();
                File file = new File(h, "game.json");
                s24 a2 = s24.a(cj4.E(file));
                if (a2 == null) {
                    return null;
                }
                cVar.a = h.getPath() + File.separator;
                cVar.c = a2;
                if (!TextUtils.isEmpty(a2.e)) {
                    cVar.b = cVar.a + File.separator + a2.e + File.separator;
                    j24.a().d(true);
                    j24.a().e(cVar.b);
                    j24.a().f(a2.e);
                } else {
                    j24.a().d(false);
                }
                if (oz3.a) {
                    Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.a);
                    Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.b);
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948049505, "Lcom/baidu/tieba/oz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948049505, "Lcom/baidu/tieba/oz3;");
                return;
            }
        }
        a = ij1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static void c(vn2 vn2Var, sl2 sl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vn2Var, sl2Var) == null) {
            b.execute(new a(vn2Var, sl2Var));
        }
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
            return TextUtils.isEmpty(str) ? file : new File(file, str);
        }
        return (File) invokeL.objValue;
    }

    public static void f(String str, ul2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, cVar) == null) {
            ul2.d dVar = new ul2.d();
            dVar.a = str;
            ny3.a();
            new fa2().e(dVar, ny3.c().getPath(), cVar);
        }
    }

    public static void g(String str, ul2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            ul2.d dVar = new ul2.d();
            dVar.a = str;
            cz3.a();
            new fa2().e(dVar, cz3.c().getPath(), cVar);
        }
    }

    public static void h(ul2.d dVar, ul2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, dVar, cVar) == null) {
            File c2 = b.c();
            new fa2().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean i(File file, File file2, vn2 vn2Var, eh3 eh3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, file, file2, vn2Var, eh3Var)) == null) {
            int i = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    dw2.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    xl2.c j = xl2.j(file);
                    int i2 = j.b;
                    if (i2 != -1) {
                        U = xl2.d(j.a, file2, i2).a;
                        i = j.b;
                    } else {
                        U = cj4.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        xl2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        re3 re3Var = new re3();
                        re3Var.k(5L);
                        re3Var.i(7L);
                        re3Var.f("小游戏bundle解压失败! PkgType=" + i);
                        if (eh3Var != null) {
                            eh3Var.a = re3Var;
                        }
                    }
                    HybridUbcFlow o = dw2.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i));
                    return U;
                }
                re3 re3Var2 = new re3();
                re3Var2.k(5L);
                re3Var2.i(4L);
                re3Var2.f("小游戏bundle文件不存在或者空文件! ");
                if (eh3Var != null) {
                    eh3Var.a = re3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
