package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class wg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public AdDownloadStatus c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public File h;
    public float i;
    public float j;
    public Uri k;
    public long l;
    public long m;
    public int n;
    public String o;
    @NonNull
    public ah0 p;
    @NonNull
    public xg0 q;
    @NonNull
    public zg0 r;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318788852, "Lcom/baidu/tieba/wg0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318788852, "Lcom/baidu/tieba/wg0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public wg0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = -1;
        this.c = AdDownloadStatus.NONE;
        this.i = 0.0f;
        this.j = 0.0f;
        this.n = -1;
        this.p = new ah0();
        this.q = new xg0();
        this.r = new zg0();
    }

    public boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f() || !this.q.s) {
                return false;
            }
            if (TextUtils.isEmpty(this.p.c)) {
                str = lg0.a(this.d);
            } else {
                str = this.p.c;
            }
            if (TextUtils.isEmpty(str) && (!this.q.u || TextUtils.isEmpty(this.d))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static wg0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        tm0 tm0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            wg0 wg0Var = new wg0();
            if (adBaseModel != null && (tm0Var = adBaseModel.l) != null && tm0Var.e) {
                wg0Var.g = tm0Var.c;
                wg0Var.h(tm0Var.d);
                wg0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                if (adOperator == null) {
                    str = null;
                } else {
                    str = adOperator.b;
                }
                wg0Var.f = str;
                wg0Var.p.a = adBaseModel.f.d;
            }
            return wg0Var;
        }
        return (wg0) invokeL.objValue;
    }

    @NonNull
    public static wg0 d(tm0 tm0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, tm0Var, str, str2)) == null) {
            wg0 wg0Var = new wg0();
            if (tm0Var != null && tm0Var.e) {
                wg0Var.g = tm0Var.c;
                wg0Var.h(tm0Var.d);
                wg0Var.d = tm0Var.a;
                ah0 ah0Var = wg0Var.p;
                ah0Var.a = str;
                wg0Var.f = str2;
                ah0Var.k = yg0.a(oy0.c(tm0Var.f));
            }
            return wg0Var;
        }
        return (wg0) invokeLLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.q.g != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.g)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = AdDownloadStatus.NONE;
            this.i = 0.0f;
            this.j = 0.0f;
            this.h = null;
            this.q.v = false;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || str == null) {
            return;
        }
        this.a = str;
    }

    public void i(wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wg0Var) == null) {
            if (wg0Var != null && TextUtils.equals(e(), wg0Var.e())) {
                int i = a.a[wg0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !gi0.c(wg0Var.d)) {
                        File file = wg0Var.h;
                        if (file != null && file.exists()) {
                            wg0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            wg0Var.g();
                        }
                    }
                } else if (gi0.c(wg0Var.d)) {
                    wg0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!gi0.g(wg0Var.h)) {
                    jg0.c().a(wg0Var);
                    wg0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = wg0Var.d;
                }
                this.b = wg0Var.b;
                this.c = wg0Var.c;
                this.i = wg0Var.i;
                this.j = wg0Var.j;
                this.h = wg0Var.h;
                this.d = wg0Var.d;
                this.l = wg0Var.l;
                this.m = wg0Var.m;
                xg0 xg0Var = this.q;
                xg0 xg0Var2 = wg0Var.q;
                xg0Var.k = xg0Var2.k;
                xg0Var.l = xg0Var2.l;
                xg0Var.v = xg0Var2.v;
                xg0Var.w = xg0Var2.w;
                this.p.h = wg0Var.p.h;
                this.k = wg0Var.k;
            } else if (gi0.c(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
