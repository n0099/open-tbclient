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
import com.baidu.tieba.ul2;
import com.baidu.tieba.xl2;
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
public final class q62 {
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
                cj4.j(new File(filesDir, "aiapps_zip"));
                cj4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        cj4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948043708, "Lcom/baidu/tieba/q62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948043708, "Lcom/baidu/tieba/q62;");
                return;
            }
        }
        a = ij1.a;
        b = false;
    }

    public q62() {
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

    public static re3 a(ReadableByteChannel readableByteChannel, String str, qa4 qa4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, qa4Var)) == null) {
            if (readableByteChannel == null) {
                re3 re3Var = new re3();
                re3Var.k(11L);
                re3Var.i(2300L);
                re3Var.f("empty source");
                ve3.a().f(re3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + re3Var);
                }
                return re3Var;
            }
            qa4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            qa4Var.n("770", "na_pms_start_check_sign");
            if (lg3.d(readableByteChannel, str, new fh3())) {
                qa4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                qa4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            re3 re3Var2 = new re3();
            re3Var2.k(11L);
            re3Var2.i(2300L);
            re3Var2.f("check zip file sign fail.");
            ve3.a().f(re3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + re3Var2);
            }
            return re3Var2;
        }
        return (re3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable wb4 wb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, wb4Var)) == null) {
            if (wb4Var == null || TextUtils.isEmpty(wb4Var.a)) {
                return false;
            }
            File file = new File(wb4Var.a);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    @AnyThread
    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || b) {
            return;
        }
        synchronized (q62.class) {
            if (b) {
                return;
            }
            b = true;
            sf3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? ul2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? gm2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? gm2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? ul2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? ul2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? gm2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(sb4 sb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, sb4Var)) == null) {
            if (sb4Var == null) {
                return false;
            }
            int i = sb4Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, xb4 xb4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, xb4Var) == null) || pMSAppInfo == null || xb4Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(xb4Var);
        if (xb4Var.h == 1) {
            pMSAppInfo.setOrientation(gm2.i().u(xb4Var.g, xb4Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, yb4 yb4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, yb4Var) == null) || pMSAppInfo == null || yb4Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(yb4Var);
        if (yb4Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static re3 m(wb4 wb4Var, qa4 qa4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, wb4Var, qa4Var)) == null) {
            if (wb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(11L);
                re3Var.i(2320L);
                re3Var.f("pkg info is empty");
                ve3.a().f(re3Var);
                return re3Var;
            }
            File file = new File(wb4Var.a);
            int i2 = wb4Var.h;
            if (i2 == 1) {
                i = gm2.g().a(wb4Var.g, String.valueOf(wb4Var.i));
                if (i == null) {
                    re3 re3Var2 = new re3();
                    re3Var2.k(11L);
                    re3Var2.i(2320L);
                    re3Var2.f("获取解压目录失败");
                    ve3.a().f(re3Var2);
                    return re3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = ul2.e.i(wb4Var.g, String.valueOf(wb4Var.i));
            } else {
                re3 re3Var3 = new re3();
                re3Var3.k(11L);
                re3Var3.i(2320L);
                re3Var3.f("pkh category illegal");
                ve3.a().f(re3Var3);
                return re3Var3;
            }
            if (!file.exists()) {
                re3 re3Var4 = new re3();
                re3Var4.k(11L);
                re3Var4.i(2320L);
                re3Var4.f("解压失败：包不存在");
                ve3.a().f(re3Var4);
                return re3Var4;
            } else if (i.isFile() && !i.delete()) {
                yz1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                re3 re3Var5 = new re3();
                re3Var5.k(11L);
                re3Var5.i(2320L);
                re3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                ve3.a().f(re3Var5);
                return re3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                re3 re3Var6 = new re3();
                re3Var6.k(11L);
                re3Var6.i(2320L);
                re3Var6.f("解压失败：解压文件夹创建失败");
                ve3.a().f(re3Var6);
                return re3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, qa4Var).b) {
                    return null;
                }
                b n = n(file, i, qa4Var);
                if (n.b) {
                    n93.a(qa4Var, wb4Var.h, true);
                    return null;
                }
                n93.a(qa4Var, wb4Var.h, false);
                yz1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                cj4.L(i);
                re3 re3Var7 = new re3();
                int i3 = n.a;
                if (i3 == 0) {
                    re3Var7.k(11L);
                    re3Var7.i(2320L);
                    re3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    re3Var7.k(4L);
                    re3Var7.i(7L);
                    re3Var7.f("Unkown bundle type");
                } else {
                    re3Var7.k(11L);
                    re3Var7.i(2330L);
                    re3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                ve3.a().f(re3Var7);
                return re3Var7;
            }
        }
        return (re3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull qa4 qa4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, qa4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            xl2.c j = xl2.j(file);
            int i = 0;
            if (j.b != -1) {
                qa4Var.n("670", "package_start_decrypt");
                qa4Var.n("770", "na_package_start_decrypt");
                xl2.b d = xl2.d(j.a, file2, j.b);
                qa4Var.n("670", "package_end_decrypt");
                qa4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                qa4Var.n("670", "package_start_unzip");
                qa4Var.n("770", "na_package_start_unzip");
                boolean U = cj4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = cj4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        z93 z93Var = new z93();
                        re3 re3Var = new re3();
                        re3Var.k(4L);
                        re3Var.i(52L);
                        z93Var.p(re3Var);
                        z93Var.l("path", file2.getAbsolutePath());
                        z93Var.l("eMsg", "unzip files not match zip content");
                        z93Var.l("decryptType", String.valueOf(j.b));
                        z93Var.l("stack", sg3.z(30));
                        r93.R(z93Var);
                    }
                }
                qa4Var.n("670", "package_end_unzip");
                qa4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                xl2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            ua4.a(qa4Var, bundle, "event_download_package_type");
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static void o(@Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
            q33.u(pMSAppInfo.appId, "", yf3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            q33.t("", yf3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            q33.s(pMSAppInfo.appId, yf3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        q33.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
