package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jl4<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final jo4 g;
    public transient /* synthetic */ FieldHolder $fh;
    public il4 a;
    public T b;
    public File c;
    public AtomicBoolean d;
    public gl4<T> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947887127, "Lcom/baidu/tieba/jl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947887127, "Lcom/baidu/tieba/jl4;");
                return;
            }
        }
        g = jo4.e();
    }

    public yi4<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (yi4) invokeV.objValue;
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new vk4().a(this.e.k()).intValue();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            gl4<T> gl4Var = this.e;
            if (gl4Var != null) {
                return gl4Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return Objects.hash(this.a.b);
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.b.e;
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.a(this.b);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(3);
            this.e.e(this.b, this.a.a);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(10);
            this.e.i(this.b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f = true;
            s(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(1);
            this.e.c(this.b);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(2);
            this.e.j(this.b);
        }
    }

    public jl4(il4 il4Var, T t, gl4<T> gl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {il4Var, t, gl4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new AtomicBoolean(false);
        this.a = il4Var;
        this.b = t;
        this.e = gl4Var;
    }

    public final void a(int i, fk4 fk4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, fk4Var) != null) || fk4Var == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", fk4Var.toString());
            } catch (JSONException e) {
                g.g("PMSDownloadTask", "#addStatistic json put data出错", e);
            }
        }
        if (fk4Var instanceof gk4) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, fk4Var.g);
        }
        ho4.a(fk4Var.h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            fk4 fk4Var = this.a.b;
            if (fk4Var.e == i) {
                return false;
            }
            fk4Var.e = i;
            if (i != 2 && i != 3 && i != 10) {
                s(false);
            } else {
                s(true);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean d(jl4<T> jl4Var) {
        InterceptResult invokeL;
        il4 il4Var;
        fk4 fk4Var;
        il4 il4Var2;
        fk4 fk4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jl4Var)) == null) {
            if (jl4Var == null || (il4Var = jl4Var.a) == null || (fk4Var = il4Var.b) == null || (il4Var2 = this.a) == null || (fk4Var2 = il4Var2.b) == null || !fk4Var2.equals(fk4Var)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof jl4)) {
                return false;
            }
            return d((jl4) obj);
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.a.b.b = 0L;
            }
            b(0);
            s(false);
            this.f = false;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && this.d.get() != z) {
            this.d.set(z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.a.b.a)) {
                g.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c = no4.c(this.e.d(this.b), this.a.b.l);
            this.c = c;
            if (c == null) {
                String absolutePath = zh4.b().getAppContext().getCacheDir().getAbsolutePath();
                jo4 jo4Var = g;
                jo4Var.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.c = no4.c(absolutePath, this.a.b.l);
            }
            File file = this.c;
            if (file == null) {
                g.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.e.e(this.b, new bk4(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.a.b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            String d = this.e.d(this.b);
            if (d == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d);
                if (Build.VERSION.SDK_INT >= 18) {
                    if (statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() <= j) {
                        return false;
                    }
                    return true;
                } else if (statFs.getBlockSize() * statFs.getAvailableBlocks() <= j) {
                    return false;
                } else {
                    return true;
                }
            } catch (Throwable th) {
                g.g("PMSDownloadTask", "#hasSpaceToWrite 异常或者磁盘空间不足", th);
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            String fk4Var = this.a.b.toString();
            g.i("PMSDownloadTask", "#run 开始下包 pkg=" + fk4Var);
            nl4 nl4Var = new nl4(this, h());
            while (true) {
                bk4 bk4Var = this.a.a;
                if (bk4Var != null && bk4Var.a == 2200) {
                    return;
                }
                if (this.d.get()) {
                    g.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + fk4Var);
                    q();
                    return;
                }
                nl4Var.b();
                bk4 bk4Var2 = this.a.a;
                if (bk4Var2 != null) {
                    if (bk4Var2.a != 2200) {
                        if (this.d.get()) {
                            g.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + fk4Var);
                            q();
                            return;
                        }
                        this.e.b++;
                        g.i("PMSDownloadTask", "#run 下载出错 pkg=" + fk4Var + " retryCount=" + this.e.b);
                        if (this.e.b < 3) {
                            try {
                                if (!this.d.get()) {
                                    Thread.sleep(this.e.b * 1000);
                                }
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            m();
                            il4 il4Var = this.a;
                            a(il4Var.a.a, il4Var.b);
                            return;
                        }
                    } else {
                        g.i("PMSDownloadTask", "#run 下包成功 pkg=" + fk4Var);
                        n();
                        return;
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "downloadUrl:" + this.a.b.n + ",versionName:" + this.a.b.j + ",versionCode:" + this.a.b.i + "md5:" + this.a.b.l + "bundleId:" + this.a.b.g;
        }
        return (String) invokeV.objValue;
    }
}
