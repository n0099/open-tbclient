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
/* loaded from: classes6.dex */
public class jm0 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final jm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-685426658, "Lcom/baidu/tieba/jm0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-685426658, "Lcom/baidu/tieba/jm0$b;");
                    return;
                }
            }
            a = new jm0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947887964, "Lcom/baidu/tieba/jm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947887964, "Lcom/baidu/tieba/jm0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public jm0() {
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

    public static jm0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (jm0) invokeV.objValue;
    }

    public /* synthetic */ jm0(a aVar) {
        this();
    }

    public void a(lm0 lm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lm0Var) == null) {
            el0 el0Var = new el0();
            el0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            el0Var.h(lm0Var.b);
            il0 il0Var = el0Var.p;
            il0Var.a = lm0Var.c;
            el0Var.d = lm0Var.a;
            il0Var.o = lm0Var.e;
            il0Var.p = lm0Var.f;
            il0Var.n = lm0Var.d;
            el0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(lm0Var.g)) {
                el0Var.q.b = lm0Var.g;
            } else {
                el0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(lm0Var.h)) {
                el0Var.q.c = lm0Var.h;
            } else {
                el0Var.q.c = "apk_yuansheng";
            }
            el0Var.l = Long.MAX_VALUE - (a * 2);
            vk0.b().update(el0Var);
            vk0.b().e(el0Var);
        }
    }

    public void c(String str, boolean z) {
        el0 el0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (el0Var = (el0) c31.b(vk0.b().a(), str)) == null) {
            return;
        }
        el0Var.p.p = z;
        vk0.b().update(el0Var);
        vk0.b().e(el0Var);
    }
}
