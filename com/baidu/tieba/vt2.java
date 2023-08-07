package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ew2;
import com.baidu.tieba.ut2;
import com.baidu.tieba.wt2;
import com.baidu.tieba.xt2;
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
public class vt2 extends wt2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final wj4 d;
    public final qi4 e;
    public bl3 f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt2 a;

        public a(vt2 vt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948252245, "Lcom/baidu/tieba/vt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948252245, "Lcom/baidu/tieba/vt2;");
                return;
            }
        }
        g = ir1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || al3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        bl3 bl3Var = this.f;
        if (bl3Var == null) {
            return;
        }
        bl3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt2(wj4 wj4Var, qi4 qi4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wj4Var, qi4Var};
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
        this.d = wj4Var;
        this.e = qi4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || al3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            bl3 bl3Var = new bl3(str);
            this.f = bl3Var;
            bl3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.wt2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                y72.k("SwanExtractor", "#onInstallFaild del: " + string);
                cr4.M(string);
            }
        }
    }

    public final void k() {
        wj4 wj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (wj4Var = this.d) != null && wj4Var.h == 0 && !ut2.w()) {
            ut2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.wt2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        dw2 dw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                dw2Var = dw2.d(string);
                ew2.b e = dw2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                dw2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (dw2Var != null && g) {
                dw2Var.g("SwanExtractor", "done: " + l);
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
            rm3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            y72.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                dw2 d = dw2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        qi4 qi4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (qi4Var = this.e) != null) {
            qi4Var.n(str, str2);
        }
    }

    public final rm3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        xt2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            dw2 d = dw2.d(str);
            wj4 wj4Var = this.d;
            if (wj4Var == null) {
                rm3 rm3Var = new rm3();
                rm3Var.k(11L);
                rm3Var.i(2320L);
                rm3Var.f("pkg info is empty");
                vm3.a().f(rm3Var);
                return rm3Var;
            }
            int i3 = wj4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                gs1 g2 = gu2.g();
                wj4 wj4Var2 = this.d;
                i = g2.a(wj4Var2.g, String.valueOf(wj4Var2.i));
            } else if (i3 == 0) {
                i = ut2.e.i(wj4Var.g, String.valueOf(wj4Var.i));
            } else {
                rm3 rm3Var2 = new rm3();
                rm3Var2.k(11L);
                rm3Var2.i(2320L);
                rm3Var2.f("pkh category illegal");
                vm3.a().f(rm3Var2);
                return rm3Var2;
            }
            if (i == null) {
                rm3 rm3Var3 = new rm3();
                rm3Var3.k(11L);
                rm3Var3.i(2320L);
                rm3Var3.f("获取解压目录失败");
                vm3.a().f(rm3Var3);
                return rm3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                rm3 rm3Var4 = new rm3();
                rm3Var4.k(11L);
                rm3Var4.i(2320L);
                rm3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                vm3.a().f(rm3Var4);
                return rm3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        sn3.k(new a(this), "doFallbackIfNeeded");
                        rm3 rm3Var5 = new rm3();
                        rm3Var5.k(11L);
                        rm3Var5.i(2320L);
                        rm3Var5.f("解压失败：解压文件夹创建失败");
                        vm3.a().f(rm3Var5);
                        return rm3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    xt2.c i4 = xt2.i(bufferedInputStream);
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
                        bVar = xt2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = fr4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        xt2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        ui4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    rm3 rm3Var6 = new rm3();
                    rm3Var6.k(11L);
                    if (z) {
                        rm3Var6.i(2330L);
                        rm3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        rm3Var6.i(2320L);
                        rm3Var6.f("unzip failed");
                    }
                    vm3.a().f(rm3Var6);
                    return rm3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    rm3 rm3Var7 = new rm3();
                    rm3Var7.k(11L);
                    rm3Var7.i(2320L);
                    rm3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    vm3.a().f(rm3Var7);
                    return rm3Var7;
                }
            }
        }
        return (rm3) invokeLL.objValue;
    }
}
