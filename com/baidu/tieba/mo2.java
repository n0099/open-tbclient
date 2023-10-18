package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lo2;
import com.baidu.tieba.no2;
import com.baidu.tieba.oo2;
import com.baidu.tieba.vq2;
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
public class mo2 extends no2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final ne4 d;
    public final hd4 e;
    public sf3 f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo2 a;

        public a(mo2 mo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mo2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979321, "Lcom/baidu/tieba/mo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979321, "Lcom/baidu/tieba/mo2;");
                return;
            }
        }
        g = am1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || rf3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        sf3 sf3Var = this.f;
        if (sf3Var == null) {
            return;
        }
        sf3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mo2(ne4 ne4Var, hd4 hd4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ne4Var, hd4Var};
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
        this.d = ne4Var;
        this.e = hd4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || rf3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            sf3 sf3Var = new sf3(str);
            this.f = sf3Var;
            sf3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.no2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                p22.k("SwanExtractor", "#onInstallFaild del: " + string);
                sl4.M(string);
            }
        }
    }

    public final void k() {
        ne4 ne4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ne4Var = this.d) != null && ne4Var.h == 0 && !lo2.w()) {
            lo2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.no2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        uq2 uq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                uq2Var = uq2.d(string);
                vq2.b e = uq2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                uq2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (uq2Var != null && g) {
                uq2Var.g("SwanExtractor", "done: " + l);
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
            ih3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            p22.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                uq2 d = uq2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        hd4 hd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (hd4Var = this.e) != null) {
            hd4Var.n(str, str2);
        }
    }

    public final ih3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        oo2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            uq2 d = uq2.d(str);
            ne4 ne4Var = this.d;
            if (ne4Var == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(11L);
                ih3Var.i(2320L);
                ih3Var.f("pkg info is empty");
                mh3.a().f(ih3Var);
                return ih3Var;
            }
            int i3 = ne4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                ym1 g2 = xo2.g();
                ne4 ne4Var2 = this.d;
                i = g2.a(ne4Var2.g, String.valueOf(ne4Var2.i));
            } else if (i3 == 0) {
                i = lo2.e.i(ne4Var.g, String.valueOf(ne4Var.i));
            } else {
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(11L);
                ih3Var2.i(2320L);
                ih3Var2.f("pkh category illegal");
                mh3.a().f(ih3Var2);
                return ih3Var2;
            }
            if (i == null) {
                ih3 ih3Var3 = new ih3();
                ih3Var3.k(11L);
                ih3Var3.i(2320L);
                ih3Var3.f("获取解压目录失败");
                mh3.a().f(ih3Var3);
                return ih3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                ih3 ih3Var4 = new ih3();
                ih3Var4.k(11L);
                ih3Var4.i(2320L);
                ih3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                mh3.a().f(ih3Var4);
                return ih3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        ji3.k(new a(this), "doFallbackIfNeeded");
                        ih3 ih3Var5 = new ih3();
                        ih3Var5.k(11L);
                        ih3Var5.i(2320L);
                        ih3Var5.f("解压失败：解压文件夹创建失败");
                        mh3.a().f(ih3Var5);
                        return ih3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    oo2.c i4 = oo2.i(bufferedInputStream);
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
                        bVar = oo2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = vl4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        oo2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        ld4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    ih3 ih3Var6 = new ih3();
                    ih3Var6.k(11L);
                    if (z) {
                        ih3Var6.i(2330L);
                        ih3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        ih3Var6.i(2320L);
                        ih3Var6.f("unzip failed");
                    }
                    mh3.a().f(ih3Var6);
                    return ih3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    ih3 ih3Var7 = new ih3();
                    ih3Var7.k(11L);
                    ih3Var7.i(2320L);
                    ih3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    mh3.a().f(ih3Var7);
                    return ih3Var7;
                }
            }
        }
        return (ih3) invokeLL.objValue;
    }
}
