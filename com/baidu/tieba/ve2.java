package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cu2;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes8.dex */
public final class ve2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File filesDir = AppRuntime.getAppContext().getFilesDir();
                hr4.j(new File(filesDir, "aiapps_zip"));
                hr4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            hr4.L(file2);
                        }
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
        public boolean b;
        public String c;

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
            this.b = false;
            this.c = "";
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948237830, "Lcom/baidu/tieba/ve2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948237830, "Lcom/baidu/tieba/ve2;");
                return;
            }
        }
        a = nr1.a;
        b = false;
    }

    public ve2() {
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

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || b) {
            return;
        }
        synchronized (ve2.class) {
            if (b) {
                return;
            }
            b = true;
            xn3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return zt2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return lu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return lu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return zt2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return zt2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return lu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static wm3 a(ReadableByteChannel readableByteChannel, String str, vi4 vi4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, vi4Var)) == null) {
            if (readableByteChannel == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(11L);
                wm3Var.i(2300L);
                wm3Var.f("empty source");
                an3.a().f(wm3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + wm3Var);
                }
                return wm3Var;
            }
            vi4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            vi4Var.n("770", "na_pms_start_check_sign");
            if (qo3.d(readableByteChannel, str, new kp3())) {
                vi4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                vi4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            wm3 wm3Var2 = new wm3();
            wm3Var2.k(11L);
            wm3Var2.i(2300L);
            wm3Var2.f("check zip file sign fail.");
            an3.a().f(wm3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + wm3Var2);
            }
            return wm3Var2;
        }
        return (wm3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable bk4 bk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bk4Var)) == null) {
            if (bk4Var == null || TextUtils.isEmpty(bk4Var.a)) {
                return false;
            }
            File file = new File(bk4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(xj4 xj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, xj4Var)) == null) {
            if (xj4Var == null) {
                return false;
            }
            int i = xj4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, ck4 ck4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, ck4Var) == null) && pMSAppInfo != null && ck4Var != null) {
            pMSAppInfo.copyMainPkgInfo(ck4Var);
            if (ck4Var.h == 1) {
                pMSAppInfo.setOrientation(lu2.i().u(ck4Var.g, ck4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, dk4Var) == null) && pMSAppInfo != null && dk4Var != null) {
            pMSAppInfo.copySubPkgInfo(dk4Var);
            if (dk4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static wm3 m(bk4 bk4Var, vi4 vi4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, bk4Var, vi4Var)) == null) {
            if (bk4Var == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(11L);
                wm3Var.i(2320L);
                wm3Var.f("pkg info is empty");
                an3.a().f(wm3Var);
                return wm3Var;
            }
            File file = new File(bk4Var.a);
            int i2 = bk4Var.h;
            if (i2 == 1) {
                i = lu2.g().a(bk4Var.g, String.valueOf(bk4Var.i));
                if (i == null) {
                    wm3 wm3Var2 = new wm3();
                    wm3Var2.k(11L);
                    wm3Var2.i(2320L);
                    wm3Var2.f("获取解压目录失败");
                    an3.a().f(wm3Var2);
                    return wm3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = zt2.e.i(bk4Var.g, String.valueOf(bk4Var.i));
            } else {
                wm3 wm3Var3 = new wm3();
                wm3Var3.k(11L);
                wm3Var3.i(2320L);
                wm3Var3.f("pkh category illegal");
                an3.a().f(wm3Var3);
                return wm3Var3;
            }
            if (!file.exists()) {
                wm3 wm3Var4 = new wm3();
                wm3Var4.k(11L);
                wm3Var4.i(2320L);
                wm3Var4.f("解压失败：包不存在");
                an3.a().f(wm3Var4);
                return wm3Var4;
            } else if (i.isFile() && !i.delete()) {
                d82.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                wm3 wm3Var5 = new wm3();
                wm3Var5.k(11L);
                wm3Var5.i(2320L);
                wm3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                an3.a().f(wm3Var5);
                return wm3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                wm3 wm3Var6 = new wm3();
                wm3Var6.k(11L);
                wm3Var6.i(2320L);
                wm3Var6.f("解压失败：解压文件夹创建失败");
                an3.a().f(wm3Var6);
                return wm3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, vi4Var).b) {
                    return null;
                }
                b n = n(file, i, vi4Var);
                if (n.b) {
                    sh3.a(vi4Var, bk4Var.h, true);
                    return null;
                }
                sh3.a(vi4Var, bk4Var.h, false);
                d82.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                hr4.L(i);
                wm3 wm3Var7 = new wm3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        wm3Var7.k(4L);
                        wm3Var7.i(7L);
                        wm3Var7.f("Unkown bundle type");
                    } else {
                        wm3Var7.k(11L);
                        wm3Var7.i(2330L);
                        wm3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    wm3Var7.k(11L);
                    wm3Var7.i(2320L);
                    wm3Var7.f("unzip failed");
                }
                an3.a().f(wm3Var7);
                return wm3Var7;
            }
        }
        return (wm3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull vi4 vi4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, vi4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            cu2.c j = cu2.j(file);
            int i = 0;
            if (j.b != -1) {
                vi4Var.n("670", "package_start_decrypt");
                vi4Var.n("770", "na_package_start_decrypt");
                cu2.b d = cu2.d(j.a, file2, j.b);
                vi4Var.n("670", "package_end_decrypt");
                vi4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                vi4Var.n("670", "package_start_unzip");
                vi4Var.n("770", "na_package_start_unzip");
                boolean U = hr4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = hr4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ei3 ei3Var = new ei3();
                        wm3 wm3Var = new wm3();
                        wm3Var.k(4L);
                        wm3Var.i(52L);
                        ei3Var.p(wm3Var);
                        ei3Var.l("path", file2.getAbsolutePath());
                        ei3Var.l("eMsg", "unzip files not match zip content");
                        ei3Var.l("decryptType", String.valueOf(j.b));
                        ei3Var.l("stack", xo3.z(30));
                        wh3.R(ei3Var);
                    }
                }
                vi4Var.n("670", "package_end_unzip");
                vi4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                cu2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            zi4.a(vi4Var, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65552, null, pMSAppInfo) != null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            vb3.u(pMSAppInfo.appId, "", do3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            vb3.t("", do3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            vb3.s(pMSAppInfo.appId, do3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            vb3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
