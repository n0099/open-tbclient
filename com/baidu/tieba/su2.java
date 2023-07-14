package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bx2;
import com.baidu.tieba.ru2;
import com.baidu.tieba.tu2;
import com.baidu.tieba.uu2;
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
/* loaded from: classes7.dex */
public class su2 extends tu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final tk4 d;
    public final nj4 e;
    public yl3 f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su2 a;

        public a(su2 su2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163833, "Lcom/baidu/tieba/su2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163833, "Lcom/baidu/tieba/su2;");
                return;
            }
        }
        g = fs1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || xl3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        yl3 yl3Var = this.f;
        if (yl3Var == null) {
            return;
        }
        yl3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su2(tk4 tk4Var, nj4 nj4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tk4Var, nj4Var};
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
        this.d = tk4Var;
        this.e = nj4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || xl3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            yl3 yl3Var = new yl3(str);
            this.f = yl3Var;
            yl3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.tu2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                v82.k("SwanExtractor", "#onInstallFaild del: " + string);
                zr4.M(string);
            }
        }
    }

    public final void k() {
        tk4 tk4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tk4Var = this.d) != null && tk4Var.h == 0 && !ru2.w()) {
            ru2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.tu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ax2 ax2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ax2Var = ax2.d(string);
                bx2.b e = ax2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ax2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (ax2Var != null && g) {
                ax2Var.g("SwanExtractor", "done: " + l);
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
            on3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            v82.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                ax2 d = ax2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        nj4 nj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (nj4Var = this.e) != null) {
            nj4Var.n(str, str2);
        }
    }

    public final on3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        uu2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ax2 d = ax2.d(str);
            tk4 tk4Var = this.d;
            if (tk4Var == null) {
                on3 on3Var = new on3();
                on3Var.k(11L);
                on3Var.i(2320L);
                on3Var.f("pkg info is empty");
                sn3.a().f(on3Var);
                return on3Var;
            }
            int i3 = tk4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                dt1 g2 = dv2.g();
                tk4 tk4Var2 = this.d;
                i = g2.a(tk4Var2.g, String.valueOf(tk4Var2.i));
            } else if (i3 == 0) {
                i = ru2.e.i(tk4Var.g, String.valueOf(tk4Var.i));
            } else {
                on3 on3Var2 = new on3();
                on3Var2.k(11L);
                on3Var2.i(2320L);
                on3Var2.f("pkh category illegal");
                sn3.a().f(on3Var2);
                return on3Var2;
            }
            if (i == null) {
                on3 on3Var3 = new on3();
                on3Var3.k(11L);
                on3Var3.i(2320L);
                on3Var3.f("获取解压目录失败");
                sn3.a().f(on3Var3);
                return on3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                on3 on3Var4 = new on3();
                on3Var4.k(11L);
                on3Var4.i(2320L);
                on3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                sn3.a().f(on3Var4);
                return on3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        po3.k(new a(this), "doFallbackIfNeeded");
                        on3 on3Var5 = new on3();
                        on3Var5.k(11L);
                        on3Var5.i(2320L);
                        on3Var5.f("解压失败：解压文件夹创建失败");
                        sn3.a().f(on3Var5);
                        return on3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    uu2.c i4 = uu2.i(bufferedInputStream);
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
                        bVar = uu2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = cs4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        uu2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        rj4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    on3 on3Var6 = new on3();
                    on3Var6.k(11L);
                    if (z) {
                        on3Var6.i(2330L);
                        on3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        on3Var6.i(2320L);
                        on3Var6.f("unzip failed");
                    }
                    sn3.a().f(on3Var6);
                    return on3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    on3 on3Var7 = new on3();
                    on3Var7.k(11L);
                    on3Var7.i(2320L);
                    on3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    sn3.a().f(on3Var7);
                    return on3Var7;
                }
            }
        }
        return (on3) invokeLL.objValue;
    }
}
