package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ex2;
import com.baidu.tieba.uu2;
import com.baidu.tieba.wu2;
import com.baidu.tieba.xu2;
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
public class vu2 extends wu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final wk4 d;
    public final qj4 e;
    public bm3 f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu2 a;

        public a(vu2 vu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948253206, "Lcom/baidu/tieba/vu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948253206, "Lcom/baidu/tieba/vu2;");
                return;
            }
        }
        g = is1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || am3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        bm3 bm3Var = this.f;
        if (bm3Var == null) {
            return;
        }
        bm3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vu2(wk4 wk4Var, qj4 qj4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wk4Var, qj4Var};
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
        this.d = wk4Var;
        this.e = qj4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || am3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            bm3 bm3Var = new bm3(str);
            this.f = bm3Var;
            bm3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.wu2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                y82.k("SwanExtractor", "#onInstallFaild del: " + string);
                cs4.M(string);
            }
        }
    }

    public final void k() {
        wk4 wk4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (wk4Var = this.d) != null && wk4Var.h == 0 && !uu2.w()) {
            uu2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.wu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        dx2 dx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                dx2Var = dx2.d(string);
                ex2.b e = dx2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                dx2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (dx2Var != null && g) {
                dx2Var.g("SwanExtractor", "done: " + l);
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
            rn3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            y82.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                dx2 d = dx2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        qj4 qj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (qj4Var = this.e) != null) {
            qj4Var.n(str, str2);
        }
    }

    public final rn3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        xu2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            dx2 d = dx2.d(str);
            wk4 wk4Var = this.d;
            if (wk4Var == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(11L);
                rn3Var.i(2320L);
                rn3Var.f("pkg info is empty");
                vn3.a().f(rn3Var);
                return rn3Var;
            }
            int i3 = wk4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                gt1 g2 = gv2.g();
                wk4 wk4Var2 = this.d;
                i = g2.a(wk4Var2.g, String.valueOf(wk4Var2.i));
            } else if (i3 == 0) {
                i = uu2.e.i(wk4Var.g, String.valueOf(wk4Var.i));
            } else {
                rn3 rn3Var2 = new rn3();
                rn3Var2.k(11L);
                rn3Var2.i(2320L);
                rn3Var2.f("pkh category illegal");
                vn3.a().f(rn3Var2);
                return rn3Var2;
            }
            if (i == null) {
                rn3 rn3Var3 = new rn3();
                rn3Var3.k(11L);
                rn3Var3.i(2320L);
                rn3Var3.f("获取解压目录失败");
                vn3.a().f(rn3Var3);
                return rn3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                rn3 rn3Var4 = new rn3();
                rn3Var4.k(11L);
                rn3Var4.i(2320L);
                rn3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                vn3.a().f(rn3Var4);
                return rn3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        so3.k(new a(this), "doFallbackIfNeeded");
                        rn3 rn3Var5 = new rn3();
                        rn3Var5.k(11L);
                        rn3Var5.i(2320L);
                        rn3Var5.f("解压失败：解压文件夹创建失败");
                        vn3.a().f(rn3Var5);
                        return rn3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    xu2.c i4 = xu2.i(bufferedInputStream);
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
                        bVar = xu2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = fs4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        xu2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        uj4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    rn3 rn3Var6 = new rn3();
                    rn3Var6.k(11L);
                    if (z) {
                        rn3Var6.i(2330L);
                        rn3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        rn3Var6.i(2320L);
                        rn3Var6.f("unzip failed");
                    }
                    vn3.a().f(rn3Var6);
                    return rn3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    rn3 rn3Var7 = new rn3();
                    rn3Var7.k(11L);
                    rn3Var7.i(2320L);
                    rn3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    vn3.a().f(rn3Var7);
                    return rn3Var7;
                }
            }
        }
        return (rn3) invokeLL.objValue;
    }
}
