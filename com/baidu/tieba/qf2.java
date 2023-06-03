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
import com.baidu.tieba.uu2;
import com.baidu.tieba.xu2;
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
public final class qf2 {
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
                cs4.j(new File(filesDir, "aiapps_zip"));
                cs4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            cs4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948089836, "Lcom/baidu/tieba/qf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948089836, "Lcom/baidu/tieba/qf2;");
                return;
            }
        }
        a = is1.a;
        b = false;
    }

    public qf2() {
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
        synchronized (qf2.class) {
            if (b) {
                return;
            }
            b = true;
            so3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return uu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return gv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return gv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return uu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return uu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return gv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static rn3 a(ReadableByteChannel readableByteChannel, String str, qj4 qj4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, qj4Var)) == null) {
            if (readableByteChannel == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(11L);
                rn3Var.i(2300L);
                rn3Var.f("empty source");
                vn3.a().f(rn3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + rn3Var);
                }
                return rn3Var;
            }
            qj4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            qj4Var.n("770", "na_pms_start_check_sign");
            if (lp3.d(readableByteChannel, str, new fq3())) {
                qj4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                qj4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            rn3 rn3Var2 = new rn3();
            rn3Var2.k(11L);
            rn3Var2.i(2300L);
            rn3Var2.f("check zip file sign fail.");
            vn3.a().f(rn3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + rn3Var2);
            }
            return rn3Var2;
        }
        return (rn3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, wk4Var)) == null) {
            if (wk4Var == null || TextUtils.isEmpty(wk4Var.a)) {
                return false;
            }
            File file = new File(wk4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(sk4 sk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sk4Var)) == null) {
            if (sk4Var == null) {
                return false;
            }
            int i = sk4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, xk4 xk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, xk4Var) == null) && pMSAppInfo != null && xk4Var != null) {
            pMSAppInfo.copyMainPkgInfo(xk4Var);
            if (xk4Var.h == 1) {
                pMSAppInfo.setOrientation(gv2.i().u(xk4Var.g, xk4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, yk4Var) == null) && pMSAppInfo != null && yk4Var != null) {
            pMSAppInfo.copySubPkgInfo(yk4Var);
            if (yk4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static rn3 m(wk4 wk4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, wk4Var, qj4Var)) == null) {
            if (wk4Var == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(11L);
                rn3Var.i(2320L);
                rn3Var.f("pkg info is empty");
                vn3.a().f(rn3Var);
                return rn3Var;
            }
            File file = new File(wk4Var.a);
            int i2 = wk4Var.h;
            if (i2 == 1) {
                i = gv2.g().a(wk4Var.g, String.valueOf(wk4Var.i));
                if (i == null) {
                    rn3 rn3Var2 = new rn3();
                    rn3Var2.k(11L);
                    rn3Var2.i(2320L);
                    rn3Var2.f("获取解压目录失败");
                    vn3.a().f(rn3Var2);
                    return rn3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = uu2.e.i(wk4Var.g, String.valueOf(wk4Var.i));
            } else {
                rn3 rn3Var3 = new rn3();
                rn3Var3.k(11L);
                rn3Var3.i(2320L);
                rn3Var3.f("pkh category illegal");
                vn3.a().f(rn3Var3);
                return rn3Var3;
            }
            if (!file.exists()) {
                rn3 rn3Var4 = new rn3();
                rn3Var4.k(11L);
                rn3Var4.i(2320L);
                rn3Var4.f("解压失败：包不存在");
                vn3.a().f(rn3Var4);
                return rn3Var4;
            } else if (i.isFile() && !i.delete()) {
                y82.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                rn3 rn3Var5 = new rn3();
                rn3Var5.k(11L);
                rn3Var5.i(2320L);
                rn3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                vn3.a().f(rn3Var5);
                return rn3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                rn3 rn3Var6 = new rn3();
                rn3Var6.k(11L);
                rn3Var6.i(2320L);
                rn3Var6.f("解压失败：解压文件夹创建失败");
                vn3.a().f(rn3Var6);
                return rn3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, qj4Var).b) {
                    return null;
                }
                b n = n(file, i, qj4Var);
                if (n.b) {
                    ni3.a(qj4Var, wk4Var.h, true);
                    return null;
                }
                ni3.a(qj4Var, wk4Var.h, false);
                y82.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                cs4.L(i);
                rn3 rn3Var7 = new rn3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        rn3Var7.k(4L);
                        rn3Var7.i(7L);
                        rn3Var7.f("Unkown bundle type");
                    } else {
                        rn3Var7.k(11L);
                        rn3Var7.i(2330L);
                        rn3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    rn3Var7.k(11L);
                    rn3Var7.i(2320L);
                    rn3Var7.f("unzip failed");
                }
                vn3.a().f(rn3Var7);
                return rn3Var7;
            }
        }
        return (rn3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull qj4 qj4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, qj4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            xu2.c j = xu2.j(file);
            int i = 0;
            if (j.b != -1) {
                qj4Var.n("670", "package_start_decrypt");
                qj4Var.n("770", "na_package_start_decrypt");
                xu2.b d = xu2.d(j.a, file2, j.b);
                qj4Var.n("670", "package_end_decrypt");
                qj4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                qj4Var.n("670", "package_start_unzip");
                qj4Var.n("770", "na_package_start_unzip");
                boolean U = cs4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = cs4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        zi3 zi3Var = new zi3();
                        rn3 rn3Var = new rn3();
                        rn3Var.k(4L);
                        rn3Var.i(52L);
                        zi3Var.p(rn3Var);
                        zi3Var.l("path", file2.getAbsolutePath());
                        zi3Var.l("eMsg", "unzip files not match zip content");
                        zi3Var.l("decryptType", String.valueOf(j.b));
                        zi3Var.l("stack", sp3.z(30));
                        ri3.R(zi3Var);
                    }
                }
                qj4Var.n("670", "package_end_unzip");
                qj4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                xu2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            uj4.a(qj4Var, bundle, "event_download_package_type");
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
            qc3.u(pMSAppInfo.appId, "", yo3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            qc3.t("", yo3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            qc3.s(pMSAppInfo.appId, yo3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            qc3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
