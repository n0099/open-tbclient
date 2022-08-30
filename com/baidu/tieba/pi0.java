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
/* loaded from: classes5.dex */
public class pi0 {
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
    public ti0 p;
    public qi0 q;
    public si0 r;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-517345867, "Lcom/baidu/tieba/pi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-517345867, "Lcom/baidu/tieba/pi0$a;");
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

    public pi0() {
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
        this.p = new ti0();
        this.q = new qi0();
        this.r = new si0();
    }

    @NonNull
    public static pi0 c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        vm0 vm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            pi0 pi0Var = new pi0();
            if (adBaseModel != null && (vm0Var = adBaseModel.l) != null && vm0Var.e) {
                pi0Var.g = vm0Var.c;
                pi0Var.h(vm0Var.d);
                pi0Var.d = adBaseModel.l.a;
                AdOperator adOperator = adBaseModel.h;
                pi0Var.f = adOperator == null ? null : adOperator.d;
                pi0Var.p.a = adBaseModel.f.d;
            }
            return pi0Var;
        }
        return (pi0) invokeL.objValue;
    }

    @NonNull
    public static pi0 d(vm0 vm0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, vm0Var, str, str2)) == null) {
            pi0 pi0Var = new pi0();
            if (vm0Var != null && vm0Var.e) {
                pi0Var.g = vm0Var.c;
                pi0Var.h(vm0Var.d);
                pi0Var.d = vm0Var.a;
                pi0Var.p.a = str;
                pi0Var.f = str2;
            }
            return pi0Var;
        }
        return (pi0) invokeLLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!f() && this.q.r) {
                return !TextUtils.isEmpty(TextUtils.isEmpty(this.p.c) ? di0.a(this.d) : this.p.c) || (this.q.t && !TextUtils.isEmpty(this.d));
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

    public void i(pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pi0Var) == null) {
            if (pi0Var != null && TextUtils.equals(e(), pi0Var.e())) {
                int i = a.a[pi0Var.c.ordinal()];
                if (i != 1) {
                    if (i == 2 && !rj0.b(pi0Var.d)) {
                        File file = pi0Var.h;
                        if (file != null && file.exists()) {
                            pi0Var.c = AdDownloadStatus.COMPLETED;
                        } else {
                            pi0Var.g();
                            return;
                        }
                    }
                } else if (rj0.b(pi0Var.d)) {
                    pi0Var.c = AdDownloadStatus.INSTALLED;
                } else if (!rj0.e(pi0Var.h)) {
                    bi0.b().a(pi0Var);
                    pi0Var.g();
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.d = pi0Var.d;
                }
                this.b = pi0Var.b;
                this.c = pi0Var.c;
                this.i = pi0Var.i;
                this.j = pi0Var.j;
                this.h = pi0Var.h;
                this.d = pi0Var.d;
                this.l = pi0Var.l;
                this.m = pi0Var.m;
                qi0 qi0Var = this.q;
                qi0 qi0Var2 = pi0Var.q;
                qi0Var.k = qi0Var2.k;
                qi0Var.l = qi0Var2.l;
                this.p.h = pi0Var.p.h;
                this.k = pi0Var.k;
            } else if (rj0.b(this.d)) {
                this.c = AdDownloadStatus.INSTALLED;
            }
        }
    }
}
