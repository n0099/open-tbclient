package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cu2;
import com.baidu.tieba.sr2;
import com.baidu.tieba.ur2;
import com.baidu.tieba.vr2;
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
public class tr2 extends ur2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final uh4 d;
    public final og4 e;
    public zi3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr2 a;

        public a(tr2 tr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tr2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948190741, "Lcom/baidu/tieba/tr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948190741, "Lcom/baidu/tieba/tr2;");
                return;
            }
        }
        g = gp1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || yi3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        zi3 zi3Var = this.f;
        if (zi3Var == null) {
            return;
        }
        zi3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tr2(uh4 uh4Var, og4 og4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uh4Var, og4Var};
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
        this.d = uh4Var;
        this.e = og4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || yi3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            zi3 zi3Var = new zi3(str);
            this.f = zi3Var;
            zi3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.ur2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                w52.k("SwanExtractor", "#onInstallFaild del: " + string);
                ap4.M(string);
            }
        }
    }

    public final void k() {
        uh4 uh4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (uh4Var = this.d) != null && uh4Var.h == 0 && !sr2.w()) {
            sr2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.ur2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        bu2 bu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                bu2Var = bu2.d(string);
                cu2.b e = bu2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                bu2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (bu2Var != null && g) {
                bu2Var.g("SwanExtractor", "done: " + l);
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
            pk3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            w52.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                bu2 d = bu2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        og4 og4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (og4Var = this.e) != null) {
            og4Var.n(str, str2);
        }
    }

    public final pk3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        vr2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            bu2 d = bu2.d(str);
            uh4 uh4Var = this.d;
            if (uh4Var == null) {
                pk3 pk3Var = new pk3();
                pk3Var.k(11L);
                pk3Var.i(2320L);
                pk3Var.f("pkg info is empty");
                tk3.a().f(pk3Var);
                return pk3Var;
            }
            int i3 = uh4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                eq1 g2 = es2.g();
                uh4 uh4Var2 = this.d;
                i = g2.a(uh4Var2.g, String.valueOf(uh4Var2.i));
            } else if (i3 == 0) {
                i = sr2.e.i(uh4Var.g, String.valueOf(uh4Var.i));
            } else {
                pk3 pk3Var2 = new pk3();
                pk3Var2.k(11L);
                pk3Var2.i(2320L);
                pk3Var2.f("pkh category illegal");
                tk3.a().f(pk3Var2);
                return pk3Var2;
            }
            if (i == null) {
                pk3 pk3Var3 = new pk3();
                pk3Var3.k(11L);
                pk3Var3.i(2320L);
                pk3Var3.f("获取解压目录失败");
                tk3.a().f(pk3Var3);
                return pk3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                pk3 pk3Var4 = new pk3();
                pk3Var4.k(11L);
                pk3Var4.i(2320L);
                pk3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                tk3.a().f(pk3Var4);
                return pk3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        ql3.k(new a(this), "doFallbackIfNeeded");
                        pk3 pk3Var5 = new pk3();
                        pk3Var5.k(11L);
                        pk3Var5.i(2320L);
                        pk3Var5.f("解压失败：解压文件夹创建失败");
                        tk3.a().f(pk3Var5);
                        return pk3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    vr2.c i4 = vr2.i(bufferedInputStream);
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
                        bVar = vr2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = dp4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        vr2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        sg4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    pk3 pk3Var6 = new pk3();
                    pk3Var6.k(11L);
                    if (z) {
                        pk3Var6.i(2330L);
                        pk3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        pk3Var6.i(2320L);
                        pk3Var6.f("unzip failed");
                    }
                    tk3.a().f(pk3Var6);
                    return pk3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    pk3 pk3Var7 = new pk3();
                    pk3Var7.k(11L);
                    pk3Var7.i(2320L);
                    pk3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    tk3.a().f(pk3Var7);
                    return pk3Var7;
                }
            }
        }
        return (pk3) invokeLL.objValue;
    }
}
