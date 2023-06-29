package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bv2;
import com.baidu.tieba.ki3;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
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
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                    if (file.isDirectory() && TextUtils.isDigitsOnly(file.getName())) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
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
            if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new a());
                if (listFiles != null && listFiles.length > 0) {
                    for (File file : listFiles) {
                        if (k(str2, file.getName())) {
                            c92.k("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                            zj4.i().d(str, file.getName());
                            gs4.j(file);
                            g23.b(str, file.getName());
                        }
                    }
                }
            }
        }

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                gs4.L(yu2.q());
            }
        }

        public static File h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            File f = f(str, false);
            if (f != null) {
                gs4.L(f);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            g23.a(str);
            gs4.L(file);
            gs4.L(new File(yu2.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                gs4.L(new File(yu2.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
                return g(str, z, null);
            }
            return (File) invokeLZ.objValue;
        }

        public static File i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
                return j(str, str2, null);
            }
            return (File) invokeLL.objValue;
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable iq3 iq3Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), iq3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File h = h();
                File file = new File(h, str + ".aiapps");
                if (file.exists() && file.isFile()) {
                    return file;
                }
                if (yu2.a && z) {
                    Context appContext = AppRuntime.getAppContext();
                    ub3.g(appContext, h.getPath() + " 没有小程序包!").G();
                }
                if (iq3Var != null) {
                    vn3 vn3Var = new vn3();
                    vn3Var.k(5L);
                    vn3Var.i(4L);
                    vn3Var.f("没有小程序包! for release, no such bundle file");
                    zn3.a().f(vn3Var);
                    iq3Var.a = vn3Var;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File j(String str, String str2, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, jSONObject)) == null) {
                if (xi3.e(str2)) {
                    xi3.f(str, str2, jSONObject);
                }
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
            }
            return (File) invokeLLL.objValue;
        }

        public static boolean k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
                if (yu2.a) {
                    Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    if (a(str, str2) <= 0) {
                        return false;
                    }
                    return true;
                } catch (IllegalArgumentException e) {
                    if (yu2.a) {
                        Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static g l(zw2 zw2Var, iq3 iq3Var, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, zw2Var, iq3Var, jSONObject)) == null) {
                if (zw2Var == null) {
                    return null;
                }
                File v = yu2.v(zw2Var.H(), zw2Var.v1(), zw2Var.o0(), zw2Var.h0(), jSONObject);
                if (!v.exists()) {
                    File g = g(zw2Var.H(), true, iq3Var);
                    if (g == null) {
                        x83.Q().a0(8, new SwanAppDeleteInfo(zw2Var.H(), 1).setPurgerScenes(5));
                        vn3 vn3Var = new vn3();
                        vn3Var.k(5L);
                        vn3Var.i(31L);
                        vn3Var.f("小程序zip和bundle不存在，兜底重置");
                        dj3 dj3Var = new dj3();
                        dj3Var.q(vi3.n(zw2Var.G()));
                        dj3Var.p(vn3Var);
                        dj3Var.r(zw2Var);
                        vi3.R(dj3Var);
                        if (yu2.a) {
                            Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        }
                        return null;
                    }
                    b(v);
                    if (!yu2.N(g, v, zw2Var, iq3Var)) {
                        ub3.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        vn3 vn3Var2 = new vn3();
                        vn3Var2.k(5L);
                        vn3Var2.i(7L);
                        vn3Var2.f("小程序bundle解压失败! for release");
                        zn3.a().f(vn3Var2);
                        if (iq3Var != null && iq3Var.a == null) {
                            iq3Var.a = vn3Var2;
                        }
                        return null;
                    }
                }
                c(zw2Var.H(), zw2Var.v1());
                g gVar = new g();
                File file = new File(v, "app.json");
                SwanAppConfigData b = oc3.b(v.getAbsolutePath());
                if (b == null) {
                    return null;
                }
                gVar.a = i(zw2Var.H(), zw2Var.v1()).getPath() + File.separator;
                gVar.b = b;
                j73.m(b, true);
                a83.l(b);
                h73.a(b);
                c92.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ wu2 c;

        public a(zw2 zw2Var, JSONObject jSONObject, wu2 wu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw2Var, jSONObject, wu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw2Var;
            this.b = jSONObject;
            this.c = wu2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            int i;
            SwanAppConfigData swanAppConfigData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iq3 iq3Var = new iq3();
                if (b83.B(this.a)) {
                    l = b83.c(this.a, iq3Var);
                } else {
                    l = e.l(this.a, iq3Var, this.b);
                }
                if (l == null || (swanAppConfigData = l.b) == null || swanAppConfigData.b == null) {
                    vn3 vn3Var = iq3Var.a;
                    if (vn3Var == null) {
                        vn3Var = new vn3();
                        vn3Var.k(5L);
                        vn3Var.i(20L);
                        vn3Var.f("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    dj3 dj3Var = new dj3();
                    zw2 zw2Var = this.a;
                    if (zw2Var != null) {
                        i = zw2Var.G();
                    } else {
                        i = 0;
                    }
                    dj3Var.q(vi3.n(i));
                    dj3Var.p(vn3Var);
                    dj3Var.s("appjson_config_invalid");
                    dj3Var.r(this.a);
                    vi3.R(dj3Var);
                }
                this.c.a(0, l);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(zw2 zw2Var, iq3 iq3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, zw2Var, iq3Var)) == null) {
                File b = b(iq3Var);
                if (b == null) {
                    return null;
                }
                cc3 M = cc3.M();
                if (M != null) {
                    String q = M.e0().q("installed_debug_bundle_md5", "");
                    String b2 = is4.b(b, false);
                    if (!TextUtils.equals(q, b2)) {
                        if (!yu2.N(b, e(), zw2Var, iq3Var)) {
                            ub3.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                            vn3 vn3Var = new vn3();
                            vn3Var.k(5L);
                            vn3Var.i(7L);
                            vn3Var.f("小程序bundle解压失败! for debug");
                            zn3.a().f(vn3Var);
                            if (iq3Var != null && iq3Var.a == null) {
                                iq3Var.a = vn3Var;
                            }
                            return null;
                        }
                        M.e0().B("installed_debug_bundle_md5", b2);
                    }
                } else if (!yu2.N(b, e(), zw2Var, iq3Var)) {
                    ub3.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                    vn3 vn3Var2 = new vn3();
                    vn3Var2.k(5L);
                    vn3Var2.i(7L);
                    vn3Var2.f("小程序bundle解压失败! for debug");
                    zn3.a().f(vn3Var2);
                    if (iq3Var != null && iq3Var.a == null) {
                        iq3Var.a = vn3Var2;
                    }
                    return null;
                }
                g gVar = new g();
                File g = g();
                File file = new File(g, "app.json");
                SwanAppConfigData b3 = oc3.b(g.getAbsolutePath());
                gVar.a = g.getPath() + File.separator;
                gVar.b = b3;
                j73.m(b3, true);
                a83.l(b3);
                h73.a(b3);
                c92.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLL.objValue;
        }

        public static File b(iq3 iq3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iq3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return h(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                ub3.g(appContext, c.getPath() + " 没有测试程序包!").G();
                vn3 vn3Var = new vn3();
                vn3Var.k(5L);
                vn3Var.i(4L);
                vn3Var.f("没有小程序包! for debug, bundle files are empty");
                zn3.a().f(vn3Var);
                if (iq3Var != null) {
                    iq3Var.a = vn3Var;
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
                File file = new File(uw2.d().get(0).a, "/aiapps_debug/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aiapps_bundle";
            }
            return (String) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return new File(uw2.d().get(0).a, "/aiapps_debug/").getAbsolutePath();
            }
            return (String) invokeV.objValue;
        }

        public static File e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
                file.mkdirs();
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                return e();
            }
            return (File) invokeV.objValue;
        }

        public static File h(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fileArr)) == null) {
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

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public d() {
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

    /* loaded from: classes8.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(zw2 zw2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zw2Var)) == null) {
                File e = e();
                s92.g().h("unzipstart");
                yu2.M(b(), e, zw2Var);
                s92.g().h("unzipend");
                g gVar = new g();
                File file = new File(e, "app.json");
                SwanAppConfigData b = oc3.b(e.getAbsolutePath());
                gVar.a = e.getPath() + File.separator;
                gVar.b = b;
                j73.m(b, true);
                a83.l(b);
                h73.a(b);
                c92.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public static File b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new File(c(), "remote_debug.aiapps");
            }
            return (File) invokeV.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_zip";
            }
            return (String) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_folder";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class g extends vu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public SwanAppConfigData b;

        public g() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948342579, "Lcom/baidu/tieba/yu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948342579, "Lcom/baidu/tieba/yu2;");
                return;
            }
        }
        a = ms1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return i() + File.separator + "database";
        }
        return (String) invokeV.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
        }
        return (File) invokeV.objValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return qk3.a().getBoolean("swanapps_has_done_fallback_strategy_key", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            boolean exists = new File(k(str, str2), "app.json").exists();
            if (!exists) {
                c92.k("SwanAppBundleHelper", "#isAppJsonExist#1 [not exist] app.json");
            }
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            ki3.b bVar = new ki3.b(10015);
            bVar.j(str);
            bVar.l(str2);
            bVar.m();
        }
    }

    public static void G(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new jj2().e(dVar, rm2.j().getPath(), cVar);
        }
    }

    public static void H(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new jj2().e(dVar, sm2.j().getPath(), cVar);
        }
    }

    public static void I(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            tm2.a();
            new jj2().e(dVar, tm2.c().getPath(), cVar);
        }
    }

    public static void J(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            jl3.a();
            new jj2().e(dVar, jl3.d().getPath(), cVar);
        }
    }

    public static File k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, str2)) == null) {
            return new File(j(str), str2);
        }
        return (File) invokeLL.objValue;
    }

    public static boolean B(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            return z(p(str, str2, str3));
        }
        return invokeLLL.booleanValue;
    }

    public static boolean M(File file, File file2, zw2 zw2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, file, file2, zw2Var)) == null) {
            return N(file, file2, zw2Var, null);
        }
        return invokeLLL.booleanValue;
    }

    public static File p(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, str, str2, str3)) == null) {
            return new File(k(str, str2), up3.g(str3));
        }
        return (File) invokeLLL.objValue;
    }

    public static boolean C(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            String g2 = up3.g(str2);
            int lastIndexOf = g2.lastIndexOf(File.separator);
            if (lastIndexOf > 0) {
                g2 = g2.substring(0, lastIndexOf);
            }
            boolean exists = new File(str, g2).exists();
            if (a) {
                Log.d("SwanAppBundleHelper", "pagePath - " + g2 + ", isExist - " + exists);
            }
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static void c(zw2 zw2Var, wu2 wu2Var) {
        JSONObject jSONObject;
        String I1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, zw2Var, wu2Var) == null) {
            if (zw2Var != null && !xi3.e(zw2Var.v1())) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                String y = wp3.y();
                if (zw2Var == null) {
                    I1 = StringUtil.NULL_STRING;
                } else {
                    try {
                        I1 = zw2Var.I1();
                    } catch (JSONException e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                jSONObject.put("originLaunchInfo", I1);
                jSONObject.put("stackTraceBefore", y);
            }
            b.execute(new a(zw2Var, jSONObject, wu2Var));
        }
    }

    public static Pair<Boolean, Long> D(@NonNull File file) {
        InterceptResult invokeL;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            String name = file.getName();
            try {
                j = Long.parseLong(name);
                z = true;
            } catch (NumberFormatException e2) {
                c92.l("SwanAppBundleHelper", "#parseBundleVersion ex=", e2);
                if (name.endsWith(".tmp")) {
                    c92.k("SwanAppBundleHelper", "#parseBundleVersion deleteDir=" + file);
                    gs4.j(file);
                }
                j = Long.MAX_VALUE;
                z = false;
            }
            return Pair.create(Boolean.valueOf(z), Long.valueOf(j));
        }
        return (Pair) invokeL.objValue;
    }

    public static void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            qk3.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
        }
    }

    public static synchronized boolean O(@NonNull cc3 cc3Var) {
        InterceptResult invokeL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, cc3Var)) == null) {
            synchronized (yu2.class) {
                P = P(cc3Var, u(cc3Var));
            }
            return P;
        }
        return invokeL.booleanValue;
    }

    public static File j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            return new File(g(), str);
        }
        return (File) invokeL.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            return n() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            return f().contains(str);
        }
        return invokeL.booleanValue;
    }

    public static void K(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, dVar, cVar) == null) {
            File c2 = b.c();
            new jj2().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean L(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, file, str)) == null) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return true;
            }
            boolean mkdirs = file2.mkdirs();
            c92.k("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
            gs4.L(file2);
            return mkdirs;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean P(@NonNull cc3 cc3Var, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, cc3Var, file)) == null) {
            synchronized (yu2.class) {
                if (file != null) {
                    if (file.exists()) {
                        SwanAppConfigData b2 = uw2.b(file);
                        if (b2 != null) {
                            cc3Var.G0(b2);
                        }
                        j73.m(b2, true);
                        a83.l(b2);
                        h73.a(b2);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static File t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return new File(s(str), str2);
            }
            if (!a) {
                return null;
            }
            throw new IllegalArgumentException("plugin name or version can't be empty");
        }
        return (File) invokeLL.objValue;
    }

    public static boolean N(File file, File file2, zw2 zw2Var, iq3 iq3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, file, file2, zw2Var, iq3Var)) == null) {
            int i = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    h53.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    bv2.c j = bv2.j(file);
                    int i2 = j.b;
                    if (i2 != -1) {
                        U = bv2.d(j.a, file2, i2).a;
                        i = j.b;
                    } else {
                        U = gs4.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        bv2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        vn3 vn3Var = new vn3();
                        vn3Var.k(5L);
                        vn3Var.i(7L);
                        vn3Var.f("小程序bundle解压失败! PkgType=" + i);
                        if (iq3Var != null) {
                            iq3Var.a = vn3Var;
                        }
                    }
                    HybridUbcFlow o = h53.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i));
                    return U;
                }
                vn3 vn3Var2 = new vn3();
                vn3Var2.k(5L);
                vn3Var2.i(4L);
                vn3Var2.f("小程序bundle文件不存在或者空文件! ");
                if (iq3Var != null) {
                    iq3Var.a = vn3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, set, map) == null) {
            synchronized (yu2.class) {
                if (map != null) {
                    if (!map.isEmpty()) {
                        File o = kj3.o();
                        try {
                            for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (!TextUtils.isEmpty(key)) {
                                    if (set != null && set.contains(key)) {
                                        c92.k("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                    } else {
                                        long j = entry.getValue().versionCode;
                                        File file = new File(o, key);
                                        if (file.exists() && file.isDirectory()) {
                                            for (File file2 : gs4.C(file)) {
                                                if (file2 != null) {
                                                    Pair<Boolean, Long> D = D(file2);
                                                    if (((Boolean) D.first).booleanValue() && ((Long) D.second).longValue() < j) {
                                                        if (x(key)) {
                                                            break;
                                                        }
                                                        gs4.L(file2);
                                                        c92.k("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            c92.l("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            synchronized (yu2.class) {
                if (w()) {
                    nj4.b().y("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
                    E(str, "repeat");
                    return;
                }
                boolean z = true;
                F(true);
                E(str, "start");
                File g2 = g();
                if (L(g2, str)) {
                    E(str, "canwrite");
                    return;
                }
                lj4 b2 = nj4.b();
                b2.y("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
                if (g2.exists()) {
                    c92.k("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                    gs4.L(g2);
                }
                if (!g2.exists() && g2.mkdirs() && L(g2, str)) {
                    E(str, "delete");
                    return;
                }
                File h = h();
                if (h.exists() || !h.mkdirs() || !L(h, str)) {
                    z = false;
                }
                E(str, "fail:" + z);
            }
        }
    }

    @NonNull
    public static Set<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            LinkedHashSet<b93> q = d93.k().q();
            HashSet hashSet = new HashSet();
            for (b93 b93Var : q) {
                if (b93Var != null) {
                    String appId = b93Var.getAppId();
                    Set<String> M = b93Var.M();
                    if (!TextUtils.isEmpty(appId)) {
                        hashSet.add(appId);
                        if (a) {
                            Log.d("SwanAppBundleHelper", "appId in running - " + appId);
                        }
                    }
                    if (M.size() > 0) {
                        hashSet.addAll(M);
                        if (a) {
                            Log.d("SwanAppBundleHelper", "appId in prefetch - " + M);
                        }
                    }
                }
            }
            if (a) {
                Log.d("SwanAppBundleHelper", "active apps - " + hashSet);
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_folder_fallback");
        }
        return (File) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_zip";
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_plugin_workspace";
        }
        return (String) invokeV.objValue;
    }

    public static synchronized String m(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, file)) == null) {
            synchronized (yu2.class) {
                if (file == null) {
                    return "";
                }
                String path = file.getPath();
                if (a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                String str = (String) vi2.b().a(path, "");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                if (a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                }
                String E = gs4.E(file);
                vi2.b().c(path, E);
                if (a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                }
                return E;
            }
        }
        return (String) invokeL.objValue;
    }

    public static File u(@NonNull cc3 cc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, cc3Var)) == null) {
            if (cc3Var == null) {
                return null;
            }
            zw2.a W = cc3Var.W();
            File v = v(cc3Var.getAppId(), W.v1(), W.o0(), W.h0(), null);
            if (a) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + v.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + v.exists());
            }
            return v;
        }
        return (File) invokeL.objValue;
    }

    public static boolean y(File file) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, file)) == null) {
            boolean z = false;
            if (file != null && file.exists()) {
                File file2 = new File(file, "app.js");
                boolean exists = file2.exists();
                if (!exists) {
                    c92.k("SwanAppBundleHelper", "#isAppJsValid [not exist] app.json");
                }
                if (exists) {
                    j = file2.length();
                } else {
                    j = -1;
                }
                if (exists && j > 0) {
                    z = true;
                }
                if (!z) {
                    dj3 dj3Var = new dj3();
                    vn3 vn3Var = new vn3();
                    vn3Var.k(5L);
                    vn3Var.i(51L);
                    dj3Var.p(vn3Var);
                    dj3Var.l("path", file2.getAbsolutePath());
                    dj3Var.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + j);
                    dj3Var.l("stack", wp3.z(30));
                    vi3.R(dj3Var);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (!a) {
                    return null;
                }
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return new File(q(), str);
        }
        return (File) invokeL.objValue;
    }

    public static boolean z(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, file)) == null) {
            if (file != null && file.exists()) {
                boolean exists = new File(file, "app.json").exists();
                if (!exists) {
                    c92.k("SwanAppBundleHelper", "#isAppJsonExist#2 [not exist] app.json");
                }
                return exists;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static File v(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        InterceptResult invokeCommon;
        File j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{str, str2, Boolean.valueOf(z), str3, jSONObject})) == null) {
            if (b83.H()) {
                j = b.e();
            } else if (b83.D()) {
                j = j92.d();
            } else {
                j = e.j(str, str2, jSONObject);
            }
            if (z && !TextUtils.isEmpty(str3)) {
                return new File(j, str3);
            }
            return j;
        }
        return (File) invokeCommon.objValue;
    }
}
