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
import com.baidu.tieba.an2;
import com.baidu.tieba.dn2;
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
public final class w72 {
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
                ik4.j(new File(filesDir, "aiapps_zip"));
                ik4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            ik4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223415, "Lcom/baidu/tieba/w72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223415, "Lcom/baidu/tieba/w72;");
                return;
            }
        }
        a = ok1.a;
        b = false;
    }

    public w72() {
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
        synchronized (w72.class) {
            if (b) {
                return;
            }
            b = true;
            yg3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return an2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return mn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return mn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return an2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return an2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return mn2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static xf3 a(ReadableByteChannel readableByteChannel, String str, wb4 wb4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, wb4Var)) == null) {
            if (readableByteChannel == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(11L);
                xf3Var.i(2300L);
                xf3Var.f("empty source");
                bg3.a().f(xf3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + xf3Var);
                }
                return xf3Var;
            }
            wb4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            wb4Var.n("770", "na_pms_start_check_sign");
            if (rh3.d(readableByteChannel, str, new li3())) {
                wb4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                wb4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            xf3 xf3Var2 = new xf3();
            xf3Var2.k(11L);
            xf3Var2.i(2300L);
            xf3Var2.f("check zip file sign fail.");
            bg3.a().f(xf3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + xf3Var2);
            }
            return xf3Var2;
        }
        return (xf3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable cd4 cd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cd4Var)) == null) {
            if (cd4Var == null || TextUtils.isEmpty(cd4Var.a)) {
                return false;
            }
            File file = new File(cd4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(yc4 yc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, yc4Var)) == null) {
            if (yc4Var == null) {
                return false;
            }
            int i = yc4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, dd4Var) == null) && pMSAppInfo != null && dd4Var != null) {
            pMSAppInfo.copyMainPkgInfo(dd4Var);
            if (dd4Var.h == 1) {
                pMSAppInfo.setOrientation(mn2.i().u(dd4Var.g, dd4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, ed4Var) == null) && pMSAppInfo != null && ed4Var != null) {
            pMSAppInfo.copySubPkgInfo(ed4Var);
            if (ed4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static xf3 m(cd4 cd4Var, wb4 wb4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, cd4Var, wb4Var)) == null) {
            if (cd4Var == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(11L);
                xf3Var.i(2320L);
                xf3Var.f("pkg info is empty");
                bg3.a().f(xf3Var);
                return xf3Var;
            }
            File file = new File(cd4Var.a);
            int i2 = cd4Var.h;
            if (i2 == 1) {
                i = mn2.g().a(cd4Var.g, String.valueOf(cd4Var.i));
                if (i == null) {
                    xf3 xf3Var2 = new xf3();
                    xf3Var2.k(11L);
                    xf3Var2.i(2320L);
                    xf3Var2.f("获取解压目录失败");
                    bg3.a().f(xf3Var2);
                    return xf3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = an2.e.i(cd4Var.g, String.valueOf(cd4Var.i));
            } else {
                xf3 xf3Var3 = new xf3();
                xf3Var3.k(11L);
                xf3Var3.i(2320L);
                xf3Var3.f("pkh category illegal");
                bg3.a().f(xf3Var3);
                return xf3Var3;
            }
            if (!file.exists()) {
                xf3 xf3Var4 = new xf3();
                xf3Var4.k(11L);
                xf3Var4.i(2320L);
                xf3Var4.f("解压失败：包不存在");
                bg3.a().f(xf3Var4);
                return xf3Var4;
            } else if (i.isFile() && !i.delete()) {
                e12.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                xf3 xf3Var5 = new xf3();
                xf3Var5.k(11L);
                xf3Var5.i(2320L);
                xf3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                bg3.a().f(xf3Var5);
                return xf3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                xf3 xf3Var6 = new xf3();
                xf3Var6.k(11L);
                xf3Var6.i(2320L);
                xf3Var6.f("解压失败：解压文件夹创建失败");
                bg3.a().f(xf3Var6);
                return xf3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, wb4Var).b) {
                    return null;
                }
                b n = n(file, i, wb4Var);
                if (n.b) {
                    ta3.a(wb4Var, cd4Var.h, true);
                    return null;
                }
                ta3.a(wb4Var, cd4Var.h, false);
                e12.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                ik4.L(i);
                xf3 xf3Var7 = new xf3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        xf3Var7.k(4L);
                        xf3Var7.i(7L);
                        xf3Var7.f("Unkown bundle type");
                    } else {
                        xf3Var7.k(11L);
                        xf3Var7.i(2330L);
                        xf3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    xf3Var7.k(11L);
                    xf3Var7.i(2320L);
                    xf3Var7.f("unzip failed");
                }
                bg3.a().f(xf3Var7);
                return xf3Var7;
            }
        }
        return (xf3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull wb4 wb4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, wb4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            dn2.c j = dn2.j(file);
            int i = 0;
            if (j.b != -1) {
                wb4Var.n("670", "package_start_decrypt");
                wb4Var.n("770", "na_package_start_decrypt");
                dn2.b d = dn2.d(j.a, file2, j.b);
                wb4Var.n("670", "package_end_decrypt");
                wb4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                wb4Var.n("670", "package_start_unzip");
                wb4Var.n("770", "na_package_start_unzip");
                boolean U = ik4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = ik4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        fb3 fb3Var = new fb3();
                        xf3 xf3Var = new xf3();
                        xf3Var.k(4L);
                        xf3Var.i(52L);
                        fb3Var.p(xf3Var);
                        fb3Var.l("path", file2.getAbsolutePath());
                        fb3Var.l("eMsg", "unzip files not match zip content");
                        fb3Var.l("decryptType", String.valueOf(j.b));
                        fb3Var.l("stack", yh3.z(30));
                        xa3.R(fb3Var);
                    }
                }
                wb4Var.n("670", "package_end_unzip");
                wb4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                dn2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ac4.a(wb4Var, bundle, "event_download_package_type");
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
            w43.u(pMSAppInfo.appId, "", eh3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            w43.t("", eh3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            w43.s(pMSAppInfo.appId, eh3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            w43.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
