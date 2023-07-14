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
import com.baidu.tieba.ru2;
import com.baidu.tieba.uu2;
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
public final class nf2 {
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
                zr4.j(new File(filesDir, "aiapps_zip"));
                zr4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            zr4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948000463, "Lcom/baidu/tieba/nf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948000463, "Lcom/baidu/tieba/nf2;");
                return;
            }
        }
        a = fs1.a;
        b = false;
    }

    public nf2() {
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
        synchronized (nf2.class) {
            if (b) {
                return;
            }
            b = true;
            po3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return ru2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return dv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return dv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return ru2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return ru2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return dv2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static on3 a(ReadableByteChannel readableByteChannel, String str, nj4 nj4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, nj4Var)) == null) {
            if (readableByteChannel == null) {
                on3 on3Var = new on3();
                on3Var.k(11L);
                on3Var.i(2300L);
                on3Var.f("empty source");
                sn3.a().f(on3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + on3Var);
                }
                return on3Var;
            }
            nj4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            nj4Var.n("770", "na_pms_start_check_sign");
            if (ip3.d(readableByteChannel, str, new cq3())) {
                nj4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                nj4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            on3 on3Var2 = new on3();
            on3Var2.k(11L);
            on3Var2.i(2300L);
            on3Var2.f("check zip file sign fail.");
            sn3.a().f(on3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + on3Var2);
            }
            return on3Var2;
        }
        return (on3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable tk4 tk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tk4Var)) == null) {
            if (tk4Var == null || TextUtils.isEmpty(tk4Var.a)) {
                return false;
            }
            File file = new File(tk4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(pk4 pk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, pk4Var)) == null) {
            if (pk4Var == null) {
                return false;
            }
            int i = pk4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, uk4 uk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, uk4Var) == null) && pMSAppInfo != null && uk4Var != null) {
            pMSAppInfo.copyMainPkgInfo(uk4Var);
            if (uk4Var.h == 1) {
                pMSAppInfo.setOrientation(dv2.i().u(uk4Var.g, uk4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, vk4Var) == null) && pMSAppInfo != null && vk4Var != null) {
            pMSAppInfo.copySubPkgInfo(vk4Var);
            if (vk4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static on3 m(tk4 tk4Var, nj4 nj4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, tk4Var, nj4Var)) == null) {
            if (tk4Var == null) {
                on3 on3Var = new on3();
                on3Var.k(11L);
                on3Var.i(2320L);
                on3Var.f("pkg info is empty");
                sn3.a().f(on3Var);
                return on3Var;
            }
            File file = new File(tk4Var.a);
            int i2 = tk4Var.h;
            if (i2 == 1) {
                i = dv2.g().a(tk4Var.g, String.valueOf(tk4Var.i));
                if (i == null) {
                    on3 on3Var2 = new on3();
                    on3Var2.k(11L);
                    on3Var2.i(2320L);
                    on3Var2.f("获取解压目录失败");
                    sn3.a().f(on3Var2);
                    return on3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = ru2.e.i(tk4Var.g, String.valueOf(tk4Var.i));
            } else {
                on3 on3Var3 = new on3();
                on3Var3.k(11L);
                on3Var3.i(2320L);
                on3Var3.f("pkh category illegal");
                sn3.a().f(on3Var3);
                return on3Var3;
            }
            if (!file.exists()) {
                on3 on3Var4 = new on3();
                on3Var4.k(11L);
                on3Var4.i(2320L);
                on3Var4.f("解压失败：包不存在");
                sn3.a().f(on3Var4);
                return on3Var4;
            } else if (i.isFile() && !i.delete()) {
                v82.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                on3 on3Var5 = new on3();
                on3Var5.k(11L);
                on3Var5.i(2320L);
                on3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                sn3.a().f(on3Var5);
                return on3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                on3 on3Var6 = new on3();
                on3Var6.k(11L);
                on3Var6.i(2320L);
                on3Var6.f("解压失败：解压文件夹创建失败");
                sn3.a().f(on3Var6);
                return on3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, nj4Var).b) {
                    return null;
                }
                b n = n(file, i, nj4Var);
                if (n.b) {
                    ki3.a(nj4Var, tk4Var.h, true);
                    return null;
                }
                ki3.a(nj4Var, tk4Var.h, false);
                v82.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                zr4.L(i);
                on3 on3Var7 = new on3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        on3Var7.k(4L);
                        on3Var7.i(7L);
                        on3Var7.f("Unkown bundle type");
                    } else {
                        on3Var7.k(11L);
                        on3Var7.i(2330L);
                        on3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    on3Var7.k(11L);
                    on3Var7.i(2320L);
                    on3Var7.f("unzip failed");
                }
                sn3.a().f(on3Var7);
                return on3Var7;
            }
        }
        return (on3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull nj4 nj4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, nj4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            uu2.c j = uu2.j(file);
            int i = 0;
            if (j.b != -1) {
                nj4Var.n("670", "package_start_decrypt");
                nj4Var.n("770", "na_package_start_decrypt");
                uu2.b d = uu2.d(j.a, file2, j.b);
                nj4Var.n("670", "package_end_decrypt");
                nj4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                nj4Var.n("670", "package_start_unzip");
                nj4Var.n("770", "na_package_start_unzip");
                boolean U = zr4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = zr4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        wi3 wi3Var = new wi3();
                        on3 on3Var = new on3();
                        on3Var.k(4L);
                        on3Var.i(52L);
                        wi3Var.p(on3Var);
                        wi3Var.l("path", file2.getAbsolutePath());
                        wi3Var.l("eMsg", "unzip files not match zip content");
                        wi3Var.l("decryptType", String.valueOf(j.b));
                        wi3Var.l("stack", pp3.z(30));
                        oi3.R(wi3Var);
                    }
                }
                nj4Var.n("670", "package_end_unzip");
                nj4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                uu2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            rj4.a(nj4Var, bundle, "event_download_package_type");
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
            nc3.u(pMSAppInfo.appId, "", vo3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            nc3.t("", vo3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            nc3.s(pMSAppInfo.appId, vo3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            nc3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
