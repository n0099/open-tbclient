package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.av2;
import com.baidu.tieba.bv2;
import com.baidu.tieba.ix2;
import com.baidu.tieba.yu2;
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
public class zu2 extends av2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final al4 d;
    public final uj4 e;
    public fm3 f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu2 a;

        public a(zu2 zu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zu2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948372370, "Lcom/baidu/tieba/zu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948372370, "Lcom/baidu/tieba/zu2;");
                return;
            }
        }
        g = ms1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || em3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        fm3 fm3Var = this.f;
        if (fm3Var == null) {
            return;
        }
        fm3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zu2(al4 al4Var, uj4 uj4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {al4Var, uj4Var};
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
        this.d = al4Var;
        this.e = uj4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || em3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            fm3 fm3Var = new fm3(str);
            this.f = fm3Var;
            fm3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.av2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                c92.k("SwanExtractor", "#onInstallFaild del: " + string);
                gs4.M(string);
            }
        }
    }

    public final void k() {
        al4 al4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (al4Var = this.d) != null && al4Var.h == 0 && !yu2.w()) {
            yu2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.av2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        hx2 hx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                hx2Var = hx2.d(string);
                ix2.b e = hx2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                hx2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (hx2Var != null && g) {
                hx2Var.g("SwanExtractor", "done: " + l);
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
            vn3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            c92.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                hx2 d = hx2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        uj4 uj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (uj4Var = this.e) != null) {
            uj4Var.n(str, str2);
        }
    }

    public final vn3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        bv2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            hx2 d = hx2.d(str);
            al4 al4Var = this.d;
            if (al4Var == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(11L);
                vn3Var.i(2320L);
                vn3Var.f("pkg info is empty");
                zn3.a().f(vn3Var);
                return vn3Var;
            }
            int i3 = al4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                kt1 g2 = kv2.g();
                al4 al4Var2 = this.d;
                i = g2.a(al4Var2.g, String.valueOf(al4Var2.i));
            } else if (i3 == 0) {
                i = yu2.e.i(al4Var.g, String.valueOf(al4Var.i));
            } else {
                vn3 vn3Var2 = new vn3();
                vn3Var2.k(11L);
                vn3Var2.i(2320L);
                vn3Var2.f("pkh category illegal");
                zn3.a().f(vn3Var2);
                return vn3Var2;
            }
            if (i == null) {
                vn3 vn3Var3 = new vn3();
                vn3Var3.k(11L);
                vn3Var3.i(2320L);
                vn3Var3.f("获取解压目录失败");
                zn3.a().f(vn3Var3);
                return vn3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                vn3 vn3Var4 = new vn3();
                vn3Var4.k(11L);
                vn3Var4.i(2320L);
                vn3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                zn3.a().f(vn3Var4);
                return vn3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        wo3.k(new a(this), "doFallbackIfNeeded");
                        vn3 vn3Var5 = new vn3();
                        vn3Var5.k(11L);
                        vn3Var5.i(2320L);
                        vn3Var5.f("解压失败：解压文件夹创建失败");
                        zn3.a().f(vn3Var5);
                        return vn3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    bv2.c i4 = bv2.i(bufferedInputStream);
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
                        bVar = bv2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = js4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        bv2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        yj4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    vn3 vn3Var6 = new vn3();
                    vn3Var6.k(11L);
                    if (z) {
                        vn3Var6.i(2330L);
                        vn3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        vn3Var6.i(2320L);
                        vn3Var6.f("unzip failed");
                    }
                    zn3.a().f(vn3Var6);
                    return vn3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    vn3 vn3Var7 = new vn3();
                    vn3Var7.k(11L);
                    vn3Var7.i(2320L);
                    vn3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    zn3.a().f(vn3Var7);
                    return vn3Var7;
                }
            }
        }
        return (vn3) invokeLL.objValue;
    }
}
