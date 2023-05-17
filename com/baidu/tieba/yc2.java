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
import com.baidu.tieba.cs2;
import com.baidu.tieba.fs2;
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
public final class yc2 {
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
                kp4.j(new File(filesDir, "aiapps_zip"));
                kp4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            kp4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325281, "Lcom/baidu/tieba/yc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325281, "Lcom/baidu/tieba/yc2;");
                return;
            }
        }
        a = qp1.a;
        b = false;
    }

    public yc2() {
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
        synchronized (yc2.class) {
            if (b) {
                return;
            }
            b = true;
            am3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return cs2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return os2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return os2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return cs2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return cs2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return os2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static zk3 a(ReadableByteChannel readableByteChannel, String str, yg4 yg4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, yg4Var)) == null) {
            if (readableByteChannel == null) {
                zk3 zk3Var = new zk3();
                zk3Var.k(11L);
                zk3Var.i(2300L);
                zk3Var.f("empty source");
                dl3.a().f(zk3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + zk3Var);
                }
                return zk3Var;
            }
            yg4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            yg4Var.n("770", "na_pms_start_check_sign");
            if (tm3.d(readableByteChannel, str, new nn3())) {
                yg4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                yg4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            zk3 zk3Var2 = new zk3();
            zk3Var2.k(11L);
            zk3Var2.i(2300L);
            zk3Var2.f("check zip file sign fail.");
            dl3.a().f(zk3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + zk3Var2);
            }
            return zk3Var2;
        }
        return (zk3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable ei4 ei4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ei4Var)) == null) {
            if (ei4Var == null || TextUtils.isEmpty(ei4Var.a)) {
                return false;
            }
            File file = new File(ei4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ai4 ai4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ai4Var)) == null) {
            if (ai4Var == null) {
                return false;
            }
            int i = ai4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, fi4 fi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, fi4Var) == null) && pMSAppInfo != null && fi4Var != null) {
            pMSAppInfo.copyMainPkgInfo(fi4Var);
            if (fi4Var.h == 1) {
                pMSAppInfo.setOrientation(os2.i().u(fi4Var.g, fi4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, gi4Var) == null) && pMSAppInfo != null && gi4Var != null) {
            pMSAppInfo.copySubPkgInfo(gi4Var);
            if (gi4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static zk3 m(ei4 ei4Var, yg4 yg4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, ei4Var, yg4Var)) == null) {
            if (ei4Var == null) {
                zk3 zk3Var = new zk3();
                zk3Var.k(11L);
                zk3Var.i(2320L);
                zk3Var.f("pkg info is empty");
                dl3.a().f(zk3Var);
                return zk3Var;
            }
            File file = new File(ei4Var.a);
            int i2 = ei4Var.h;
            if (i2 == 1) {
                i = os2.g().a(ei4Var.g, String.valueOf(ei4Var.i));
                if (i == null) {
                    zk3 zk3Var2 = new zk3();
                    zk3Var2.k(11L);
                    zk3Var2.i(2320L);
                    zk3Var2.f("获取解压目录失败");
                    dl3.a().f(zk3Var2);
                    return zk3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = cs2.e.i(ei4Var.g, String.valueOf(ei4Var.i));
            } else {
                zk3 zk3Var3 = new zk3();
                zk3Var3.k(11L);
                zk3Var3.i(2320L);
                zk3Var3.f("pkh category illegal");
                dl3.a().f(zk3Var3);
                return zk3Var3;
            }
            if (!file.exists()) {
                zk3 zk3Var4 = new zk3();
                zk3Var4.k(11L);
                zk3Var4.i(2320L);
                zk3Var4.f("解压失败：包不存在");
                dl3.a().f(zk3Var4);
                return zk3Var4;
            } else if (i.isFile() && !i.delete()) {
                g62.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                zk3 zk3Var5 = new zk3();
                zk3Var5.k(11L);
                zk3Var5.i(2320L);
                zk3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                dl3.a().f(zk3Var5);
                return zk3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                zk3 zk3Var6 = new zk3();
                zk3Var6.k(11L);
                zk3Var6.i(2320L);
                zk3Var6.f("解压失败：解压文件夹创建失败");
                dl3.a().f(zk3Var6);
                return zk3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, yg4Var).b) {
                    return null;
                }
                b n = n(file, i, yg4Var);
                if (n.b) {
                    vf3.a(yg4Var, ei4Var.h, true);
                    return null;
                }
                vf3.a(yg4Var, ei4Var.h, false);
                g62.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                kp4.L(i);
                zk3 zk3Var7 = new zk3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        zk3Var7.k(4L);
                        zk3Var7.i(7L);
                        zk3Var7.f("Unkown bundle type");
                    } else {
                        zk3Var7.k(11L);
                        zk3Var7.i(2330L);
                        zk3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    zk3Var7.k(11L);
                    zk3Var7.i(2320L);
                    zk3Var7.f("unzip failed");
                }
                dl3.a().f(zk3Var7);
                return zk3Var7;
            }
        }
        return (zk3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull yg4 yg4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, yg4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            fs2.c j = fs2.j(file);
            int i = 0;
            if (j.b != -1) {
                yg4Var.n("670", "package_start_decrypt");
                yg4Var.n("770", "na_package_start_decrypt");
                fs2.b d = fs2.d(j.a, file2, j.b);
                yg4Var.n("670", "package_end_decrypt");
                yg4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                yg4Var.n("670", "package_start_unzip");
                yg4Var.n("770", "na_package_start_unzip");
                boolean U = kp4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = kp4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        hg3 hg3Var = new hg3();
                        zk3 zk3Var = new zk3();
                        zk3Var.k(4L);
                        zk3Var.i(52L);
                        hg3Var.p(zk3Var);
                        hg3Var.l("path", file2.getAbsolutePath());
                        hg3Var.l("eMsg", "unzip files not match zip content");
                        hg3Var.l("decryptType", String.valueOf(j.b));
                        hg3Var.l("stack", an3.z(30));
                        zf3.R(hg3Var);
                    }
                }
                yg4Var.n("670", "package_end_unzip");
                yg4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                fs2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ch4.a(yg4Var, bundle, "event_download_package_type");
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
            y93.u(pMSAppInfo.appId, "", gm3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            y93.t("", gm3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            y93.s(pMSAppInfo.appId, gm3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            y93.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
