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
/* loaded from: classes6.dex */
public class yj0 {
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
    public ck0 p;
    public zj0 q;
    public bk0 r;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258759987, "Lcom/baidu/tieba/yj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-258759987, "Lcom/baidu/tieba/yj0$a;");
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

    public yj0() {
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
        this.p = new ck0();
        this.q = new zj0();
        this.r = new bk0();
    }

    @NonNull
    public static yj0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        ho0 ho0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            yj0 yj0Var = new yj0();
            if (adBaseModel != null && (ho0Var = adBaseModel.l) != null && ho0Var.e) {
                yj0Var.g = ho0Var.c;
                yj0Var.h(ho0Var.d);
                yj0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                yj0Var.f = adOperator == null ? null : adOperator.d;
                yj0Var.p.a = adBaseModel.f.d;
            }
            return yj0Var;
        }
        return (yj0) invokeL.objValue;
    }

    @NonNull
    public static yj0 d(ho0 ho0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, ho0Var, str, str2)) == null) {
            yj0 yj0Var = new yj0();
            if (ho0Var != null && ho0Var.e) {
                yj0Var.g = ho0Var.c;
                yj0Var.h(ho0Var.d);
                yj0Var.d = ho0Var.a;
                yj0Var.p.a = str;
                yj0Var.f = str2;
            }
            return yj0Var;
        }
        return (yj0) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!f() && this.q.s) {
                return !TextUtils.isEmpty(TextUtils.isEmpty(this.p.c) ? nj0.a(this.d) : this.p.c) || (this.q.u && !TextUtils.isEmpty(this.d));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q.g != 1 : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.g) : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = AdDownloadStatus.NONE;
            this.i = 0.0f;
            this.j = 0.0f;
            this.h = null;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || str == null) {
            return;
        }
        this.a = str;
    }

    public void i(yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yj0Var) == null) {
            if (yj0Var != null && TextUtils.equals(e(), yj0Var.e())) {
                int i = a.a[yj0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !cl0.b(yj0Var.d)) {
                        File file = yj0Var.h;
                        if (file != null && file.exists()) {
                            yj0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            yj0Var.g();
                            return;
                        }
                    }
                } else if (cl0.b(yj0Var.d)) {
                    yj0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!cl0.e(yj0Var.h)) {
                    lj0.b().a(yj0Var);
                    yj0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = yj0Var.d;
                }
                this.b = yj0Var.b;
                this.c = yj0Var.c;
                this.i = yj0Var.i;
                this.j = yj0Var.j;
                this.h = yj0Var.h;
                this.d = yj0Var.d;
                this.l = yj0Var.l;
                this.m = yj0Var.m;
                zj0 zj0Var = this.q;
                zj0 zj0Var2 = yj0Var.q;
                zj0Var.k = zj0Var2.k;
                zj0Var.l = zj0Var2.l;
                this.p.h = yj0Var.p.h;
                this.k = yj0Var.k;
            } else if (cl0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
