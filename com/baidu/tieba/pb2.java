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
import com.baidu.tieba.tq2;
import com.baidu.tieba.wq2;
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
/* loaded from: classes5.dex */
public final class pb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
                bo4.j(new File(filesDir, "aiapps_zip"));
                bo4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            bo4.L(file2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948056201, "Lcom/baidu/tieba/pb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948056201, "Lcom/baidu/tieba/pb2;");
                return;
            }
        }
        a = ho1.a;
        b = false;
    }

    public pb2() {
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
        synchronized (pb2.class) {
            if (b) {
                return;
            }
            b = true;
            rk3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return tq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return fr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return fr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return tq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return tq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return fr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static qj3 a(ReadableByteChannel readableByteChannel, String str, pf4 pf4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, pf4Var)) == null) {
            if (readableByteChannel == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(11L);
                qj3Var.i(2300L);
                qj3Var.f("empty source");
                uj3.a().f(qj3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + qj3Var);
                }
                return qj3Var;
            }
            pf4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            pf4Var.n("770", "na_pms_start_check_sign");
            if (kl3.d(readableByteChannel, str, new em3())) {
                pf4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                pf4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            qj3 qj3Var2 = new qj3();
            qj3Var2.k(11L);
            qj3Var2.i(2300L);
            qj3Var2.f("check zip file sign fail.");
            uj3.a().f(qj3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + qj3Var2);
            }
            return qj3Var2;
        }
        return (qj3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable vg4 vg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vg4Var)) == null) {
            if (vg4Var == null || TextUtils.isEmpty(vg4Var.a)) {
                return false;
            }
            File file = new File(vg4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(rg4 rg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, rg4Var)) == null) {
            if (rg4Var == null) {
                return false;
            }
            int i = rg4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, wg4Var) == null) && pMSAppInfo != null && wg4Var != null) {
            pMSAppInfo.copyMainPkgInfo(wg4Var);
            if (wg4Var.h == 1) {
                pMSAppInfo.setOrientation(fr2.i().u(wg4Var.g, wg4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, xg4Var) == null) && pMSAppInfo != null && xg4Var != null) {
            pMSAppInfo.copySubPkgInfo(xg4Var);
            if (xg4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static qj3 m(vg4 vg4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, vg4Var, pf4Var)) == null) {
            if (vg4Var == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(11L);
                qj3Var.i(2320L);
                qj3Var.f("pkg info is empty");
                uj3.a().f(qj3Var);
                return qj3Var;
            }
            File file = new File(vg4Var.a);
            int i2 = vg4Var.h;
            if (i2 == 1) {
                i = fr2.g().a(vg4Var.g, String.valueOf(vg4Var.i));
                if (i == null) {
                    qj3 qj3Var2 = new qj3();
                    qj3Var2.k(11L);
                    qj3Var2.i(2320L);
                    qj3Var2.f("获取解压目录失败");
                    uj3.a().f(qj3Var2);
                    return qj3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = tq2.e.i(vg4Var.g, String.valueOf(vg4Var.i));
            } else {
                qj3 qj3Var3 = new qj3();
                qj3Var3.k(11L);
                qj3Var3.i(2320L);
                qj3Var3.f("pkh category illegal");
                uj3.a().f(qj3Var3);
                return qj3Var3;
            }
            if (!file.exists()) {
                qj3 qj3Var4 = new qj3();
                qj3Var4.k(11L);
                qj3Var4.i(2320L);
                qj3Var4.f("解压失败：包不存在");
                uj3.a().f(qj3Var4);
                return qj3Var4;
            } else if (i.isFile() && !i.delete()) {
                x42.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                qj3 qj3Var5 = new qj3();
                qj3Var5.k(11L);
                qj3Var5.i(2320L);
                qj3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                uj3.a().f(qj3Var5);
                return qj3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                qj3 qj3Var6 = new qj3();
                qj3Var6.k(11L);
                qj3Var6.i(2320L);
                qj3Var6.f("解压失败：解压文件夹创建失败");
                uj3.a().f(qj3Var6);
                return qj3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, pf4Var).b) {
                    return null;
                }
                b n = n(file, i, pf4Var);
                if (n.b) {
                    me3.a(pf4Var, vg4Var.h, true);
                    return null;
                }
                me3.a(pf4Var, vg4Var.h, false);
                x42.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                bo4.L(i);
                qj3 qj3Var7 = new qj3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        qj3Var7.k(4L);
                        qj3Var7.i(7L);
                        qj3Var7.f("Unkown bundle type");
                    } else {
                        qj3Var7.k(11L);
                        qj3Var7.i(2330L);
                        qj3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    qj3Var7.k(11L);
                    qj3Var7.i(2320L);
                    qj3Var7.f("unzip failed");
                }
                uj3.a().f(qj3Var7);
                return qj3Var7;
            }
        }
        return (qj3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull pf4 pf4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, pf4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            wq2.c j = wq2.j(file);
            int i = 0;
            if (j.b != -1) {
                pf4Var.n("670", "package_start_decrypt");
                pf4Var.n("770", "na_package_start_decrypt");
                wq2.b d = wq2.d(j.a, file2, j.b);
                pf4Var.n("670", "package_end_decrypt");
                pf4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                pf4Var.n("670", "package_start_unzip");
                pf4Var.n("770", "na_package_start_unzip");
                boolean U = bo4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = bo4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ye3 ye3Var = new ye3();
                        qj3 qj3Var = new qj3();
                        qj3Var.k(4L);
                        qj3Var.i(52L);
                        ye3Var.p(qj3Var);
                        ye3Var.l("path", file2.getAbsolutePath());
                        ye3Var.l("eMsg", "unzip files not match zip content");
                        ye3Var.l("decryptType", String.valueOf(j.b));
                        ye3Var.l("stack", rl3.z(30));
                        qe3.R(ye3Var);
                    }
                }
                pf4Var.n("670", "package_end_unzip");
                pf4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                wq2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            tf4.a(pf4Var, bundle, "event_download_package_type");
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
            p83.u(pMSAppInfo.appId, "", xk3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            p83.t("", xk3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            p83.s(pMSAppInfo.appId, xk3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            p83.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
