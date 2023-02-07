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
import com.baidu.tieba.sr2;
import com.baidu.tieba.vr2;
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
public final class oc2 {
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
                ap4.j(new File(filesDir, "aiapps_zip"));
                ap4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            ap4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948027371, "Lcom/baidu/tieba/oc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948027371, "Lcom/baidu/tieba/oc2;");
                return;
            }
        }
        a = gp1.a;
        b = false;
    }

    public oc2() {
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
        synchronized (oc2.class) {
            if (b) {
                return;
            }
            b = true;
            ql3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return sr2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return es2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return es2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return sr2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return sr2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return es2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static pk3 a(ReadableByteChannel readableByteChannel, String str, og4 og4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, og4Var)) == null) {
            if (readableByteChannel == null) {
                pk3 pk3Var = new pk3();
                pk3Var.k(11L);
                pk3Var.i(2300L);
                pk3Var.f("empty source");
                tk3.a().f(pk3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + pk3Var);
                }
                return pk3Var;
            }
            og4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            og4Var.n("770", "na_pms_start_check_sign");
            if (jm3.d(readableByteChannel, str, new dn3())) {
                og4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                og4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            pk3 pk3Var2 = new pk3();
            pk3Var2.k(11L);
            pk3Var2.i(2300L);
            pk3Var2.f("check zip file sign fail.");
            tk3.a().f(pk3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + pk3Var2);
            }
            return pk3Var2;
        }
        return (pk3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable uh4 uh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uh4Var)) == null) {
            if (uh4Var == null || TextUtils.isEmpty(uh4Var.a)) {
                return false;
            }
            File file = new File(uh4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(qh4 qh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, qh4Var)) == null) {
            if (qh4Var == null) {
                return false;
            }
            int i = qh4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, vh4Var) == null) && pMSAppInfo != null && vh4Var != null) {
            pMSAppInfo.copyMainPkgInfo(vh4Var);
            if (vh4Var.h == 1) {
                pMSAppInfo.setOrientation(es2.i().u(vh4Var.g, vh4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, wh4Var) == null) && pMSAppInfo != null && wh4Var != null) {
            pMSAppInfo.copySubPkgInfo(wh4Var);
            if (wh4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static pk3 m(uh4 uh4Var, og4 og4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, uh4Var, og4Var)) == null) {
            if (uh4Var == null) {
                pk3 pk3Var = new pk3();
                pk3Var.k(11L);
                pk3Var.i(2320L);
                pk3Var.f("pkg info is empty");
                tk3.a().f(pk3Var);
                return pk3Var;
            }
            File file = new File(uh4Var.a);
            int i2 = uh4Var.h;
            if (i2 == 1) {
                i = es2.g().a(uh4Var.g, String.valueOf(uh4Var.i));
                if (i == null) {
                    pk3 pk3Var2 = new pk3();
                    pk3Var2.k(11L);
                    pk3Var2.i(2320L);
                    pk3Var2.f("获取解压目录失败");
                    tk3.a().f(pk3Var2);
                    return pk3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = sr2.e.i(uh4Var.g, String.valueOf(uh4Var.i));
            } else {
                pk3 pk3Var3 = new pk3();
                pk3Var3.k(11L);
                pk3Var3.i(2320L);
                pk3Var3.f("pkh category illegal");
                tk3.a().f(pk3Var3);
                return pk3Var3;
            }
            if (!file.exists()) {
                pk3 pk3Var4 = new pk3();
                pk3Var4.k(11L);
                pk3Var4.i(2320L);
                pk3Var4.f("解压失败：包不存在");
                tk3.a().f(pk3Var4);
                return pk3Var4;
            } else if (i.isFile() && !i.delete()) {
                w52.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                pk3 pk3Var5 = new pk3();
                pk3Var5.k(11L);
                pk3Var5.i(2320L);
                pk3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                tk3.a().f(pk3Var5);
                return pk3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                pk3 pk3Var6 = new pk3();
                pk3Var6.k(11L);
                pk3Var6.i(2320L);
                pk3Var6.f("解压失败：解压文件夹创建失败");
                tk3.a().f(pk3Var6);
                return pk3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, og4Var).b) {
                    return null;
                }
                b n = n(file, i, og4Var);
                if (n.b) {
                    lf3.a(og4Var, uh4Var.h, true);
                    return null;
                }
                lf3.a(og4Var, uh4Var.h, false);
                w52.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                ap4.L(i);
                pk3 pk3Var7 = new pk3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        pk3Var7.k(4L);
                        pk3Var7.i(7L);
                        pk3Var7.f("Unkown bundle type");
                    } else {
                        pk3Var7.k(11L);
                        pk3Var7.i(2330L);
                        pk3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    pk3Var7.k(11L);
                    pk3Var7.i(2320L);
                    pk3Var7.f("unzip failed");
                }
                tk3.a().f(pk3Var7);
                return pk3Var7;
            }
        }
        return (pk3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull og4 og4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, og4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            vr2.c j = vr2.j(file);
            int i = 0;
            if (j.b != -1) {
                og4Var.n("670", "package_start_decrypt");
                og4Var.n("770", "na_package_start_decrypt");
                vr2.b d = vr2.d(j.a, file2, j.b);
                og4Var.n("670", "package_end_decrypt");
                og4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                og4Var.n("670", "package_start_unzip");
                og4Var.n("770", "na_package_start_unzip");
                boolean U = ap4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = ap4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        xf3 xf3Var = new xf3();
                        pk3 pk3Var = new pk3();
                        pk3Var.k(4L);
                        pk3Var.i(52L);
                        xf3Var.p(pk3Var);
                        xf3Var.l("path", file2.getAbsolutePath());
                        xf3Var.l("eMsg", "unzip files not match zip content");
                        xf3Var.l("decryptType", String.valueOf(j.b));
                        xf3Var.l("stack", qm3.z(30));
                        pf3.R(xf3Var);
                    }
                }
                og4Var.n("670", "package_end_unzip");
                og4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                vr2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            sg4.a(og4Var, bundle, "event_download_package_type");
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
            o93.u(pMSAppInfo.appId, "", wl3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            o93.t("", wl3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            o93.s(pMSAppInfo.appId, wl3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            o93.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
