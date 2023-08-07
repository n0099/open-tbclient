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
import com.baidu.tieba.ut2;
import com.baidu.tieba.xt2;
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
public final class qe2 {
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
                cr4.j(new File(filesDir, "aiapps_zip"));
                cr4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            cr4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948088875, "Lcom/baidu/tieba/qe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948088875, "Lcom/baidu/tieba/qe2;");
                return;
            }
        }
        a = ir1.a;
        b = false;
    }

    public qe2() {
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
        synchronized (qe2.class) {
            if (b) {
                return;
            }
            b = true;
            sn3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return ut2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return gu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return gu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return ut2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return ut2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return gu2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static rm3 a(ReadableByteChannel readableByteChannel, String str, qi4 qi4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, qi4Var)) == null) {
            if (readableByteChannel == null) {
                rm3 rm3Var = new rm3();
                rm3Var.k(11L);
                rm3Var.i(2300L);
                rm3Var.f("empty source");
                vm3.a().f(rm3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + rm3Var);
                }
                return rm3Var;
            }
            qi4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            qi4Var.n("770", "na_pms_start_check_sign");
            if (lo3.d(readableByteChannel, str, new fp3())) {
                qi4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                qi4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            rm3 rm3Var2 = new rm3();
            rm3Var2.k(11L);
            rm3Var2.i(2300L);
            rm3Var2.f("check zip file sign fail.");
            vm3.a().f(rm3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + rm3Var2);
            }
            return rm3Var2;
        }
        return (rm3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable wj4 wj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, wj4Var)) == null) {
            if (wj4Var == null || TextUtils.isEmpty(wj4Var.a)) {
                return false;
            }
            File file = new File(wj4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(sj4 sj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sj4Var)) == null) {
            if (sj4Var == null) {
                return false;
            }
            int i = sj4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, xj4Var) == null) && pMSAppInfo != null && xj4Var != null) {
            pMSAppInfo.copyMainPkgInfo(xj4Var);
            if (xj4Var.h == 1) {
                pMSAppInfo.setOrientation(gu2.i().u(xj4Var.g, xj4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, yj4 yj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, yj4Var) == null) && pMSAppInfo != null && yj4Var != null) {
            pMSAppInfo.copySubPkgInfo(yj4Var);
            if (yj4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static rm3 m(wj4 wj4Var, qi4 qi4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, wj4Var, qi4Var)) == null) {
            if (wj4Var == null) {
                rm3 rm3Var = new rm3();
                rm3Var.k(11L);
                rm3Var.i(2320L);
                rm3Var.f("pkg info is empty");
                vm3.a().f(rm3Var);
                return rm3Var;
            }
            File file = new File(wj4Var.a);
            int i2 = wj4Var.h;
            if (i2 == 1) {
                i = gu2.g().a(wj4Var.g, String.valueOf(wj4Var.i));
                if (i == null) {
                    rm3 rm3Var2 = new rm3();
                    rm3Var2.k(11L);
                    rm3Var2.i(2320L);
                    rm3Var2.f("获取解压目录失败");
                    vm3.a().f(rm3Var2);
                    return rm3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = ut2.e.i(wj4Var.g, String.valueOf(wj4Var.i));
            } else {
                rm3 rm3Var3 = new rm3();
                rm3Var3.k(11L);
                rm3Var3.i(2320L);
                rm3Var3.f("pkh category illegal");
                vm3.a().f(rm3Var3);
                return rm3Var3;
            }
            if (!file.exists()) {
                rm3 rm3Var4 = new rm3();
                rm3Var4.k(11L);
                rm3Var4.i(2320L);
                rm3Var4.f("解压失败：包不存在");
                vm3.a().f(rm3Var4);
                return rm3Var4;
            } else if (i.isFile() && !i.delete()) {
                y72.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                rm3 rm3Var5 = new rm3();
                rm3Var5.k(11L);
                rm3Var5.i(2320L);
                rm3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                vm3.a().f(rm3Var5);
                return rm3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                rm3 rm3Var6 = new rm3();
                rm3Var6.k(11L);
                rm3Var6.i(2320L);
                rm3Var6.f("解压失败：解压文件夹创建失败");
                vm3.a().f(rm3Var6);
                return rm3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, qi4Var).b) {
                    return null;
                }
                b n = n(file, i, qi4Var);
                if (n.b) {
                    nh3.a(qi4Var, wj4Var.h, true);
                    return null;
                }
                nh3.a(qi4Var, wj4Var.h, false);
                y72.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                cr4.L(i);
                rm3 rm3Var7 = new rm3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        rm3Var7.k(4L);
                        rm3Var7.i(7L);
                        rm3Var7.f("Unkown bundle type");
                    } else {
                        rm3Var7.k(11L);
                        rm3Var7.i(2330L);
                        rm3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    rm3Var7.k(11L);
                    rm3Var7.i(2320L);
                    rm3Var7.f("unzip failed");
                }
                vm3.a().f(rm3Var7);
                return rm3Var7;
            }
        }
        return (rm3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull qi4 qi4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, qi4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            xt2.c j = xt2.j(file);
            int i = 0;
            if (j.b != -1) {
                qi4Var.n("670", "package_start_decrypt");
                qi4Var.n("770", "na_package_start_decrypt");
                xt2.b d = xt2.d(j.a, file2, j.b);
                qi4Var.n("670", "package_end_decrypt");
                qi4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                qi4Var.n("670", "package_start_unzip");
                qi4Var.n("770", "na_package_start_unzip");
                boolean U = cr4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = cr4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        zh3 zh3Var = new zh3();
                        rm3 rm3Var = new rm3();
                        rm3Var.k(4L);
                        rm3Var.i(52L);
                        zh3Var.p(rm3Var);
                        zh3Var.l("path", file2.getAbsolutePath());
                        zh3Var.l("eMsg", "unzip files not match zip content");
                        zh3Var.l("decryptType", String.valueOf(j.b));
                        zh3Var.l("stack", so3.z(30));
                        rh3.R(zh3Var);
                    }
                }
                qi4Var.n("670", "package_end_unzip");
                qi4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                xt2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ui4.a(qi4Var, bundle, "event_download_package_type");
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
            qb3.u(pMSAppInfo.appId, "", yn3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            qb3.t("", yn3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            qb3.s(pMSAppInfo.appId, yn3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            qb3.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
