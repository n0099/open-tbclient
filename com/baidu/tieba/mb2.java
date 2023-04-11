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
import com.baidu.tieba.qq2;
import com.baidu.tieba.tq2;
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
public final class mb2 {
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
                yn4.j(new File(filesDir, "aiapps_zip"));
                yn4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            yn4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947966828, "Lcom/baidu/tieba/mb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947966828, "Lcom/baidu/tieba/mb2;");
                return;
            }
        }
        a = eo1.a;
        b = false;
    }

    public mb2() {
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
        synchronized (mb2.class) {
            if (b) {
                return;
            }
            b = true;
            ok3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return qq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return cr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return cr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return qq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return qq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return cr2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static nj3 a(ReadableByteChannel readableByteChannel, String str, mf4 mf4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, mf4Var)) == null) {
            if (readableByteChannel == null) {
                nj3 nj3Var = new nj3();
                nj3Var.k(11L);
                nj3Var.i(2300L);
                nj3Var.f("empty source");
                rj3.a().f(nj3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + nj3Var);
                }
                return nj3Var;
            }
            mf4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            mf4Var.n("770", "na_pms_start_check_sign");
            if (hl3.d(readableByteChannel, str, new bm3())) {
                mf4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                mf4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            nj3 nj3Var2 = new nj3();
            nj3Var2.k(11L);
            nj3Var2.i(2300L);
            nj3Var2.f("check zip file sign fail.");
            rj3.a().f(nj3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + nj3Var2);
            }
            return nj3Var2;
        }
        return (nj3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable sg4 sg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sg4Var)) == null) {
            if (sg4Var == null || TextUtils.isEmpty(sg4Var.a)) {
                return false;
            }
            File file = new File(sg4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(og4 og4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, og4Var)) == null) {
            if (og4Var == null) {
                return false;
            }
            int i = og4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, tg4Var) == null) && pMSAppInfo != null && tg4Var != null) {
            pMSAppInfo.copyMainPkgInfo(tg4Var);
            if (tg4Var.h == 1) {
                pMSAppInfo.setOrientation(cr2.i().u(tg4Var.g, tg4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, ug4Var) == null) && pMSAppInfo != null && ug4Var != null) {
            pMSAppInfo.copySubPkgInfo(ug4Var);
            if (ug4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static nj3 m(sg4 sg4Var, mf4 mf4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, sg4Var, mf4Var)) == null) {
            if (sg4Var == null) {
                nj3 nj3Var = new nj3();
                nj3Var.k(11L);
                nj3Var.i(2320L);
                nj3Var.f("pkg info is empty");
                rj3.a().f(nj3Var);
                return nj3Var;
            }
            File file = new File(sg4Var.a);
            int i2 = sg4Var.h;
            if (i2 == 1) {
                i = cr2.g().a(sg4Var.g, String.valueOf(sg4Var.i));
                if (i == null) {
                    nj3 nj3Var2 = new nj3();
                    nj3Var2.k(11L);
                    nj3Var2.i(2320L);
                    nj3Var2.f("获取解压目录失败");
                    rj3.a().f(nj3Var2);
                    return nj3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = qq2.e.i(sg4Var.g, String.valueOf(sg4Var.i));
            } else {
                nj3 nj3Var3 = new nj3();
                nj3Var3.k(11L);
                nj3Var3.i(2320L);
                nj3Var3.f("pkh category illegal");
                rj3.a().f(nj3Var3);
                return nj3Var3;
            }
            if (!file.exists()) {
                nj3 nj3Var4 = new nj3();
                nj3Var4.k(11L);
                nj3Var4.i(2320L);
                nj3Var4.f("解压失败：包不存在");
                rj3.a().f(nj3Var4);
                return nj3Var4;
            } else if (i.isFile() && !i.delete()) {
                u42.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                nj3 nj3Var5 = new nj3();
                nj3Var5.k(11L);
                nj3Var5.i(2320L);
                nj3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                rj3.a().f(nj3Var5);
                return nj3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                nj3 nj3Var6 = new nj3();
                nj3Var6.k(11L);
                nj3Var6.i(2320L);
                nj3Var6.f("解压失败：解压文件夹创建失败");
                rj3.a().f(nj3Var6);
                return nj3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, mf4Var).b) {
                    return null;
                }
                b n = n(file, i, mf4Var);
                if (n.b) {
                    je3.a(mf4Var, sg4Var.h, true);
                    return null;
                }
                je3.a(mf4Var, sg4Var.h, false);
                u42.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                yn4.L(i);
                nj3 nj3Var7 = new nj3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        nj3Var7.k(4L);
                        nj3Var7.i(7L);
                        nj3Var7.f("Unkown bundle type");
                    } else {
                        nj3Var7.k(11L);
                        nj3Var7.i(2330L);
                        nj3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    nj3Var7.k(11L);
                    nj3Var7.i(2320L);
                    nj3Var7.f("unzip failed");
                }
                rj3.a().f(nj3Var7);
                return nj3Var7;
            }
        }
        return (nj3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull mf4 mf4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, mf4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            tq2.c j = tq2.j(file);
            int i = 0;
            if (j.b != -1) {
                mf4Var.n("670", "package_start_decrypt");
                mf4Var.n("770", "na_package_start_decrypt");
                tq2.b d = tq2.d(j.a, file2, j.b);
                mf4Var.n("670", "package_end_decrypt");
                mf4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                mf4Var.n("670", "package_start_unzip");
                mf4Var.n("770", "na_package_start_unzip");
                boolean U = yn4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = yn4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ve3 ve3Var = new ve3();
                        nj3 nj3Var = new nj3();
                        nj3Var.k(4L);
                        nj3Var.i(52L);
                        ve3Var.p(nj3Var);
                        ve3Var.l("path", file2.getAbsolutePath());
                        ve3Var.l("eMsg", "unzip files not match zip content");
                        ve3Var.l("decryptType", String.valueOf(j.b));
                        ve3Var.l("stack", ol3.z(30));
                        ne3.R(ve3Var);
                    }
                }
                mf4Var.n("670", "package_end_unzip");
                mf4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                tq2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            qf4.a(mf4Var, bundle, "event_download_package_type");
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
            m83.u(pMSAppInfo.appId, "", uk3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            m83.t("", uk3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            m83.s(pMSAppInfo.appId, uk3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            m83.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
