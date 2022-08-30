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
import com.baidu.tieba.wj2;
import com.baidu.tieba.zj2;
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
public final class s42 {
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
                ch4.j(new File(filesDir, "aiapps_zip"));
                ch4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (File file2 : listFiles) {
                    long lastModified = file2.lastModified();
                    if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                        ch4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948101368, "Lcom/baidu/tieba/s42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948101368, "Lcom/baidu/tieba/s42;");
                return;
            }
        }
        a = kh1.a;
        b = false;
    }

    public s42() {
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

    public static tc3 a(ReadableByteChannel readableByteChannel, String str, q84 q84Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, q84Var)) == null) {
            if (readableByteChannel == null) {
                tc3 tc3Var = new tc3();
                tc3Var.k(11L);
                tc3Var.i(2300L);
                tc3Var.f("empty source");
                xc3.a().f(tc3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tc3Var);
                }
                return tc3Var;
            }
            q84Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            q84Var.n("770", "na_pms_start_check_sign");
            if (ne3.d(readableByteChannel, str, new hf3())) {
                q84Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                q84Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            tc3 tc3Var2 = new tc3();
            tc3Var2.k(11L);
            tc3Var2.i(2300L);
            tc3Var2.f("check zip file sign fail.");
            xc3.a().f(tc3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tc3Var2);
            }
            return tc3Var2;
        }
        return (tc3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable w94 w94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, w94Var)) == null) {
            if (w94Var == null || TextUtils.isEmpty(w94Var.a)) {
                return false;
            }
            File file = new File(w94Var.a);
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
        synchronized (s42.class) {
            if (b) {
                return;
            }
            b = true;
            ud3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? wj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? ik2.g().c() : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? ik2.g().c() : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? wj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? wj2.e.h().getPath() : (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? ik2.g().c() : (String) invokeV.objValue;
    }

    public static boolean j(s94 s94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, s94Var)) == null) {
            if (s94Var == null) {
                return false;
            }
            int i = s94Var.a;
            return i == 1013 || i == 1015;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, x94 x94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, x94Var) == null) || pMSAppInfo == null || x94Var == null) {
            return;
        }
        pMSAppInfo.copyMainPkgInfo(x94Var);
        if (x94Var.h == 1) {
            pMSAppInfo.setOrientation(ik2.i().u(x94Var.g, x94Var.i));
        } else {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, y94 y94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, y94Var) == null) || pMSAppInfo == null || y94Var == null) {
            return;
        }
        pMSAppInfo.copySubPkgInfo(y94Var);
        if (y94Var.h == 0) {
            pMSAppInfo.setOrientation(0);
        }
    }

    public static tc3 m(w94 w94Var, q84 q84Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, w94Var, q84Var)) == null) {
            if (w94Var == null) {
                tc3 tc3Var = new tc3();
                tc3Var.k(11L);
                tc3Var.i(2320L);
                tc3Var.f("pkg info is empty");
                xc3.a().f(tc3Var);
                return tc3Var;
            }
            File file = new File(w94Var.a);
            int i2 = w94Var.h;
            if (i2 == 1) {
                i = ik2.g().a(w94Var.g, String.valueOf(w94Var.i));
                if (i == null) {
                    tc3 tc3Var2 = new tc3();
                    tc3Var2.k(11L);
                    tc3Var2.i(2320L);
                    tc3Var2.f("获取解压目录失败");
                    xc3.a().f(tc3Var2);
                    return tc3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = wj2.e.i(w94Var.g, String.valueOf(w94Var.i));
            } else {
                tc3 tc3Var3 = new tc3();
                tc3Var3.k(11L);
                tc3Var3.i(2320L);
                tc3Var3.f("pkh category illegal");
                xc3.a().f(tc3Var3);
                return tc3Var3;
            }
            if (!file.exists()) {
                tc3 tc3Var4 = new tc3();
                tc3Var4.k(11L);
                tc3Var4.i(2320L);
                tc3Var4.f("解压失败：包不存在");
                xc3.a().f(tc3Var4);
                return tc3Var4;
            } else if (i.isFile() && !i.delete()) {
                ay1.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                tc3 tc3Var5 = new tc3();
                tc3Var5.k(11L);
                tc3Var5.i(2320L);
                tc3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                xc3.a().f(tc3Var5);
                return tc3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                tc3 tc3Var6 = new tc3();
                tc3Var6.k(11L);
                tc3Var6.i(2320L);
                tc3Var6.f("解压失败：解压文件夹创建失败");
                xc3.a().f(tc3Var6);
                return tc3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, q84Var).b) {
                    return null;
                }
                b n = n(file, i, q84Var);
                if (n.b) {
                    p73.a(q84Var, w94Var.h, true);
                    return null;
                }
                p73.a(q84Var, w94Var.h, false);
                ay1.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                ch4.L(i);
                tc3 tc3Var7 = new tc3();
                int i3 = n.a;
                if (i3 == 0) {
                    tc3Var7.k(11L);
                    tc3Var7.i(2320L);
                    tc3Var7.f("unzip failed");
                } else if (i3 != 1 && i3 != 2) {
                    tc3Var7.k(4L);
                    tc3Var7.i(7L);
                    tc3Var7.f("Unkown bundle type");
                } else {
                    tc3Var7.k(11L);
                    tc3Var7.i(2330L);
                    tc3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                }
                xc3.a().f(tc3Var7);
                return tc3Var7;
            }
        }
        return (tc3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull q84 q84Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, q84Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            zj2.c j = zj2.j(file);
            int i = 0;
            if (j.b != -1) {
                q84Var.n("670", "package_start_decrypt");
                q84Var.n("770", "na_package_start_decrypt");
                zj2.b d = zj2.d(j.a, file2, j.b);
                q84Var.n("670", "package_end_decrypt");
                q84Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                q84Var.n("670", "package_start_unzip");
                q84Var.n("770", "na_package_start_unzip");
                boolean U = ch4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = ch4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        b83 b83Var = new b83();
                        tc3 tc3Var = new tc3();
                        tc3Var.k(4L);
                        tc3Var.i(52L);
                        b83Var.p(tc3Var);
                        b83Var.l("path", file2.getAbsolutePath());
                        b83Var.l("eMsg", "unzip files not match zip content");
                        b83Var.l("decryptType", String.valueOf(j.b));
                        b83Var.l("stack", ue3.z(30));
                        t73.R(b83Var);
                    }
                }
                q84Var.n("670", "package_end_unzip");
                q84Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                zj2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            u84.a(q84Var, bundle, "event_download_package_type");
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
            s13.u(pMSAppInfo.appId, "", ae3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            s13.t("", ae3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            s13.s(pMSAppInfo.appId, ae3.d(pMSAppInfo.domains));
        }
        if (TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            return;
        }
        s13.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
    }
}
