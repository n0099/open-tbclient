package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class nm0 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final nm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-570910054, "Lcom/baidu/tieba/nm0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-570910054, "Lcom/baidu/tieba/nm0$b;");
                    return;
                }
            }
            a = new nm0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948007128, "Lcom/baidu/tieba/nm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948007128, "Lcom/baidu/tieba/nm0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public nm0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static nm0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (nm0) invokeV.objValue;
    }

    public /* synthetic */ nm0(a aVar) {
        this();
    }

    public void a(pm0 pm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pm0Var) == null) {
            il0 il0Var = new il0();
            il0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            il0Var.h(pm0Var.b);
            ml0 ml0Var = il0Var.p;
            ml0Var.a = pm0Var.c;
            il0Var.d = pm0Var.a;
            ml0Var.o = pm0Var.e;
            ml0Var.p = pm0Var.f;
            ml0Var.n = pm0Var.d;
            il0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(pm0Var.g)) {
                il0Var.q.b = pm0Var.g;
            } else {
                il0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(pm0Var.h)) {
                il0Var.q.c = pm0Var.h;
            } else {
                il0Var.q.c = "apk_yuansheng";
            }
            il0Var.l = Long.MAX_VALUE - (a * 2);
            zk0.b().update(il0Var);
            zk0.b().e(il0Var);
        }
    }

    public void c(String str, boolean z) {
        il0 il0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (il0Var = (il0) j31.b(zk0.b().a(), str)) == null) {
            return;
        }
        il0Var.p.p = z;
        zk0.b().update(il0Var);
        zk0.b().e(il0Var);
    }
}
