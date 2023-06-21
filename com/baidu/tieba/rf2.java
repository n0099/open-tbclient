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
import com.baidu.tieba.vu2;
import com.baidu.tieba.yu2;
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
/* loaded from: classes7.dex */
public final class rf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                ds4.j(new File(filesDir, "aiapps_zip"));
                ds4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            ds4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948119627, "Lcom/baidu/tieba/rf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948119627, "Lcom/baidu/tieba/rf2;");
                return;
            }
        }
        a = js1.a;
        b = false;
    }

    public rf2() {
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
        synchronized (rf2.class) {
            if (b) {
                return;
            }
            b = true;
            to3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return vu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return hv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return hv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return vu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return vu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return hv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static sn3 a(ReadableByteChannel readableByteChannel, String str, rj4 rj4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, rj4Var)) == null) {
            if (readableByteChannel == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(11L);
                sn3Var.i(2300L);
                sn3Var.f("empty source");
                wn3.a().f(sn3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sn3Var);
                }
                return sn3Var;
            }
            rj4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            rj4Var.n("770", "na_pms_start_check_sign");
            if (mp3.d(readableByteChannel, str, new gq3())) {
                rj4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                rj4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            sn3 sn3Var2 = new sn3();
            sn3Var2.k(11L);
            sn3Var2.i(2300L);
            sn3Var2.f("check zip file sign fail.");
            wn3.a().f(sn3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sn3Var2);
            }
            return sn3Var2;
        }
        return (sn3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable xk4 xk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xk4Var)) == null) {
            if (xk4Var == null || TextUtils.isEmpty(xk4Var.a)) {
                return false;
            }
            File file = new File(xk4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(tk4 tk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tk4Var)) == null) {
            if (tk4Var == null) {
                return false;
            }
            int i = tk4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, yk4Var) == null) && pMSAppInfo != null && yk4Var != null) {
            pMSAppInfo.copyMainPkgInfo(yk4Var);
            if (yk4Var.h == 1) {
                pMSAppInfo.setOrientation(hv2.i().u(yk4Var.g, yk4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, zk4Var) == null) && pMSAppInfo != null && zk4Var != null) {
            pMSAppInfo.copySubPkgInfo(zk4Var);
            if (zk4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static sn3 m(xk4 xk4Var, rj4 rj4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, xk4Var, rj4Var)) == null) {
            if (xk4Var == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(11L);
                sn3Var.i(2320L);
                sn3Var.f("pkg info is empty");
                wn3.a().f(sn3Var);
                return sn3Var;
            }
            File file = new File(xk4Var.a);
            int i2 = xk4Var.h;
            if (i2 == 1) {
                i = hv2.g().a(xk4Var.g, String.valueOf(xk4Var.i));
                if (i == null) {
                    sn3 sn3Var2 = new sn3();
                    sn3Var2.k(11L);
                    sn3Var2.i(2320L);
                    sn3Var2.f("获取解压目录失败");
                    wn3.a().f(sn3Var2);
                    return sn3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = vu2.e.i(xk4Var.g, String.valueOf(xk4Var.i));
            } else {
                sn3 sn3Var3 = new sn3();
                sn3Var3.k(11L);
                sn3Var3.i(2320L);
                sn3Var3.f("pkh category illegal");
                wn3.a().f(sn3Var3);
                return sn3Var3;
            }
            if (!file.exists()) {
                sn3 sn3Var4 = new sn3();
                sn3Var4.k(11L);
                sn3Var4.i(2320L);
                sn3Var4.f("解压失败：包不存在");
                wn3.a().f(sn3Var4);
                return sn3Var4;
            } else if (i.isFile() && !i.delete()) {
                z82.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                sn3 sn3Var5 = new sn3();
                sn3Var5.k(11L);
                sn3Var5.i(2320L);
                sn3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                wn3.a().f(sn3Var5);
                return sn3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                sn3 sn3Var6 = new sn3();
                sn3Var6.k(11L);
                sn3Var6.i(2320L);
                sn3Var6.f("解压失败：解压文件夹创建失败");
                wn3.a().f(sn3Var6);
                return sn3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, rj4Var).b) {
                    return null;
                }
                b n = n(file, i, rj4Var);
                if (n.b) {
                    oi3.a(rj4Var, xk4Var.h, true);
                    return null;
                }
                oi3.a(rj4Var, xk4Var.h, false);
                z82.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                ds4.L(i);
                sn3 sn3Var7 = new sn3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        sn3Var7.k(4L);
                        sn3Var7.i(7L);
                        sn3Var7.f("Unkown bundle type");
                    } else {
                        sn3Var7.k(11L);
                        sn3Var7.i(2330L);
                        sn3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    sn3Var7.k(11L);
                    sn3Var7.i(2320L);
                    sn3Var7.f("unzip failed");
                }
                wn3.a().f(sn3Var7);
                return sn3Var7;
            }
        }
        return (sn3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull rj4 rj4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, rj4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            yu2.c j = yu2.j(file);
            int i = 0;
            if (j.b != -1) {
                rj4Var.n("670", "package_start_decrypt");
                rj4Var.n("770", "na_package_start_decrypt");
                yu2.b d = yu2.d(j.a, file2, j.b);
                rj4Var.n("670", "package_end_decrypt");
                rj4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                rj4Var.n("670", "package_start_unzip");
                rj4Var.n("770", "na_package_start_unzip");
                boolean U = ds4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = ds4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        aj3 aj3Var = new aj3();
                        sn3 sn3Var = new sn3();
                        sn3Var.k(4L);
                        sn3Var.i(52L);
                        aj3Var.p(sn3Var);
                        aj3Var.l("path", file2.getAbsolutePath());
                        aj3Var.l("eMsg", "unzip files not match zip content");
                        aj3Var.l("decryptType", String.valueOf(j.b));
                        aj3Var.l("stack", tp3.z(30));
                        si3.R(aj3Var);
                    }
                }
                rj4Var.n("670", "package_end_unzip");
                rj4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                yu2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            vj4.a(rj4Var, bundle, "event_download_package_type");
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
            rc3.u(pMSAppInfo.appId, "", zo3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            rc3.t("", zo3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            rc3.s(pMSAppInfo.appId, zo3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            rc3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
