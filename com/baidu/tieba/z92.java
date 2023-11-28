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
import com.baidu.tieba.dp2;
import com.baidu.tieba.gp2;
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
public final class z92 {
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
                km4.j(new File(filesDir, "aiapps_zip"));
                km4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            km4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314710, "Lcom/baidu/tieba/z92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314710, "Lcom/baidu/tieba/z92;");
                return;
            }
        }
        a = sm1.a;
        b = false;
    }

    public z92() {
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
        synchronized (z92.class) {
            if (b) {
                return;
            }
            b = true;
            bj3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return dp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return pp2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return pp2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return dp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return dp2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return pp2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static ai3 a(ReadableByteChannel readableByteChannel, String str, zd4 zd4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, zd4Var)) == null) {
            if (readableByteChannel == null) {
                ai3 ai3Var = new ai3();
                ai3Var.k(11L);
                ai3Var.i(2300L);
                ai3Var.f("empty source");
                ei3.a().f(ai3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ai3Var);
                }
                return ai3Var;
            }
            zd4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            zd4Var.n("770", "na_pms_start_check_sign");
            if (uj3.d(readableByteChannel, str, new ok3())) {
                zd4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                zd4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            ai3 ai3Var2 = new ai3();
            ai3Var2.k(11L);
            ai3Var2.i(2300L);
            ai3Var2.f("check zip file sign fail.");
            ei3.a().f(ai3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ai3Var2);
            }
            return ai3Var2;
        }
        return (ai3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable ff4 ff4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ff4Var)) == null) {
            if (ff4Var == null || TextUtils.isEmpty(ff4Var.a)) {
                return false;
            }
            File file = new File(ff4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(bf4 bf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bf4Var)) == null) {
            if (bf4Var == null) {
                return false;
            }
            int i = bf4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, gf4Var) == null) && pMSAppInfo != null && gf4Var != null) {
            pMSAppInfo.copyMainPkgInfo(gf4Var);
            if (gf4Var.h == 1) {
                pMSAppInfo.setOrientation(pp2.i().u(gf4Var.g, gf4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, hf4Var) == null) && pMSAppInfo != null && hf4Var != null) {
            pMSAppInfo.copySubPkgInfo(hf4Var);
            if (hf4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static ai3 m(ff4 ff4Var, zd4 zd4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, ff4Var, zd4Var)) == null) {
            if (ff4Var == null) {
                ai3 ai3Var = new ai3();
                ai3Var.k(11L);
                ai3Var.i(2320L);
                ai3Var.f("pkg info is empty");
                ei3.a().f(ai3Var);
                return ai3Var;
            }
            File file = new File(ff4Var.a);
            int i2 = ff4Var.h;
            if (i2 == 1) {
                i = pp2.g().a(ff4Var.g, String.valueOf(ff4Var.i));
                if (i == null) {
                    ai3 ai3Var2 = new ai3();
                    ai3Var2.k(11L);
                    ai3Var2.i(2320L);
                    ai3Var2.f("获取解压目录失败");
                    ei3.a().f(ai3Var2);
                    return ai3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = dp2.e.i(ff4Var.g, String.valueOf(ff4Var.i));
            } else {
                ai3 ai3Var3 = new ai3();
                ai3Var3.k(11L);
                ai3Var3.i(2320L);
                ai3Var3.f("pkh category illegal");
                ei3.a().f(ai3Var3);
                return ai3Var3;
            }
            if (!file.exists()) {
                ai3 ai3Var4 = new ai3();
                ai3Var4.k(11L);
                ai3Var4.i(2320L);
                ai3Var4.f("解压失败：包不存在");
                ei3.a().f(ai3Var4);
                return ai3Var4;
            } else if (i.isFile() && !i.delete()) {
                h32.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                ai3 ai3Var5 = new ai3();
                ai3Var5.k(11L);
                ai3Var5.i(2320L);
                ai3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                ei3.a().f(ai3Var5);
                return ai3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                ai3 ai3Var6 = new ai3();
                ai3Var6.k(11L);
                ai3Var6.i(2320L);
                ai3Var6.f("解压失败：解压文件夹创建失败");
                ei3.a().f(ai3Var6);
                return ai3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, zd4Var).b) {
                    return null;
                }
                b n = n(file, i, zd4Var);
                if (n.b) {
                    wc3.a(zd4Var, ff4Var.h, true);
                    return null;
                }
                wc3.a(zd4Var, ff4Var.h, false);
                h32.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                km4.L(i);
                ai3 ai3Var7 = new ai3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        ai3Var7.k(4L);
                        ai3Var7.i(7L);
                        ai3Var7.f("Unkown bundle type");
                    } else {
                        ai3Var7.k(11L);
                        ai3Var7.i(2330L);
                        ai3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    ai3Var7.k(11L);
                    ai3Var7.i(2320L);
                    ai3Var7.f("unzip failed");
                }
                ei3.a().f(ai3Var7);
                return ai3Var7;
            }
        }
        return (ai3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull zd4 zd4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, zd4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            gp2.c j = gp2.j(file);
            int i = 0;
            if (j.b != -1) {
                zd4Var.n("670", "package_start_decrypt");
                zd4Var.n("770", "na_package_start_decrypt");
                gp2.b d = gp2.d(j.a, file2, j.b);
                zd4Var.n("670", "package_end_decrypt");
                zd4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                zd4Var.n("670", "package_start_unzip");
                zd4Var.n("770", "na_package_start_unzip");
                boolean U = km4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = km4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        id3 id3Var = new id3();
                        ai3 ai3Var = new ai3();
                        ai3Var.k(4L);
                        ai3Var.i(52L);
                        id3Var.p(ai3Var);
                        id3Var.l("path", file2.getAbsolutePath());
                        id3Var.l("eMsg", "unzip files not match zip content");
                        id3Var.l("decryptType", String.valueOf(j.b));
                        id3Var.l("stack", bk3.z(30));
                        ad3.R(id3Var);
                    }
                }
                zd4Var.n("670", "package_end_unzip");
                zd4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                gp2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            de4.a(zd4Var, bundle, "event_download_package_type");
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
            z63.u(pMSAppInfo.appId, "", hj3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            z63.t("", hj3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            z63.s(pMSAppInfo.appId, hj3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            z63.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
