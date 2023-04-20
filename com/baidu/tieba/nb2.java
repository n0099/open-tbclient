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
import com.baidu.tieba.rq2;
import com.baidu.tieba.uq2;
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
public final class nb2 {
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
                zn4.j(new File(filesDir, "aiapps_zip"));
                zn4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            zn4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996619, "Lcom/baidu/tieba/nb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996619, "Lcom/baidu/tieba/nb2;");
                return;
            }
        }
        a = fo1.a;
        b = false;
    }

    public nb2() {
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
        synchronized (nb2.class) {
            if (b) {
                return;
            }
            b = true;
            pk3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return rq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return dr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return dr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return rq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return rq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return dr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static oj3 a(ReadableByteChannel readableByteChannel, String str, nf4 nf4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, nf4Var)) == null) {
            if (readableByteChannel == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(11L);
                oj3Var.i(2300L);
                oj3Var.f("empty source");
                sj3.a().f(oj3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + oj3Var);
                }
                return oj3Var;
            }
            nf4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            nf4Var.n("770", "na_pms_start_check_sign");
            if (il3.d(readableByteChannel, str, new cm3())) {
                nf4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                nf4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            oj3 oj3Var2 = new oj3();
            oj3Var2.k(11L);
            oj3Var2.i(2300L);
            oj3Var2.f("check zip file sign fail.");
            sj3.a().f(oj3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + oj3Var2);
            }
            return oj3Var2;
        }
        return (oj3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable tg4 tg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tg4Var)) == null) {
            if (tg4Var == null || TextUtils.isEmpty(tg4Var.a)) {
                return false;
            }
            File file = new File(tg4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(pg4 pg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, pg4Var)) == null) {
            if (pg4Var == null) {
                return false;
            }
            int i = pg4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, ug4Var) == null) && pMSAppInfo != null && ug4Var != null) {
            pMSAppInfo.copyMainPkgInfo(ug4Var);
            if (ug4Var.h == 1) {
                pMSAppInfo.setOrientation(dr2.i().u(ug4Var.g, ug4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, vg4Var) == null) && pMSAppInfo != null && vg4Var != null) {
            pMSAppInfo.copySubPkgInfo(vg4Var);
            if (vg4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static oj3 m(tg4 tg4Var, nf4 nf4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, tg4Var, nf4Var)) == null) {
            if (tg4Var == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(11L);
                oj3Var.i(2320L);
                oj3Var.f("pkg info is empty");
                sj3.a().f(oj3Var);
                return oj3Var;
            }
            File file = new File(tg4Var.a);
            int i2 = tg4Var.h;
            if (i2 == 1) {
                i = dr2.g().a(tg4Var.g, String.valueOf(tg4Var.i));
                if (i == null) {
                    oj3 oj3Var2 = new oj3();
                    oj3Var2.k(11L);
                    oj3Var2.i(2320L);
                    oj3Var2.f("获取解压目录失败");
                    sj3.a().f(oj3Var2);
                    return oj3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = rq2.e.i(tg4Var.g, String.valueOf(tg4Var.i));
            } else {
                oj3 oj3Var3 = new oj3();
                oj3Var3.k(11L);
                oj3Var3.i(2320L);
                oj3Var3.f("pkh category illegal");
                sj3.a().f(oj3Var3);
                return oj3Var3;
            }
            if (!file.exists()) {
                oj3 oj3Var4 = new oj3();
                oj3Var4.k(11L);
                oj3Var4.i(2320L);
                oj3Var4.f("解压失败：包不存在");
                sj3.a().f(oj3Var4);
                return oj3Var4;
            } else if (i.isFile() && !i.delete()) {
                v42.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                oj3 oj3Var5 = new oj3();
                oj3Var5.k(11L);
                oj3Var5.i(2320L);
                oj3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                sj3.a().f(oj3Var5);
                return oj3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                oj3 oj3Var6 = new oj3();
                oj3Var6.k(11L);
                oj3Var6.i(2320L);
                oj3Var6.f("解压失败：解压文件夹创建失败");
                sj3.a().f(oj3Var6);
                return oj3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, nf4Var).b) {
                    return null;
                }
                b n = n(file, i, nf4Var);
                if (n.b) {
                    ke3.a(nf4Var, tg4Var.h, true);
                    return null;
                }
                ke3.a(nf4Var, tg4Var.h, false);
                v42.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                zn4.L(i);
                oj3 oj3Var7 = new oj3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        oj3Var7.k(4L);
                        oj3Var7.i(7L);
                        oj3Var7.f("Unkown bundle type");
                    } else {
                        oj3Var7.k(11L);
                        oj3Var7.i(2330L);
                        oj3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    oj3Var7.k(11L);
                    oj3Var7.i(2320L);
                    oj3Var7.f("unzip failed");
                }
                sj3.a().f(oj3Var7);
                return oj3Var7;
            }
        }
        return (oj3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull nf4 nf4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, nf4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            uq2.c j = uq2.j(file);
            int i = 0;
            if (j.b != -1) {
                nf4Var.n("670", "package_start_decrypt");
                nf4Var.n("770", "na_package_start_decrypt");
                uq2.b d = uq2.d(j.a, file2, j.b);
                nf4Var.n("670", "package_end_decrypt");
                nf4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                nf4Var.n("670", "package_start_unzip");
                nf4Var.n("770", "na_package_start_unzip");
                boolean U = zn4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = zn4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        we3 we3Var = new we3();
                        oj3 oj3Var = new oj3();
                        oj3Var.k(4L);
                        oj3Var.i(52L);
                        we3Var.p(oj3Var);
                        we3Var.l("path", file2.getAbsolutePath());
                        we3Var.l("eMsg", "unzip files not match zip content");
                        we3Var.l("decryptType", String.valueOf(j.b));
                        we3Var.l("stack", pl3.z(30));
                        oe3.R(we3Var);
                    }
                }
                nf4Var.n("670", "package_end_unzip");
                nf4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                uq2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            rf4.a(nf4Var, bundle, "event_download_package_type");
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
            n83.u(pMSAppInfo.appId, "", vk3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            n83.t("", vk3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            n83.s(pMSAppInfo.appId, vk3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            n83.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
