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
public class jh0 {
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
        public static final jh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690044263, "Lcom/baidu/tieba/jh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-690044263, "Lcom/baidu/tieba/jh0$b;");
                    return;
                }
            }
            a = new jh0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883159, "Lcom/baidu/tieba/jh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883159, "Lcom/baidu/tieba/jh0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public jh0() {
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

    public static jh0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (jh0) invokeV.objValue;
    }

    public /* synthetic */ jh0(a aVar) {
        this();
    }

    public void a(lh0 lh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lh0Var) == null) {
            eg0 eg0Var = new eg0();
            eg0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            eg0Var.h(lh0Var.b);
            ig0 ig0Var = eg0Var.p;
            ig0Var.a = lh0Var.c;
            eg0Var.d = lh0Var.a;
            ig0Var.o = lh0Var.e;
            ig0Var.p = lh0Var.f;
            ig0Var.n = lh0Var.d;
            eg0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(lh0Var.g)) {
                eg0Var.q.b = lh0Var.g;
            } else {
                eg0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(lh0Var.h)) {
                eg0Var.q.c = lh0Var.h;
            } else {
                eg0Var.q.c = "apk_yuansheng";
            }
            eg0Var.l = Long.MAX_VALUE - (a * 2);
            vf0.b().g(eg0Var);
            vf0.b().f(eg0Var);
        }
    }

    public void c(String str, boolean z) {
        eg0 eg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (eg0Var = (eg0) vx0.b(vf0.b().a(), str)) == null) {
            return;
        }
        eg0Var.p.p = z;
        vf0.b().g(eg0Var);
        vf0.b().f(eg0Var);
    }
}
