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
import com.baidu.tieba.bn2;
import com.baidu.tieba.en2;
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
/* loaded from: classes6.dex */
public final class x72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                jk4.j(new File(filesDir, "aiapps_zip"));
                jk4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            jk4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948253206, "Lcom/baidu/tieba/x72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948253206, "Lcom/baidu/tieba/x72;");
                return;
            }
        }
        a = pk1.a;
        b = false;
    }

    public x72() {
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
        synchronized (x72.class) {
            if (b) {
                return;
            }
            b = true;
            zg3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return bn2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return nn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return nn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return bn2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return bn2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return nn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static yf3 a(ReadableByteChannel readableByteChannel, String str, xb4 xb4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, xb4Var)) == null) {
            if (readableByteChannel == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(11L);
                yf3Var.i(2300L);
                yf3Var.f("empty source");
                cg3.a().f(yf3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + yf3Var);
                }
                return yf3Var;
            }
            xb4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            xb4Var.n("770", "na_pms_start_check_sign");
            if (sh3.d(readableByteChannel, str, new mi3())) {
                xb4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                xb4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            yf3 yf3Var2 = new yf3();
            yf3Var2.k(11L);
            yf3Var2.i(2300L);
            yf3Var2.f("check zip file sign fail.");
            cg3.a().f(yf3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + yf3Var2);
            }
            return yf3Var2;
        }
        return (yf3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable dd4 dd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dd4Var)) == null) {
            if (dd4Var == null || TextUtils.isEmpty(dd4Var.a)) {
                return false;
            }
            File file = new File(dd4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(zc4 zc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, zc4Var)) == null) {
            if (zc4Var == null) {
                return false;
            }
            int i = zc4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, ed4Var) == null) && pMSAppInfo != null && ed4Var != null) {
            pMSAppInfo.copyMainPkgInfo(ed4Var);
            if (ed4Var.h == 1) {
                pMSAppInfo.setOrientation(nn2.i().u(ed4Var.g, ed4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, fd4Var) == null) && pMSAppInfo != null && fd4Var != null) {
            pMSAppInfo.copySubPkgInfo(fd4Var);
            if (fd4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static yf3 m(dd4 dd4Var, xb4 xb4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, dd4Var, xb4Var)) == null) {
            if (dd4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(11L);
                yf3Var.i(2320L);
                yf3Var.f("pkg info is empty");
                cg3.a().f(yf3Var);
                return yf3Var;
            }
            File file = new File(dd4Var.a);
            int i2 = dd4Var.h;
            if (i2 == 1) {
                i = nn2.g().a(dd4Var.g, String.valueOf(dd4Var.i));
                if (i == null) {
                    yf3 yf3Var2 = new yf3();
                    yf3Var2.k(11L);
                    yf3Var2.i(2320L);
                    yf3Var2.f("获取解压目录失败");
                    cg3.a().f(yf3Var2);
                    return yf3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = bn2.e.i(dd4Var.g, String.valueOf(dd4Var.i));
            } else {
                yf3 yf3Var3 = new yf3();
                yf3Var3.k(11L);
                yf3Var3.i(2320L);
                yf3Var3.f("pkh category illegal");
                cg3.a().f(yf3Var3);
                return yf3Var3;
            }
            if (!file.exists()) {
                yf3 yf3Var4 = new yf3();
                yf3Var4.k(11L);
                yf3Var4.i(2320L);
                yf3Var4.f("解压失败：包不存在");
                cg3.a().f(yf3Var4);
                return yf3Var4;
            } else if (i.isFile() && !i.delete()) {
                f12.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                yf3 yf3Var5 = new yf3();
                yf3Var5.k(11L);
                yf3Var5.i(2320L);
                yf3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                cg3.a().f(yf3Var5);
                return yf3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                yf3 yf3Var6 = new yf3();
                yf3Var6.k(11L);
                yf3Var6.i(2320L);
                yf3Var6.f("解压失败：解压文件夹创建失败");
                cg3.a().f(yf3Var6);
                return yf3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, xb4Var).b) {
                    return null;
                }
                b n = n(file, i, xb4Var);
                if (n.b) {
                    ua3.a(xb4Var, dd4Var.h, true);
                    return null;
                }
                ua3.a(xb4Var, dd4Var.h, false);
                f12.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                jk4.L(i);
                yf3 yf3Var7 = new yf3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        yf3Var7.k(4L);
                        yf3Var7.i(7L);
                        yf3Var7.f("Unkown bundle type");
                    } else {
                        yf3Var7.k(11L);
                        yf3Var7.i(2330L);
                        yf3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    yf3Var7.k(11L);
                    yf3Var7.i(2320L);
                    yf3Var7.f("unzip failed");
                }
                cg3.a().f(yf3Var7);
                return yf3Var7;
            }
        }
        return (yf3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull xb4 xb4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, xb4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            en2.c j = en2.j(file);
            int i = 0;
            if (j.b != -1) {
                xb4Var.n("670", "package_start_decrypt");
                xb4Var.n("770", "na_package_start_decrypt");
                en2.b d = en2.d(j.a, file2, j.b);
                xb4Var.n("670", "package_end_decrypt");
                xb4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                xb4Var.n("670", "package_start_unzip");
                xb4Var.n("770", "na_package_start_unzip");
                boolean U = jk4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = jk4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        gb3 gb3Var = new gb3();
                        yf3 yf3Var = new yf3();
                        yf3Var.k(4L);
                        yf3Var.i(52L);
                        gb3Var.p(yf3Var);
                        gb3Var.l("path", file2.getAbsolutePath());
                        gb3Var.l("eMsg", "unzip files not match zip content");
                        gb3Var.l("decryptType", String.valueOf(j.b));
                        gb3Var.l("stack", zh3.z(30));
                        ya3.R(gb3Var);
                    }
                }
                xb4Var.n("670", "package_end_unzip");
                xb4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                en2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            bc4.a(xb4Var, bundle, "event_download_package_type");
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
            x43.u(pMSAppInfo.appId, "", fh3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            x43.t("", fh3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            x43.s(pMSAppInfo.appId, fh3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            x43.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
