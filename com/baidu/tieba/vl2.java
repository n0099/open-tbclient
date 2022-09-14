package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eo2;
import com.baidu.tieba.ul2;
import com.baidu.tieba.wl2;
import com.baidu.tieba.xl2;
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
public class vl2 extends wl2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final wb4 d;
    public final qa4 e;
    public bd3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl2 a;

        public a(vl2 vl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244557, "Lcom/baidu/tieba/vl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244557, "Lcom/baidu/tieba/vl2;");
                return;
            }
        }
        g = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl2(wb4 wb4Var, qa4 qa4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wb4Var, qa4Var};
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
        this.d = wb4Var;
        this.e = qa4Var;
    }

    @Override // com.baidu.tieba.wl2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                yz1.k("SwanExtractor", "#onInstallFaild del: " + string);
                cj4.M(string);
            }
        }
    }

    @Override // com.baidu.tieba.wl2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        do2 do2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                do2Var = do2.d(string);
                eo2.b e = do2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                do2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (do2Var != null && g) {
                do2Var.g("SwanExtractor", "done: " + l);
            }
            return l;
        }
        return invokeLL.booleanValue;
    }

    public final void k() {
        wb4 wb4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (wb4Var = this.d) == null || wb4Var.h != 0 || ul2.w()) {
            return;
        }
        ul2.e(this.d.g + File.separator + this.d.i);
    }

    public final boolean l(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, str)) == null) {
            if (inputStream == null) {
                return false;
            }
            re3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            yz1.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                do2 d = do2.d(str);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || ad3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            bd3 bd3Var = new bd3(str);
            this.f = bd3Var;
            bd3Var.startWatching();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ad3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        bd3 bd3Var = this.f;
        if (bd3Var == null) {
            return;
        }
        bd3Var.stopWatching();
        this.f = null;
    }

    public final void q(String str, String str2) {
        qa4 qa4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || (qa4Var = this.e) == null) {
            return;
        }
        qa4Var.n(str, str2);
    }

    public final re3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        xl2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            do2 d = do2.d(str);
            wb4 wb4Var = this.d;
            if (wb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(11L);
                re3Var.i(2320L);
                re3Var.f("pkg info is empty");
                ve3.a().f(re3Var);
                return re3Var;
            }
            int i2 = wb4Var.h;
            boolean z = true;
            if (i2 == 1) {
                gk1 g2 = gm2.g();
                wb4 wb4Var2 = this.d;
                i = g2.a(wb4Var2.g, String.valueOf(wb4Var2.i));
            } else if (i2 == 0) {
                i = ul2.e.i(wb4Var.g, String.valueOf(wb4Var.i));
            } else {
                re3 re3Var2 = new re3();
                re3Var2.k(11L);
                re3Var2.i(2320L);
                re3Var2.f("pkh category illegal");
                ve3.a().f(re3Var2);
                return re3Var2;
            }
            if (i == null) {
                re3 re3Var3 = new re3();
                re3Var3.k(11L);
                re3Var3.i(2320L);
                re3Var3.f("获取解压目录失败");
                ve3.a().f(re3Var3);
                return re3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                re3 re3Var4 = new re3();
                re3Var4.k(11L);
                re3Var4.i(2320L);
                re3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                ve3.a().f(re3Var4);
                return re3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        sf3.k(new a(this), "doFallbackIfNeeded");
                        re3 re3Var5 = new re3();
                        re3Var5.k(11L);
                        re3Var5.i(2320L);
                        re3Var5.f("解压失败：解压文件夹创建失败");
                        ve3.a().f(re3Var5);
                        return re3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    xl2.c i3 = xl2.i(bufferedInputStream);
                    int i4 = i3 == null ? -1 : i3.b;
                    boolean z2 = i4 != -1;
                    n(z2);
                    if (z2) {
                        bVar = xl2.d(bufferedInputStream, i, i4);
                        if (bVar == null || !bVar.a) {
                            z = false;
                        }
                    } else {
                        z = fj4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i4 = 0;
                    }
                    m(z2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        xl2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i4);
                        ua4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z) {
                        return null;
                    }
                    re3 re3Var6 = new re3();
                    re3Var6.k(11L);
                    if (z2) {
                        re3Var6.i(2330L);
                        re3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        re3Var6.i(2320L);
                        re3Var6.f("unzip failed");
                    }
                    ve3.a().f(re3Var6);
                    return re3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    re3 re3Var7 = new re3();
                    re3Var7.k(11L);
                    re3Var7.i(2320L);
                    re3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    ve3.a().f(re3Var7);
                    return re3Var7;
                }
            }
        }
        return (re3) invokeLL.objValue;
    }
}
