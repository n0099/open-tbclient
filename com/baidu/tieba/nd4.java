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
/* loaded from: classes5.dex */
public class nd4<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ng4 g;
    public transient /* synthetic */ FieldHolder $fh;
    public md4 a;
    public T b;
    public File c;
    public AtomicBoolean d;
    public kd4<T> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947998603, "Lcom/baidu/tieba/nd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947998603, "Lcom/baidu/tieba/nd4;");
                return;
            }
        }
        g = ng4.e();
    }

    public nd4(md4 md4Var, T t, kd4<T> kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {md4Var, t, kd4Var};
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
        this.a = md4Var;
        this.b = t;
        this.e = kd4Var;
    }

    public final void a(int i, jc4 jc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, jc4Var) == null) || jc4Var == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", jc4Var.toString());
            } catch (JSONException e) {
                g.g("PMSDownloadTask", "#addStatistic json put data出错", e);
            }
        }
        if (jc4Var instanceof kc4) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, jc4Var.g);
        }
        lg4.a(jc4Var.h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            jc4 jc4Var = this.a.b;
            if (jc4Var.e != i) {
                jc4Var.e = i;
                if (i != 2 && i != 3 && i != 10) {
                    s(false);
                } else {
                    s(true);
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.a.b.a)) {
                g.i("PMSDownloadTask", "#checkAndCreateFile mParam.pmsPackage.filePath 为空");
                return true;
            }
            File c = rg4.c(this.e.d(this.b), this.a.b.l);
            this.c = c;
            if (c == null) {
                String absolutePath = da4.b().getAppContext().getCacheDir().getAbsolutePath();
                ng4 ng4Var = g;
                ng4Var.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.c = rg4.c(absolutePath, this.a.b.l);
            }
            File file = this.c;
            if (file == null) {
                g.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.e.e(this.b, new fc4(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                return false;
            }
            this.a.b.a = file.getAbsolutePath();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(nd4<T> nd4Var) {
        InterceptResult invokeL;
        md4 md4Var;
        jc4 jc4Var;
        md4 md4Var2;
        jc4 jc4Var2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nd4Var)) == null) ? (nd4Var == null || (md4Var = nd4Var.a) == null || (jc4Var = md4Var.b) == null || (md4Var2 = this.a) == null || (jc4Var2 = md4Var2.b) == null || !jc4Var2.equals(jc4Var)) ? false : true : invokeL.booleanValue;
    }

    public cb4<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (cb4) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof nd4)) {
                return d((nd4) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new zc4().a(this.e.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            kd4<T> kd4Var = this.e;
            if (kd4Var != null) {
                return kd4Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.a.b) : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.b.e : invokeV.intValue;
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
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
            } catch (Throwable th) {
                g.g("PMSDownloadTask", "#hasSpaceToWrite 异常或者磁盘空间不足", th);
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f : invokeV.booleanValue;
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

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        String jc4Var = this.a.b.toString();
        g.i("PMSDownloadTask", "#run 开始下包 pkg=" + jc4Var);
        rd4 rd4Var = new rd4(this, h());
        while (true) {
            fc4 fc4Var = this.a.a;
            if (fc4Var != null && fc4Var.a == 2200) {
                return;
            }
            if (this.d.get()) {
                g.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + jc4Var);
                q();
                return;
            }
            rd4Var.b();
            fc4 fc4Var2 = this.a.a;
            if (fc4Var2 != null) {
                if (fc4Var2.a != 2200) {
                    if (this.d.get()) {
                        g.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + jc4Var);
                        q();
                        return;
                    }
                    this.e.b++;
                    g.i("PMSDownloadTask", "#run 下载出错 pkg=" + jc4Var + " retryCount=" + this.e.b);
                    if (this.e.b < 3) {
                        try {
                            if (!this.d.get()) {
                                Thread.sleep(this.e.b * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        m();
                        md4 md4Var = this.a;
                        a(md4Var.a.a, md4Var.b);
                        return;
                    }
                } else {
                    g.i("PMSDownloadTask", "#run 下包成功 pkg=" + jc4Var);
                    n();
                    return;
                }
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.d.get() == z) {
            return;
        }
        this.d.set(z);
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
