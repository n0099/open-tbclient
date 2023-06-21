package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fx2;
import com.baidu.tieba.vu2;
import com.baidu.tieba.xu2;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class wu2 extends xu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final xk4 d;
    public final rj4 e;
    public cm3 f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu2 a;

        public a(wu2 wu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.k();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948282997, "Lcom/baidu/tieba/wu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948282997, "Lcom/baidu/tieba/wu2;");
                return;
            }
        }
        g = js1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || bm3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        cm3 cm3Var = this.f;
        if (cm3Var == null) {
            return;
        }
        cm3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu2(xk4 xk4Var, rj4 rj4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xk4Var, rj4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = xk4Var;
        this.e = rj4Var;
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                q("670", "package_end_decrypt");
                q("770", "na_package_end_decrypt");
                return;
            }
            q("670", "package_end_unzip");
            q("770", "na_package_end_unzip");
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                q("670", "package_start_decrypt");
                q("770", "na_package_start_decrypt");
                return;
            }
            q("670", "package_start_unzip");
            q("770", "na_package_start_unzip");
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || bm3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            cm3 cm3Var = new cm3(str);
            this.f = cm3Var;
            cm3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.xu2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                z82.k("SwanExtractor", "#onInstallFaild del: " + string);
                ds4.M(string);
            }
        }
    }

    public final void k() {
        xk4 xk4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (xk4Var = this.d) != null && xk4Var.h == 0 && !vu2.w()) {
            vu2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.xu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ex2 ex2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ex2Var = ex2.d(string);
                fx2.b e = ex2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ex2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (ex2Var != null && g) {
                ex2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            sn3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            z82.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                ex2 d = ex2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        rj4 rj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (rj4Var = this.e) != null) {
            rj4Var.n(str, str2);
        }
    }

    public final sn3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        yu2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ex2 d = ex2.d(str);
            xk4 xk4Var = this.d;
            if (xk4Var == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(11L);
                sn3Var.i(2320L);
                sn3Var.f("pkg info is empty");
                wn3.a().f(sn3Var);
                return sn3Var;
            }
            int i3 = xk4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                ht1 g2 = hv2.g();
                xk4 xk4Var2 = this.d;
                i = g2.a(xk4Var2.g, String.valueOf(xk4Var2.i));
            } else if (i3 == 0) {
                i = vu2.e.i(xk4Var.g, String.valueOf(xk4Var.i));
            } else {
                sn3 sn3Var2 = new sn3();
                sn3Var2.k(11L);
                sn3Var2.i(2320L);
                sn3Var2.f("pkh category illegal");
                wn3.a().f(sn3Var2);
                return sn3Var2;
            }
            if (i == null) {
                sn3 sn3Var3 = new sn3();
                sn3Var3.k(11L);
                sn3Var3.i(2320L);
                sn3Var3.f("获取解压目录失败");
                wn3.a().f(sn3Var3);
                return sn3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                sn3 sn3Var4 = new sn3();
                sn3Var4.k(11L);
                sn3Var4.i(2320L);
                sn3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                wn3.a().f(sn3Var4);
                return sn3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        to3.k(new a(this), "doFallbackIfNeeded");
                        sn3 sn3Var5 = new sn3();
                        sn3Var5.k(11L);
                        sn3Var5.i(2320L);
                        sn3Var5.f("解压失败：解压文件夹创建失败");
                        wn3.a().f(sn3Var5);
                        return sn3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    yu2.c i4 = yu2.i(bufferedInputStream);
                    if (i4 == null) {
                        i2 = -1;
                    } else {
                        i2 = i4.b;
                    }
                    if (i2 != -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    n(z);
                    if (z) {
                        bVar = yu2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = gs4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        yu2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        vj4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    sn3 sn3Var6 = new sn3();
                    sn3Var6.k(11L);
                    if (z) {
                        sn3Var6.i(2330L);
                        sn3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        sn3Var6.i(2320L);
                        sn3Var6.f("unzip failed");
                    }
                    wn3.a().f(sn3Var6);
                    return sn3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    sn3 sn3Var7 = new sn3();
                    sn3Var7.k(11L);
                    sn3Var7.i(2320L);
                    sn3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    wn3.a().f(sn3Var7);
                    return sn3Var7;
                }
            }
        }
        return (sn3) invokeLL.objValue;
    }
}
