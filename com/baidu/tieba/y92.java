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
import com.baidu.tieba.cp2;
import com.baidu.tieba.fp2;
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
public final class y92 {
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
                jm4.j(new File(filesDir, "aiapps_zip"));
                jm4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            jm4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284919, "Lcom/baidu/tieba/y92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284919, "Lcom/baidu/tieba/y92;");
                return;
            }
        }
        a = rm1.a;
        b = false;
    }

    public y92() {
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
        synchronized (y92.class) {
            if (b) {
                return;
            }
            b = true;
            aj3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return cp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return op2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return op2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return cp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return cp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return op2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static zh3 a(ReadableByteChannel readableByteChannel, String str, yd4 yd4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, yd4Var)) == null) {
            if (readableByteChannel == null) {
                zh3 zh3Var = new zh3();
                zh3Var.k(11L);
                zh3Var.i(2300L);
                zh3Var.f("empty source");
                di3.a().f(zh3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + zh3Var);
                }
                return zh3Var;
            }
            yd4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            yd4Var.n("770", "na_pms_start_check_sign");
            if (tj3.d(readableByteChannel, str, new nk3())) {
                yd4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                yd4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            zh3 zh3Var2 = new zh3();
            zh3Var2.k(11L);
            zh3Var2.i(2300L);
            zh3Var2.f("check zip file sign fail.");
            di3.a().f(zh3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + zh3Var2);
            }
            return zh3Var2;
        }
        return (zh3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable ef4 ef4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ef4Var)) == null) {
            if (ef4Var == null || TextUtils.isEmpty(ef4Var.a)) {
                return false;
            }
            File file = new File(ef4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(af4 af4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, af4Var)) == null) {
            if (af4Var == null) {
                return false;
            }
            int i = af4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, ff4 ff4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, ff4Var) == null) && pMSAppInfo != null && ff4Var != null) {
            pMSAppInfo.copyMainPkgInfo(ff4Var);
            if (ff4Var.h == 1) {
                pMSAppInfo.setOrientation(op2.i().u(ff4Var.g, ff4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, gf4Var) == null) && pMSAppInfo != null && gf4Var != null) {
            pMSAppInfo.copySubPkgInfo(gf4Var);
            if (gf4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static zh3 m(ef4 ef4Var, yd4 yd4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, ef4Var, yd4Var)) == null) {
            if (ef4Var == null) {
                zh3 zh3Var = new zh3();
                zh3Var.k(11L);
                zh3Var.i(2320L);
                zh3Var.f("pkg info is empty");
                di3.a().f(zh3Var);
                return zh3Var;
            }
            File file = new File(ef4Var.a);
            int i2 = ef4Var.h;
            if (i2 == 1) {
                i = op2.g().a(ef4Var.g, String.valueOf(ef4Var.i));
                if (i == null) {
                    zh3 zh3Var2 = new zh3();
                    zh3Var2.k(11L);
                    zh3Var2.i(2320L);
                    zh3Var2.f("获取解压目录失败");
                    di3.a().f(zh3Var2);
                    return zh3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = cp2.e.i(ef4Var.g, String.valueOf(ef4Var.i));
            } else {
                zh3 zh3Var3 = new zh3();
                zh3Var3.k(11L);
                zh3Var3.i(2320L);
                zh3Var3.f("pkh category illegal");
                di3.a().f(zh3Var3);
                return zh3Var3;
            }
            if (!file.exists()) {
                zh3 zh3Var4 = new zh3();
                zh3Var4.k(11L);
                zh3Var4.i(2320L);
                zh3Var4.f("解压失败：包不存在");
                di3.a().f(zh3Var4);
                return zh3Var4;
            } else if (i.isFile() && !i.delete()) {
                g32.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                zh3 zh3Var5 = new zh3();
                zh3Var5.k(11L);
                zh3Var5.i(2320L);
                zh3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                di3.a().f(zh3Var5);
                return zh3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                zh3 zh3Var6 = new zh3();
                zh3Var6.k(11L);
                zh3Var6.i(2320L);
                zh3Var6.f("解压失败：解压文件夹创建失败");
                di3.a().f(zh3Var6);
                return zh3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, yd4Var).b) {
                    return null;
                }
                b n = n(file, i, yd4Var);
                if (n.b) {
                    vc3.a(yd4Var, ef4Var.h, true);
                    return null;
                }
                vc3.a(yd4Var, ef4Var.h, false);
                g32.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                jm4.L(i);
                zh3 zh3Var7 = new zh3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        zh3Var7.k(4L);
                        zh3Var7.i(7L);
                        zh3Var7.f("Unkown bundle type");
                    } else {
                        zh3Var7.k(11L);
                        zh3Var7.i(2330L);
                        zh3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    zh3Var7.k(11L);
                    zh3Var7.i(2320L);
                    zh3Var7.f("unzip failed");
                }
                di3.a().f(zh3Var7);
                return zh3Var7;
            }
        }
        return (zh3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull yd4 yd4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, yd4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            fp2.c j = fp2.j(file);
            int i = 0;
            if (j.b != -1) {
                yd4Var.n("670", "package_start_decrypt");
                yd4Var.n("770", "na_package_start_decrypt");
                fp2.b d = fp2.d(j.a, file2, j.b);
                yd4Var.n("670", "package_end_decrypt");
                yd4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                yd4Var.n("670", "package_start_unzip");
                yd4Var.n("770", "na_package_start_unzip");
                boolean U = jm4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = jm4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        hd3 hd3Var = new hd3();
                        zh3 zh3Var = new zh3();
                        zh3Var.k(4L);
                        zh3Var.i(52L);
                        hd3Var.p(zh3Var);
                        hd3Var.l("path", file2.getAbsolutePath());
                        hd3Var.l("eMsg", "unzip files not match zip content");
                        hd3Var.l("decryptType", String.valueOf(j.b));
                        hd3Var.l("stack", ak3.z(30));
                        zc3.R(hd3Var);
                    }
                }
                yd4Var.n("670", "package_end_unzip");
                yd4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                fp2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ce4.a(yd4Var, bundle, "event_download_package_type");
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
            y63.u(pMSAppInfo.appId, "", gj3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            y63.t("", gj3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            y63.s(pMSAppInfo.appId, gj3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            y63.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
