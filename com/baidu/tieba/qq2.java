package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pq2;
import com.baidu.tieba.rq2;
import com.baidu.tieba.sq2;
import com.baidu.tieba.zs2;
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
public class qq2 extends rq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final rg4 d;
    public final lf4 e;
    public wh3 f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qq2 a;

        public a(qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qq2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100407, "Lcom/baidu/tieba/qq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100407, "Lcom/baidu/tieba/qq2;");
                return;
            }
        }
        g = do1.a;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || vh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "stopUnzipFileObserver: ");
        }
        wh3 wh3Var = this.f;
        if (wh3Var == null) {
            return;
        }
        wh3Var.stopWatching();
        this.f = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qq2(rg4 rg4Var, lf4 lf4Var) {
        super("extract");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rg4Var, lf4Var};
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
        this.d = rg4Var;
        this.e = lf4Var;
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
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || vh3.c() <= 0) {
            return;
        }
        if (g) {
            Log.i("SwanExtractor", "startUnzipFileObserver: ");
        }
        if (this.f == null) {
            wh3 wh3Var = new wh3(str);
            this.f = wh3Var;
            wh3Var.startWatching();
        }
    }

    @Override // com.baidu.tieba.rq2.f
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            if (c().getBoolean("result_output_dir_allow_rollback", false)) {
                String string = c().getString("result_output_dir");
                t42.k("SwanExtractor", "#onInstallFaild del: " + string);
                xn4.M(string);
            }
        }
    }

    public final void k() {
        rg4 rg4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (rg4Var = this.d) != null && rg4Var.h == 0 && !pq2.w()) {
            pq2.e(this.d.g + File.separator + this.d.i);
        }
    }

    @Override // com.baidu.tieba.rq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ys2 ys2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sourceChannel, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (g) {
                ys2Var = ys2.d(string);
                zs2.b e = ys2Var.e();
                e.b("SwanExtractor");
                e.d(1);
            } else {
                ys2Var = null;
            }
            boolean l = l(Channels.newInputStream(sourceChannel), string);
            if (ys2Var != null && g) {
                ys2Var.g("SwanExtractor", "done: " + l);
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
            mj3 r = r(new BufferedInputStream(inputStream), str);
            if (r == null) {
                return true;
            }
            t42.k("SwanExtractor", "#extract error=" + r);
            if (g) {
                ys2 d = ys2.d(str);
                d.g("SwanExtractor", "onProcess installe error=" + r);
            }
            c().putLong("result_error_code", r.a());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(String str, String str2) {
        lf4 lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && (lf4Var = this.e) != null) {
            lf4Var.n(str, str2);
        }
    }

    public final mj3 r(@NonNull BufferedInputStream bufferedInputStream, String str) {
        InterceptResult invokeLL;
        File i;
        int i2;
        boolean z;
        sq2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bufferedInputStream, str)) == null) {
            ys2 d = ys2.d(str);
            rg4 rg4Var = this.d;
            if (rg4Var == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(11L);
                mj3Var.i(2320L);
                mj3Var.f("pkg info is empty");
                qj3.a().f(mj3Var);
                return mj3Var;
            }
            int i3 = rg4Var.h;
            boolean z2 = true;
            if (i3 == 1) {
                bp1 g2 = br2.g();
                rg4 rg4Var2 = this.d;
                i = g2.a(rg4Var2.g, String.valueOf(rg4Var2.i));
            } else if (i3 == 0) {
                i = pq2.e.i(rg4Var.g, String.valueOf(rg4Var.i));
            } else {
                mj3 mj3Var2 = new mj3();
                mj3Var2.k(11L);
                mj3Var2.i(2320L);
                mj3Var2.f("pkh category illegal");
                qj3.a().f(mj3Var2);
                return mj3Var2;
            }
            if (i == null) {
                mj3 mj3Var3 = new mj3();
                mj3Var3.k(11L);
                mj3Var3.i(2320L);
                mj3Var3.f("获取解压目录失败");
                qj3.a().f(mj3Var3);
                return mj3Var3;
            } else if (i.isFile() && !i.delete()) {
                if (g) {
                    d.g("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
                }
                mj3 mj3Var4 = new mj3();
                mj3Var4.k(11L);
                mj3Var4.i(2320L);
                mj3Var4.f("解压失败：解压目录被文件占用，且无法删除");
                qj3.a().f(mj3Var4);
                return mj3Var4;
            } else {
                if (!i.exists()) {
                    c().putBoolean("result_output_dir_allow_rollback", true);
                    if (!i.mkdirs()) {
                        if (g) {
                            d.g("SwanExtractor", "解压失败：解压文件夹创建失败");
                        }
                        nk3.k(new a(this), "doFallbackIfNeeded");
                        mj3 mj3Var5 = new mj3();
                        mj3Var5.k(11L);
                        mj3Var5.i(2320L);
                        mj3Var5.f("解压失败：解压文件夹创建失败");
                        qj3.a().f(mj3Var5);
                        return mj3Var5;
                    }
                }
                o(i.getPath());
                if (g) {
                    d.g("SwanExtractor", "开始执行解压操作, folder:" + i.getPath());
                }
                c().putString("result_output_dir", i.toString());
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    sq2.c i4 = sq2.i(bufferedInputStream);
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
                        bVar = sq2.d(bufferedInputStream, i, i2);
                        if (bVar == null || !bVar.a) {
                            z2 = false;
                        }
                    } else {
                        z2 = ao4.d(bufferedInputStream, i.getPath());
                        bVar = null;
                        i2 = 0;
                    }
                    m(z);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (g) {
                        sq2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (this.e != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("download_package_type_id", i2);
                        pf4.a(this.e, bundle, "event_download_package_type");
                    }
                    p();
                    if (z2) {
                        return null;
                    }
                    mj3 mj3Var6 = new mj3();
                    mj3Var6.k(11L);
                    if (z) {
                        mj3Var6.i(2330L);
                        mj3Var6.f("decrypt failed:" + bVar.b);
                    } else {
                        mj3Var6.i(2320L);
                        mj3Var6.f("unzip failed");
                    }
                    qj3.a().f(mj3Var6);
                    return mj3Var6;
                } catch (IOException e) {
                    if (g) {
                        d.g("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                        e.printStackTrace();
                    }
                    mj3 mj3Var7 = new mj3();
                    mj3Var7.k(11L);
                    mj3Var7.i(2320L);
                    mj3Var7.f("obtainEncryptedBundle Exception: " + e.toString());
                    qj3.a().f(mj3Var7);
                    return mj3Var7;
                }
            }
        }
        return (mj3) invokeLL.objValue;
    }
}
