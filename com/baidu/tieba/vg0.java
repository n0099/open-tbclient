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
public class vg0 {
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
    public zg0 p;
    @NonNull
    public wg0 q;
    @NonNull
    public yg0 r;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-347418003, "Lcom/baidu/tieba/vg0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-347418003, "Lcom/baidu/tieba/vg0$a;");
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

    public vg0() {
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
        this.p = new zg0();
        this.q = new wg0();
        this.r = new yg0();
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
                str = kg0.a(this.d);
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
    public static vg0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        sm0 sm0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            vg0 vg0Var = new vg0();
            if (adBaseModel != null && (sm0Var = adBaseModel.l) != null && sm0Var.e) {
                vg0Var.g = sm0Var.c;
                vg0Var.h(sm0Var.d);
                vg0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                if (adOperator == null) {
                    str = null;
                } else {
                    str = adOperator.b;
                }
                vg0Var.f = str;
                vg0Var.p.a = adBaseModel.f.d;
            }
            return vg0Var;
        }
        return (vg0) invokeL.objValue;
    }

    @NonNull
    public static vg0 d(sm0 sm0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, sm0Var, str, str2)) == null) {
            vg0 vg0Var = new vg0();
            if (sm0Var != null && sm0Var.e) {
                vg0Var.g = sm0Var.c;
                vg0Var.h(sm0Var.d);
                vg0Var.d = sm0Var.a;
                zg0 zg0Var = vg0Var.p;
                zg0Var.a = str;
                vg0Var.f = str2;
                zg0Var.k = xg0.a(ly0.c(sm0Var.f));
            }
            return vg0Var;
        }
        return (vg0) invokeLLL.objValue;
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

    public void i(vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vg0Var) == null) {
            if (vg0Var != null && TextUtils.equals(e(), vg0Var.e())) {
                int i = a.a[vg0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !fi0.c(vg0Var.d)) {
                        File file = vg0Var.h;
                        if (file != null && file.exists()) {
                            vg0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            vg0Var.g();
                        }
                    }
                } else if (fi0.c(vg0Var.d)) {
                    vg0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!fi0.g(vg0Var.h)) {
                    ig0.c().a(vg0Var);
                    vg0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = vg0Var.d;
                }
                this.b = vg0Var.b;
                this.c = vg0Var.c;
                this.i = vg0Var.i;
                this.j = vg0Var.j;
                this.h = vg0Var.h;
                this.d = vg0Var.d;
                this.l = vg0Var.l;
                this.m = vg0Var.m;
                wg0 wg0Var = this.q;
                wg0 wg0Var2 = vg0Var.q;
                wg0Var.k = wg0Var2.k;
                wg0Var.l = wg0Var2.l;
                wg0Var.v = wg0Var2.v;
                wg0Var.w = wg0Var2.w;
                this.p.h = vg0Var.p.h;
                this.k = vg0Var.k;
            } else if (fi0.c(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
