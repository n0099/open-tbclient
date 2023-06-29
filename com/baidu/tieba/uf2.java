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
import com.baidu.tieba.bv2;
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
/* loaded from: classes8.dex */
public final class uf2 {
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
                gs4.j(new File(filesDir, "aiapps_zip"));
                gs4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            gs4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948209000, "Lcom/baidu/tieba/uf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948209000, "Lcom/baidu/tieba/uf2;");
                return;
            }
        }
        a = ms1.a;
        b = false;
    }

    public uf2() {
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
        synchronized (uf2.class) {
            if (b) {
                return;
            }
            b = true;
            wo3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return yu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return kv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return kv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return yu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return yu2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return kv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static vn3 a(ReadableByteChannel readableByteChannel, String str, uj4 uj4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, uj4Var)) == null) {
            if (readableByteChannel == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(11L);
                vn3Var.i(2300L);
                vn3Var.f("empty source");
                zn3.a().f(vn3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + vn3Var);
                }
                return vn3Var;
            }
            uj4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            uj4Var.n("770", "na_pms_start_check_sign");
            if (pp3.d(readableByteChannel, str, new jq3())) {
                uj4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                uj4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            vn3 vn3Var2 = new vn3();
            vn3Var2.k(11L);
            vn3Var2.i(2300L);
            vn3Var2.f("check zip file sign fail.");
            zn3.a().f(vn3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + vn3Var2);
            }
            return vn3Var2;
        }
        return (vn3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable al4 al4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, al4Var)) == null) {
            if (al4Var == null || TextUtils.isEmpty(al4Var.a)) {
                return false;
            }
            File file = new File(al4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, wk4Var)) == null) {
            if (wk4Var == null) {
                return false;
            }
            int i = wk4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, bl4Var) == null) && pMSAppInfo != null && bl4Var != null) {
            pMSAppInfo.copyMainPkgInfo(bl4Var);
            if (bl4Var.h == 1) {
                pMSAppInfo.setOrientation(kv2.i().u(bl4Var.g, bl4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, cl4Var) == null) && pMSAppInfo != null && cl4Var != null) {
            pMSAppInfo.copySubPkgInfo(cl4Var);
            if (cl4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static vn3 m(al4 al4Var, uj4 uj4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, al4Var, uj4Var)) == null) {
            if (al4Var == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(11L);
                vn3Var.i(2320L);
                vn3Var.f("pkg info is empty");
                zn3.a().f(vn3Var);
                return vn3Var;
            }
            File file = new File(al4Var.a);
            int i2 = al4Var.h;
            if (i2 == 1) {
                i = kv2.g().a(al4Var.g, String.valueOf(al4Var.i));
                if (i == null) {
                    vn3 vn3Var2 = new vn3();
                    vn3Var2.k(11L);
                    vn3Var2.i(2320L);
                    vn3Var2.f("获取解压目录失败");
                    zn3.a().f(vn3Var2);
                    return vn3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = yu2.e.i(al4Var.g, String.valueOf(al4Var.i));
            } else {
                vn3 vn3Var3 = new vn3();
                vn3Var3.k(11L);
                vn3Var3.i(2320L);
                vn3Var3.f("pkh category illegal");
                zn3.a().f(vn3Var3);
                return vn3Var3;
            }
            if (!file.exists()) {
                vn3 vn3Var4 = new vn3();
                vn3Var4.k(11L);
                vn3Var4.i(2320L);
                vn3Var4.f("解压失败：包不存在");
                zn3.a().f(vn3Var4);
                return vn3Var4;
            } else if (i.isFile() && !i.delete()) {
                c92.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                vn3 vn3Var5 = new vn3();
                vn3Var5.k(11L);
                vn3Var5.i(2320L);
                vn3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                zn3.a().f(vn3Var5);
                return vn3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                vn3 vn3Var6 = new vn3();
                vn3Var6.k(11L);
                vn3Var6.i(2320L);
                vn3Var6.f("解压失败：解压文件夹创建失败");
                zn3.a().f(vn3Var6);
                return vn3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, uj4Var).b) {
                    return null;
                }
                b n = n(file, i, uj4Var);
                if (n.b) {
                    ri3.a(uj4Var, al4Var.h, true);
                    return null;
                }
                ri3.a(uj4Var, al4Var.h, false);
                c92.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                gs4.L(i);
                vn3 vn3Var7 = new vn3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        vn3Var7.k(4L);
                        vn3Var7.i(7L);
                        vn3Var7.f("Unkown bundle type");
                    } else {
                        vn3Var7.k(11L);
                        vn3Var7.i(2330L);
                        vn3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    vn3Var7.k(11L);
                    vn3Var7.i(2320L);
                    vn3Var7.f("unzip failed");
                }
                zn3.a().f(vn3Var7);
                return vn3Var7;
            }
        }
        return (vn3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull uj4 uj4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, uj4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            bv2.c j = bv2.j(file);
            int i = 0;
            if (j.b != -1) {
                uj4Var.n("670", "package_start_decrypt");
                uj4Var.n("770", "na_package_start_decrypt");
                bv2.b d = bv2.d(j.a, file2, j.b);
                uj4Var.n("670", "package_end_decrypt");
                uj4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                uj4Var.n("670", "package_start_unzip");
                uj4Var.n("770", "na_package_start_unzip");
                boolean U = gs4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = gs4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        dj3 dj3Var = new dj3();
                        vn3 vn3Var = new vn3();
                        vn3Var.k(4L);
                        vn3Var.i(52L);
                        dj3Var.p(vn3Var);
                        dj3Var.l("path", file2.getAbsolutePath());
                        dj3Var.l("eMsg", "unzip files not match zip content");
                        dj3Var.l("decryptType", String.valueOf(j.b));
                        dj3Var.l("stack", wp3.z(30));
                        vi3.R(dj3Var);
                    }
                }
                uj4Var.n("670", "package_end_unzip");
                uj4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                bv2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            yj4.a(uj4Var, bundle, "event_download_package_type");
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
            uc3.u(pMSAppInfo.appId, "", cp3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            uc3.t("", cp3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            uc3.s(pMSAppInfo.appId, cp3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            uc3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
