package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.at2;
import com.baidu.tieba.qq2;
import com.baidu.tieba.sq2;
import com.baidu.tieba.tq2;
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
public class rq2 extends sq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final sg4 d;
    public final mf4 e;
    public xh3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq2 a;

        public a(rq2 rq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948130198, "Lcom/baidu/tieba/rq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948130198, "Lcom/baidu/tieba/rq2;");
                return;
            }
        }
        g = eo1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || wh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        xh3 xh3Var = this.f;
        if (xh3Var == null) {
            return;
        }
        xh3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq2(sg4 sg4Var, mf4 mf4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sg4Var, mf4Var};
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
        this.d = sg4Var;
        this.e = mf4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || wh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            xh3 xh3Var = new xh3(str);
            this.f = xh3Var;
            xh3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.sq2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                u42.k("SwanExtractor", "#onInstallFaild del: " + string);
                yn4.M(string);
            }
        }
    }

    public final void k() {
        sg4 sg4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (sg4Var = this.d) != null && sg4Var.h == 0 && !qq2.w()) {
            qq2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.sq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        zs2 zs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                zs2Var = zs2.d(string);
                at2.b e = zs2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                zs2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (zs2Var != null && g) {
                zs2Var.g("SwanExtractor", "done: " + l);
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
            nj3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            u42.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                zs2 d = zs2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        mf4 mf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (mf4Var = this.e) != null) {
            mf4Var.n(str, str2);
        }
    }

    public final nj3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        tq2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            zs2 d = zs2.d(str);
            sg4 sg4Var = this.d;
            if (sg4Var == null) {
                nj3 nj3Var = new nj3();
                nj3Var.k(11L);
                nj3Var.i(2320L);
                nj3Var.f("pkg info is empty");
                rj3.a().f(nj3Var);
                return nj3Var;
            }
            int i3 = sg4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                cp1 g2 = cr2.g();
                sg4 sg4Var2 = this.d;
                i = g2.a(sg4Var2.g, String.valueOf(sg4Var2.i));
            } else if (i3 == 0) {
                i = qq2.e.i(sg4Var.g, String.valueOf(sg4Var.i));
            } else {
                nj3 nj3Var2 = new nj3();
                nj3Var2.k(11L);
                nj3Var2.i(2320L);
                nj3Var2.f("pkh category illegal");
                rj3.a().f(nj3Var2);
                return nj3Var2;
            }
            if (i == null) {
                nj3 nj3Var3 = new nj3();
                nj3Var3.k(11L);
                nj3Var3.i(2320L);
                nj3Var3.f("获取解压目录失败");
                rj3.a().f(nj3Var3);
                return nj3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                nj3 nj3Var4 = new nj3();
                nj3Var4.k(11L);
                nj3Var4.i(2320L);
                nj3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                rj3.a().f(nj3Var4);
                return nj3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        ok3.k(new a(this), "doFallbackIfNeeded");
                        nj3 nj3Var5 = new nj3();
                        nj3Var5.k(11L);
                        nj3Var5.i(2320L);
                        nj3Var5.f("解压失败：解压文件夹创建失败");
                        rj3.a().f(nj3Var5);
                        return nj3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    tq2.c i4 = tq2.i(bufferedInputStream);
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
                        bVar = tq2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = bo4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        tq2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        qf4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    nj3 nj3Var6 = new nj3();
                    nj3Var6.k(11L);
                    if (z) {
                        nj3Var6.i(2330L);
                        nj3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        nj3Var6.i(2320L);
                        nj3Var6.f("unzip failed");
                    }
                    rj3.a().f(nj3Var6);
                    return nj3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    nj3 nj3Var7 = new nj3();
                    nj3Var7.k(11L);
                    nj3Var7.i(2320L);
                    nj3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    rj3.a().f(nj3Var7);
                    return nj3Var7;
                }
            }
        }
        return (nj3) invokeLL.objValue;
    }
}
