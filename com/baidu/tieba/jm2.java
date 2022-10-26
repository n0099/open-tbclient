package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im2;
import com.baidu.tieba.km2;
import com.baidu.tieba.lm2;
import com.baidu.tieba.so2;
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
/* loaded from: classes4.dex */
public class jm2 extends km2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final kc4 d;
    public final eb4 e;
    public pd3 f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm2 a;

        public a(jm2 jm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947888026, "Lcom/baidu/tieba/jm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947888026, "Lcom/baidu/tieba/jm2;");
                return;
            }
        }
        g = wj1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || od3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        pd3 pd3Var = this.f;
        if (pd3Var == null) {
            return;
        }
        pd3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jm2(kc4 kc4Var, eb4 eb4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kc4Var, eb4Var};
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
        this.d = kc4Var;
        this.e = eb4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || od3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            pd3 pd3Var = new pd3(str);
            this.f = pd3Var;
            pd3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.km2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                m02.k("SwanExtractor", "#onInstallFaild del: " + string);
                qj4.M(string);
            }
        }
    }

    public final void k() {
        kc4 kc4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (kc4Var = this.d) != null && kc4Var.h == 0 && !im2.w()) {
            im2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.km2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ro2 ro2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ro2Var = ro2.d(string);
                so2.b e = ro2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ro2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (ro2Var != null && g) {
                ro2Var.g("SwanExtractor", "done: " + l);
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
            ff3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            m02.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                ro2 d = ro2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        eb4 eb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (eb4Var = this.e) != null) {
            eb4Var.n(str, str2);
        }
    }

    public final ff3 r(BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        lm2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ro2 d = ro2.d(str);
            kc4 kc4Var = this.d;
            if (kc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(11L);
                ff3Var.i(2320L);
                ff3Var.f("pkg info is empty");
                jf3.a().f(ff3Var);
                return ff3Var;
            }
            int i3 = kc4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                uk1 g2 = um2.g();
                kc4 kc4Var2 = this.d;
                i = g2.a(kc4Var2.g, String.valueOf(kc4Var2.i));
            } else if (i3 == 0) {
                i = im2.e.i(kc4Var.g, String.valueOf(kc4Var.i));
            } else {
                ff3 ff3Var2 = new ff3();
                ff3Var2.k(11L);
                ff3Var2.i(2320L);
                ff3Var2.f("pkh category illegal");
                jf3.a().f(ff3Var2);
                return ff3Var2;
            }
            if (i == null) {
                ff3 ff3Var3 = new ff3();
                ff3Var3.k(11L);
                ff3Var3.i(2320L);
                ff3Var3.f("获取解压目录失败");
                jf3.a().f(ff3Var3);
                return ff3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                ff3 ff3Var4 = new ff3();
                ff3Var4.k(11L);
                ff3Var4.i(2320L);
                ff3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                jf3.a().f(ff3Var4);
                return ff3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        gg3.k(new a(this), "doFallbackIfNeeded");
                        ff3 ff3Var5 = new ff3();
                        ff3Var5.k(11L);
                        ff3Var5.i(2320L);
                        ff3Var5.f("解压失败：解压文件夹创建失败");
                        jf3.a().f(ff3Var5);
                        return ff3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    lm2.c i4 = lm2.i(bufferedInputStream);
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
                        bVar = lm2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = tj4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        lm2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        ib4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    ff3 ff3Var6 = new ff3();
                    ff3Var6.k(11L);
                    if (z) {
                        ff3Var6.i(2330L);
                        ff3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        ff3Var6.i(2320L);
                        ff3Var6.f("unzip failed");
                    }
                    jf3.a().f(ff3Var6);
                    return ff3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    ff3 ff3Var7 = new ff3();
                    ff3Var7.k(11L);
                    ff3Var7.i(2320L);
                    ff3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    jf3.a().f(ff3Var7);
                    return ff3Var7;
                }
            }
        }
        return (ff3) invokeLL.objValue;
    }
}
