package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bt2;
import com.baidu.tieba.rq2;
import com.baidu.tieba.tq2;
import com.baidu.tieba.uq2;
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
/* loaded from: classes6.dex */
public class sq2 extends tq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final tg4 d;
    public final nf4 e;
    public yh3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq2 a;

        public a(sq2 sq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159989, "Lcom/baidu/tieba/sq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159989, "Lcom/baidu/tieba/sq2;");
                return;
            }
        }
        g = fo1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || xh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        yh3 yh3Var = this.f;
        if (yh3Var == null) {
            return;
        }
        yh3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq2(tg4 tg4Var, nf4 nf4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tg4Var, nf4Var};
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
        this.d = tg4Var;
        this.e = nf4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || xh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            yh3 yh3Var = new yh3(str);
            this.f = yh3Var;
            yh3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.tq2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                v42.k("SwanExtractor", "#onInstallFaild del: " + string);
                zn4.M(string);
            }
        }
    }

    public final void k() {
        tg4 tg4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tg4Var = this.d) != null && tg4Var.h == 0 && !rq2.w()) {
            rq2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.tq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        at2 at2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                at2Var = at2.d(string);
                bt2.b e = at2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                at2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (at2Var != null && g) {
                at2Var.g("SwanExtractor", "done: " + l);
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
            oj3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            v42.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                at2 d = at2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        nf4 nf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (nf4Var = this.e) != null) {
            nf4Var.n(str, str2);
        }
    }

    public final oj3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        uq2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            at2 d = at2.d(str);
            tg4 tg4Var = this.d;
            if (tg4Var == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(11L);
                oj3Var.i(2320L);
                oj3Var.f("pkg info is empty");
                sj3.a().f(oj3Var);
                return oj3Var;
            }
            int i3 = tg4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                dp1 g2 = dr2.g();
                tg4 tg4Var2 = this.d;
                i = g2.a(tg4Var2.g, String.valueOf(tg4Var2.i));
            } else if (i3 == 0) {
                i = rq2.e.i(tg4Var.g, String.valueOf(tg4Var.i));
            } else {
                oj3 oj3Var2 = new oj3();
                oj3Var2.k(11L);
                oj3Var2.i(2320L);
                oj3Var2.f("pkh category illegal");
                sj3.a().f(oj3Var2);
                return oj3Var2;
            }
            if (i == null) {
                oj3 oj3Var3 = new oj3();
                oj3Var3.k(11L);
                oj3Var3.i(2320L);
                oj3Var3.f("获取解压目录失败");
                sj3.a().f(oj3Var3);
                return oj3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                oj3 oj3Var4 = new oj3();
                oj3Var4.k(11L);
                oj3Var4.i(2320L);
                oj3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                sj3.a().f(oj3Var4);
                return oj3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        pk3.k(new a(this), "doFallbackIfNeeded");
                        oj3 oj3Var5 = new oj3();
                        oj3Var5.k(11L);
                        oj3Var5.i(2320L);
                        oj3Var5.f("解压失败：解压文件夹创建失败");
                        sj3.a().f(oj3Var5);
                        return oj3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    uq2.c i4 = uq2.i(bufferedInputStream);
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
                        bVar = uq2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = co4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        uq2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        rf4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    oj3 oj3Var6 = new oj3();
                    oj3Var6.k(11L);
                    if (z) {
                        oj3Var6.i(2330L);
                        oj3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        oj3Var6.i(2320L);
                        oj3Var6.f("unzip failed");
                    }
                    sj3.a().f(oj3Var6);
                    return oj3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    oj3 oj3Var7 = new oj3();
                    oj3Var7.k(11L);
                    oj3Var7.i(2320L);
                    oj3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    sj3.a().f(oj3Var7);
                    return oj3Var7;
                }
            }
        }
        return (oj3) invokeLL.objValue;
    }
}
