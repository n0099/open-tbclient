package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hm2;
import com.baidu.tieba.jm2;
import com.baidu.tieba.km2;
import com.baidu.tieba.ro2;
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
public class im2 extends jm2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final jc4 d;
    public final db4 e;
    public od3 f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im2 a;

        public a(im2 im2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947858235, "Lcom/baidu/tieba/im2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947858235, "Lcom/baidu/tieba/im2;");
                return;
            }
        }
        g = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im2(jc4 jc4Var, db4 db4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jc4Var, db4Var};
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
        this.d = jc4Var;
        this.e = db4Var;
    }

    @Override // com.baidu.tieba.jm2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                l02.k("SwanExtractor", "#onInstallFaild del: " + string);
                pj4.M(string);
            }
        }
    }

    @Override // com.baidu.tieba.jm2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        qo2 qo2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                qo2Var = qo2.d(string);
                ro2.b e = qo2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                qo2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (qo2Var != null && g) {
                qo2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final void k() {
        jc4 jc4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jc4Var = this.d) == null || jc4Var.h != 0 || hm2.w()) {
            return;
        }
        hm2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            ef3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            l02.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                qo2 d = qo2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || nd3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            od3 od3Var = new od3(str);
            this.f = od3Var;
            od3Var.startWatching();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || nd3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        od3 od3Var = this.f;
        if (od3Var == null) {
            return;
        }
        od3Var.stopWatching();
        this.f = null;
    }

    public final void q(String str, String str2) {
        db4 db4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (db4Var = this.e) == null) {
            return;
        }
        db4Var.n(str, str2);
    }

    public final ef3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        km2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            qo2 d = qo2.d(str);
            jc4 jc4Var = this.d;
            if (jc4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(11L);
                ef3Var.i(2320L);
                ef3Var.f("pkg info is empty");
                if3.a().f(ef3Var);
                return ef3Var;
            }
            int i2 = jc4Var.h;
            boolean z = true;
            if (i2 == 1) {
                tk1 g2 = tm2.g();
                jc4 jc4Var2 = this.d;
                i = g2.a(jc4Var2.g, String.valueOf(jc4Var2.i));
            } else if (i2 == 0) {
                i = hm2.e.i(jc4Var.g, String.valueOf(jc4Var.i));
            } else {
                ef3 ef3Var2 = new ef3();
                ef3Var2.k(11L);
                ef3Var2.i(2320L);
                ef3Var2.f("pkh category illegal");
                if3.a().f(ef3Var2);
                return ef3Var2;
            }
            if (i == null) {
                ef3 ef3Var3 = new ef3();
                ef3Var3.k(11L);
                ef3Var3.i(2320L);
                ef3Var3.f("获取解压目录失败");
                if3.a().f(ef3Var3);
                return ef3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                ef3 ef3Var4 = new ef3();
                ef3Var4.k(11L);
                ef3Var4.i(2320L);
                ef3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                if3.a().f(ef3Var4);
                return ef3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        fg3.k(new a(this), "doFallbackIfNeeded");
                        ef3 ef3Var5 = new ef3();
                        ef3Var5.k(11L);
                        ef3Var5.i(2320L);
                        ef3Var5.f("解压失败：解压文件夹创建失败");
                        if3.a().f(ef3Var5);
                        return ef3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    km2.c i3 = km2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    n(z2);
                    if (z2) {
                        bVar = km2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = sj4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    m(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        km2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        hb4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z) {
                        return null;
                    }
                    ef3 ef3Var6 = new ef3();
                    ef3Var6.k(11L);
                    if (z2) {
                        ef3Var6.i(2330L);
                        ef3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        ef3Var6.i(2320L);
                        ef3Var6.f("unzip failed");
                    }
                    if3.a().f(ef3Var6);
                    return ef3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    ef3 ef3Var7 = new ef3();
                    ef3Var7.k(11L);
                    ef3Var7.i(2320L);
                    ef3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    if3.a().f(ef3Var7);
                    return ef3Var7;
                }
            }
        }
        return (ef3) invokeLL.objValue;
    }
}
