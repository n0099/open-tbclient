package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dt2;
import com.baidu.tieba.tq2;
import com.baidu.tieba.vq2;
import com.baidu.tieba.wq2;
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
public class uq2 extends vq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final vg4 d;
    public final pf4 e;
    public ai3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq2 a;

        public a(uq2 uq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uq2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948219571, "Lcom/baidu/tieba/uq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948219571, "Lcom/baidu/tieba/uq2;");
                return;
            }
        }
        g = ho1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || zh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        ai3 ai3Var = this.f;
        if (ai3Var == null) {
            return;
        }
        ai3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq2(vg4 vg4Var, pf4 pf4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg4Var, pf4Var};
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
        this.d = vg4Var;
        this.e = pf4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || zh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            ai3 ai3Var = new ai3(str);
            this.f = ai3Var;
            ai3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.vq2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                x42.k("SwanExtractor", "#onInstallFaild del: " + string);
                bo4.M(string);
            }
        }
    }

    public final void k() {
        vg4 vg4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (vg4Var = this.d) != null && vg4Var.h == 0 && !tq2.w()) {
            tq2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.vq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ct2 ct2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ct2Var = ct2.d(string);
                dt2.b e = ct2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ct2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (ct2Var != null && g) {
                ct2Var.g("SwanExtractor", "done: " + l);
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
            qj3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            x42.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                ct2 d = ct2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        pf4 pf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (pf4Var = this.e) != null) {
            pf4Var.n(str, str2);
        }
    }

    public final qj3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        wq2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ct2 d = ct2.d(str);
            vg4 vg4Var = this.d;
            if (vg4Var == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(11L);
                qj3Var.i(2320L);
                qj3Var.f("pkg info is empty");
                uj3.a().f(qj3Var);
                return qj3Var;
            }
            int i3 = vg4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                fp1 g2 = fr2.g();
                vg4 vg4Var2 = this.d;
                i = g2.a(vg4Var2.g, String.valueOf(vg4Var2.i));
            } else if (i3 == 0) {
                i = tq2.e.i(vg4Var.g, String.valueOf(vg4Var.i));
            } else {
                qj3 qj3Var2 = new qj3();
                qj3Var2.k(11L);
                qj3Var2.i(2320L);
                qj3Var2.f("pkh category illegal");
                uj3.a().f(qj3Var2);
                return qj3Var2;
            }
            if (i == null) {
                qj3 qj3Var3 = new qj3();
                qj3Var3.k(11L);
                qj3Var3.i(2320L);
                qj3Var3.f("获取解压目录失败");
                uj3.a().f(qj3Var3);
                return qj3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                qj3 qj3Var4 = new qj3();
                qj3Var4.k(11L);
                qj3Var4.i(2320L);
                qj3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                uj3.a().f(qj3Var4);
                return qj3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        rk3.k(new a(this), "doFallbackIfNeeded");
                        qj3 qj3Var5 = new qj3();
                        qj3Var5.k(11L);
                        qj3Var5.i(2320L);
                        qj3Var5.f("解压失败：解压文件夹创建失败");
                        uj3.a().f(qj3Var5);
                        return qj3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    wq2.c i4 = wq2.i(bufferedInputStream);
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
                        bVar = wq2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = eo4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        wq2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        tf4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    qj3 qj3Var6 = new qj3();
                    qj3Var6.k(11L);
                    if (z) {
                        qj3Var6.i(2330L);
                        qj3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        qj3Var6.i(2320L);
                        qj3Var6.f("unzip failed");
                    }
                    uj3.a().f(qj3Var6);
                    return qj3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    qj3 qj3Var7 = new qj3();
                    qj3Var7.k(11L);
                    qj3Var7.i(2320L);
                    qj3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    uj3.a().f(qj3Var7);
                    return qj3Var7;
                }
            }
        }
        return (qj3) invokeLL.objValue;
    }
}
