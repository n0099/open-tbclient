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
import com.baidu.tieba.pq2;
import com.baidu.tieba.sq2;
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
public final class lb2 {
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
                xn4.j(new File(filesDir, "aiapps_zip"));
                xn4.i(filesDir, "aiapps_zip");
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (file2.isFile() && lastModified > 0 && currentTimeMillis - lastModified > 86400000) {
                            xn4.L(file2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947937037, "Lcom/baidu/tieba/lb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947937037, "Lcom/baidu/tieba/lb2;");
                return;
            }
        }
        a = do1.a;
        b = false;
    }

    public lb2() {
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
        synchronized (lb2.class) {
            if (b) {
                return;
            }
            b = true;
            nk3.k(new a(), "deleteHistoryZipFile");
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return pq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return br2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return br2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return pq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return pq2.e.h().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return br2.g().c();
        }
        return (String) invokeV.objValue;
    }

    public static mj3 a(ReadableByteChannel readableByteChannel, String str, lf4 lf4Var) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, readableByteChannel, str, lf4Var)) == null) {
            if (readableByteChannel == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(11L);
                mj3Var.i(2300L);
                mj3Var.f("empty source");
                qj3.a().f(mj3Var);
                if (a) {
                    Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mj3Var);
                }
                return mj3Var;
            }
            lf4Var.n("670", "aiapp_aps_check_sign_start_timestamp");
            lf4Var.n("770", "na_pms_start_check_sign");
            if (gl3.d(readableByteChannel, str, new am3())) {
                lf4Var.n("670", "aiapp_aps_check_sign_end_timestamp");
                lf4Var.n("770", "na_pms_end_check_sign");
                return null;
            }
            mj3 mj3Var2 = new mj3();
            mj3Var2.k(11L);
            mj3Var2.i(2300L);
            mj3Var2.f("check zip file sign fail.");
            qj3.a().f(mj3Var2);
            if (a) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mj3Var2);
            }
            return mj3Var2;
        }
        return (mj3) invokeLLL.objValue;
    }

    public static boolean b(@Nullable rg4 rg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rg4Var)) == null) {
            if (rg4Var == null || TextUtils.isEmpty(rg4Var.a)) {
                return false;
            }
            File file = new File(rg4Var.a);
            if (!file.exists() || !file.isFile() || !file.delete()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(ng4 ng4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ng4Var)) == null) {
            if (ng4Var == null) {
                return false;
            }
            int i = ng4Var.a;
            if (i != 1013 && i != 1015) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void k(PMSAppInfo pMSAppInfo, sg4 sg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, pMSAppInfo, sg4Var) == null) && pMSAppInfo != null && sg4Var != null) {
            pMSAppInfo.copyMainPkgInfo(sg4Var);
            if (sg4Var.h == 1) {
                pMSAppInfo.setOrientation(br2.i().u(sg4Var.g, sg4Var.i));
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void l(PMSAppInfo pMSAppInfo, tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, pMSAppInfo, tg4Var) == null) && pMSAppInfo != null && tg4Var != null) {
            pMSAppInfo.copySubPkgInfo(tg4Var);
            if (tg4Var.h == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static mj3 m(rg4 rg4Var, lf4 lf4Var) {
        InterceptResult invokeLL;
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, rg4Var, lf4Var)) == null) {
            if (rg4Var == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(11L);
                mj3Var.i(2320L);
                mj3Var.f("pkg info is empty");
                qj3.a().f(mj3Var);
                return mj3Var;
            }
            File file = new File(rg4Var.a);
            int i2 = rg4Var.h;
            if (i2 == 1) {
                i = br2.g().a(rg4Var.g, String.valueOf(rg4Var.i));
                if (i == null) {
                    mj3 mj3Var2 = new mj3();
                    mj3Var2.k(11L);
                    mj3Var2.i(2320L);
                    mj3Var2.f("获取解压目录失败");
                    qj3.a().f(mj3Var2);
                    return mj3Var2;
                } else if (a) {
                    Log.e("PkgDownloadUtil", "bundleZipFile:" + file);
                }
            } else if (i2 == 0) {
                i = pq2.e.i(rg4Var.g, String.valueOf(rg4Var.i));
            } else {
                mj3 mj3Var3 = new mj3();
                mj3Var3.k(11L);
                mj3Var3.i(2320L);
                mj3Var3.f("pkh category illegal");
                qj3.a().f(mj3Var3);
                return mj3Var3;
            }
            if (!file.exists()) {
                mj3 mj3Var4 = new mj3();
                mj3Var4.k(11L);
                mj3Var4.i(2320L);
                mj3Var4.f("解压失败：包不存在");
                qj3.a().f(mj3Var4);
                return mj3Var4;
            } else if (i.isFile() && !i.delete()) {
                t42.k("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除 path=" + i.getAbsolutePath());
                mj3 mj3Var5 = new mj3();
                mj3Var5.k(11L);
                mj3Var5.i(2320L);
                mj3Var5.f("解压失败：解压目录被文件占用，且无法删除");
                qj3.a().f(mj3Var5);
                return mj3Var5;
            } else if (!i.exists() && !i.mkdirs()) {
                if (a) {
                    Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + i.getAbsolutePath());
                }
                mj3 mj3Var6 = new mj3();
                mj3Var6.k(11L);
                mj3Var6.i(2320L);
                mj3Var6.f("解压失败：解压文件夹创建失败");
                qj3.a().f(mj3Var6);
                return mj3Var6;
            } else {
                if (a) {
                    Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + i.getPath());
                }
                if (n(file, i, lf4Var).b) {
                    return null;
                }
                b n = n(file, i, lf4Var);
                if (n.b) {
                    ie3.a(lf4Var, rg4Var.h, true);
                    return null;
                }
                ie3.a(lf4Var, rg4Var.h, false);
                t42.k("PkgDownloadUtil", "解压失败后删除解压目录: " + i.getAbsolutePath());
                xn4.L(i);
                mj3 mj3Var7 = new mj3();
                int i3 = n.a;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        mj3Var7.k(4L);
                        mj3Var7.i(7L);
                        mj3Var7.f("Unkown bundle type");
                    } else {
                        mj3Var7.k(11L);
                        mj3Var7.i(2330L);
                        mj3Var7.f("decryt failed:" + n.c + ", PkgType=" + n.a);
                    }
                } else {
                    mj3Var7.k(11L);
                    mj3Var7.i(2320L);
                    mj3Var7.f("unzip failed");
                }
                qj3.a().f(mj3Var7);
                return mj3Var7;
            }
        }
        return (mj3) invokeLL.objValue;
    }

    @NonNull
    public static b n(@NonNull File file, @NonNull File file2, @NonNull lf4 lf4Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, file, file2, lf4Var)) == null) {
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            sq2.c j = sq2.j(file);
            int i = 0;
            if (j.b != -1) {
                lf4Var.n("670", "package_start_decrypt");
                lf4Var.n("770", "na_package_start_decrypt");
                sq2.b d = sq2.d(j.a, file2, j.b);
                lf4Var.n("670", "package_end_decrypt");
                lf4Var.n("770", "na_package_end_decrypt");
                bVar.b = d.a;
                bVar.c = d.b;
                i = j.b;
                bVar.a = i;
            } else {
                bVar.a = 0;
                lf4Var.n("670", "package_start_unzip");
                lf4Var.n("770", "na_package_start_unzip");
                boolean U = xn4.U(file.getPath(), file2.getPath());
                bVar.b = U;
                if (U) {
                    boolean B = xn4.B(file.getAbsolutePath(), file2.getAbsolutePath());
                    bVar.b = B;
                    if (!B) {
                        ue3 ue3Var = new ue3();
                        mj3 mj3Var = new mj3();
                        mj3Var.k(4L);
                        mj3Var.i(52L);
                        ue3Var.p(mj3Var);
                        ue3Var.l("path", file2.getAbsolutePath());
                        ue3Var.l("eMsg", "unzip files not match zip content");
                        ue3Var.l("decryptType", String.valueOf(j.b));
                        ue3Var.l("stack", nl3.z(30));
                        me3.R(ue3Var);
                    }
                }
                lf4Var.n("670", "package_end_unzip");
                lf4Var.n("770", "na_package_end_unzip");
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a) {
                sq2.h((int) (currentTimeMillis2 - currentTimeMillis));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("download_package_type_id", i);
            pf4.a(lf4Var, bundle, "event_download_package_type");
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
            l83.u(pMSAppInfo.appId, "", tk3.e(pMSAppInfo.webViewDomains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
            l83.t("", tk3.e(pMSAppInfo.webAction));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
            l83.s(pMSAppInfo.appId, tk3.d(pMSAppInfo.domains));
        }
        if (!TextUtils.isEmpty(pMSAppInfo.domainConfig)) {
            l83.r(pMSAppInfo.appId, pMSAppInfo.domainConfig);
        }
    }
}
