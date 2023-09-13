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
import com.baidu.tieba.du2;
import com.baidu.tieba.gu2;
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
/* loaded from: classes9.dex */
public final class ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
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
                lr4.j(new File(filesDir, "aiapps_zip"));
                lr4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            lr4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948356994, "Lcom/baidu/tieba/ze2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948356994, "Lcom/baidu/tieba/ze2;");
                return;
            }
        }
        a = rr1.a;
        b = false;
    }

    public ze2() {
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
        synchronized (ze2.class) {
            if (b) {
                return;
            }
            b = true;
            bo3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return du2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return pu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return pu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return du2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return du2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return pu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static an3 a(ReadableByteChannel readableByteChannel, String str, zi4 zi4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, zi4Var)) == null) {
            if (readableByteChannel == null) {
                an3 an3Var = new an3();
                an3Var.k(11L);
                an3Var.i(2300L);
                an3Var.f("empty source");
                en3.a().f(an3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + an3Var);
                }
                return an3Var;
            }
            zi4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            zi4Var.n("770", "na_pms_start_check_sign");
            if (uo3.d(readableByteChannel, str, new op3())) {
                zi4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                zi4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            an3 an3Var2 = new an3();
            an3Var2.k(11L);
            an3Var2.i(2300L);
            an3Var2.f("check zip file sign fail.");
            en3.a().f(an3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + an3Var2);
            }
            return an3Var2;
        }
        return (an3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable fk4 fk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fk4Var)) == null) {
            if (fk4Var == null || TextUtils.isEmpty(fk4Var.a)) {
                return false;
            }
            File file = new File(fk4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(bk4 bk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bk4Var)) == null) {
            if (bk4Var == null) {
                return false;
            }
            int i = bk4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, gk4Var) == null) && pMSAppInfo != null && gk4Var != null) {
            pMSAppInfo.copyMainPkgInfo(gk4Var);
            if (gk4Var.h == 1) {
                pMSAppInfo.setOrientation(pu2.i().u(gk4Var.g, gk4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, hk4Var) == null) && pMSAppInfo != null && hk4Var != null) {
            pMSAppInfo.copySubPkgInfo(hk4Var);
            if (hk4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static an3 m(fk4 fk4Var, zi4 zi4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, fk4Var, zi4Var)) == null) {
            if (fk4Var == null) {
                an3 an3Var = new an3();
                an3Var.k(11L);
                an3Var.i(2320L);
                an3Var.f("pkg info is empty");
                en3.a().f(an3Var);
                return an3Var;
            }
            File file = new File(fk4Var.a);
            int i2 = fk4Var.h;
            if (i2 == 1) {
                i = pu2.g().a(fk4Var.g, String.valueOf(fk4Var.i));
                if (i == null) {
                    an3 an3Var2 = new an3();
                    an3Var2.k(11L);
                    an3Var2.i(2320L);
                    an3Var2.f("获取解压目录失败");
                    en3.a().f(an3Var2);
                    return an3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = du2.e.i(fk4Var.g, String.valueOf(fk4Var.i));
            } else {
                an3 an3Var3 = new an3();
                an3Var3.k(11L);
                an3Var3.i(2320L);
                an3Var3.f("pkh category illegal");
                en3.a().f(an3Var3);
                return an3Var3;
            }
            if (!file.exists()) {
                an3 an3Var4 = new an3();
                an3Var4.k(11L);
                an3Var4.i(2320L);
                an3Var4.f("解压失败：包不存在");
                en3.a().f(an3Var4);
                return an3Var4;
            } else if (i.isFile() && !i.delete()) {
                h82.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                an3 an3Var5 = new an3();
                an3Var5.k(11L);
                an3Var5.i(2320L);
                an3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                en3.a().f(an3Var5);
                return an3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                an3 an3Var6 = new an3();
                an3Var6.k(11L);
                an3Var6.i(2320L);
                an3Var6.f("解压失败：解压文件夹创建失败");
                en3.a().f(an3Var6);
                return an3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, zi4Var).b) {
                    return null;
                }
                b n = n(file, i, zi4Var);
                if (n.b) {
                    wh3.a(zi4Var, fk4Var.h, true);
                    return null;
                }
                wh3.a(zi4Var, fk4Var.h, false);
                h82.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                lr4.L(i);
                an3 an3Var7 = new an3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        an3Var7.k(4L);
                        an3Var7.i(7L);
                        an3Var7.f("Unkown bundle type");
                    } else {
                        an3Var7.k(11L);
                        an3Var7.i(2330L);
                        an3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    an3Var7.k(11L);
                    an3Var7.i(2320L);
                    an3Var7.f("unzip failed");
                }
                en3.a().f(an3Var7);
                return an3Var7;
            }
        }
        return (an3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull zi4 zi4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, zi4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            gu2.c j = gu2.j(file);
            int i = 0;
            if (j.b != -1) {
                zi4Var.n("670", "package_start_decrypt");
                zi4Var.n("770", "na_package_start_decrypt");
                gu2.b d = gu2.d(j.a, file2, j.b);
                zi4Var.n("670", "package_end_decrypt");
                zi4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                zi4Var.n("670", "package_start_unzip");
                zi4Var.n("770", "na_package_start_unzip");
                boolean U = lr4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = lr4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ii3 ii3Var = new ii3();
                        an3 an3Var = new an3();
                        an3Var.k(4L);
                        an3Var.i(52L);
                        ii3Var.p(an3Var);
                        ii3Var.l("path", file2.getAbsolutePath());
                        ii3Var.l("eMsg", "unzip files not match zip content");
                        ii3Var.l("decryptType", String.valueOf(j.b));
                        ii3Var.l("stack", bp3.z(30));
                        ai3.R(ii3Var);
                    }
                }
                zi4Var.n("670", "package_end_unzip");
                zi4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                gu2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            dj4.a(zi4Var, bundle, "event_download_package_type");
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
            zb3.u(pMSAppInfo.appId, "", ho3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            zb3.t("", ho3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            zb3.s(pMSAppInfo.appId, ho3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            zb3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
