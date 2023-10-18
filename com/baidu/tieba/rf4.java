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
/* loaded from: classes7.dex */
public class rf4<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final ri4 g;
    public transient /* synthetic */ FieldHolder $fh;
    public qf4 a;
    public T b;
    public File c;
    public AtomicBoolean d;
    public of4<T> e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948119689, "Lcom/baidu/tieba/rf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948119689, "Lcom/baidu/tieba/rf4;");
                return;
            }
        }
        g = ri4.e();
    }

    public gd4<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (gd4) invokeV.objValue;
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
            return new df4().a(this.e.k()).intValue();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            of4<T> of4Var = this.e;
            if (of4Var != null) {
                return of4Var.g();
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

    public rf4(qf4 qf4Var, T t, of4<T> of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qf4Var, t, of4Var};
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
        this.a = qf4Var;
        this.b = t;
        this.e = of4Var;
    }

    public final void a(int i, ne4 ne4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, ne4Var) != null) || ne4Var == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i == 2200) {
            i = 0;
        } else {
            try {
                jSONObject.put("response", ne4Var.toString());
            } catch (JSONException e) {
                g.g("PMSDownloadTask", "#addStatistic json put data出错", e);
            }
        }
        if (ne4Var instanceof oe4) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ne4Var.g);
        }
        pi4.a(ne4Var.h, "pkg_download", null, i, jSONObject);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            ne4 ne4Var = this.a.b;
            if (ne4Var.e == i) {
                return false;
            }
            ne4Var.e = i;
            if (i != 2 && i != 3 && i != 10) {
                s(false);
            } else {
                s(true);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean d(rf4<T> rf4Var) {
        InterceptResult invokeL;
        qf4 qf4Var;
        ne4 ne4Var;
        qf4 qf4Var2;
        ne4 ne4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rf4Var)) == null) {
            if (rf4Var == null || (qf4Var = rf4Var.a) == null || (ne4Var = qf4Var.b) == null || (qf4Var2 = this.a) == null || (ne4Var2 = qf4Var2.b) == null || !ne4Var2.equals(ne4Var)) {
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
            if (obj == null || !(obj instanceof rf4)) {
                return false;
            }
            return d((rf4) obj);
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
            File c = vi4.c(this.e.d(this.b), this.a.b.l);
            this.c = c;
            if (c == null) {
                String absolutePath = hc4.b().getAppContext().getCacheDir().getAbsolutePath();
                ri4 ri4Var = g;
                ri4Var.i("PMSDownloadTask", "#checkAndCreateFile mLocalFile=null cacheDir=" + absolutePath);
                this.c = vi4.c(absolutePath, this.a.b.l);
            }
            File file = this.c;
            if (file == null) {
                g.i("PMSDownloadTask", "#checkAndCreateFile generateFilePath=null");
                this.e.e(this.b, new je4(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
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
            String ne4Var = this.a.b.toString();
            g.i("PMSDownloadTask", "#run 开始下包 pkg=" + ne4Var);
            vf4 vf4Var = new vf4(this, h());
            while (true) {
                je4 je4Var = this.a.a;
                if (je4Var != null && je4Var.a == 2200) {
                    return;
                }
                if (this.d.get()) {
                    g.i("PMSDownloadTask", "#run 已经取消下包 pkg=" + ne4Var);
                    q();
                    return;
                }
                vf4Var.b();
                je4 je4Var2 = this.a.a;
                if (je4Var2 != null) {
                    if (je4Var2.a != 2200) {
                        if (this.d.get()) {
                            g.i("PMSDownloadTask", "#run 运行中取消下包 pkg=" + ne4Var);
                            q();
                            return;
                        }
                        this.e.b++;
                        g.i("PMSDownloadTask", "#run 下载出错 pkg=" + ne4Var + " retryCount=" + this.e.b);
                        if (this.e.b < 3) {
                            try {
                                if (!this.d.get()) {
                                    Thread.sleep(this.e.b * 1000);
                                }
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            m();
                            qf4 qf4Var = this.a;
                            a(qf4Var.a.a, qf4Var.b);
                            return;
                        }
                    } else {
                        g.i("PMSDownloadTask", "#run 下包成功 pkg=" + ne4Var);
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
