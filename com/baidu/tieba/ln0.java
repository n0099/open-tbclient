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
public class ln0 {
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
        public static final ln0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-627244835, "Lcom/baidu/tieba/ln0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-627244835, "Lcom/baidu/tieba/ln0$b;");
                    return;
                }
            }
            a = new ln0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947948507, "Lcom/baidu/tieba/ln0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947948507, "Lcom/baidu/tieba/ln0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public ln0() {
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

    public static ln0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ln0) invokeV.objValue;
    }

    public /* synthetic */ ln0(a aVar) {
        this();
    }

    public void a(nn0 nn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nn0Var) == null) {
            gm0 gm0Var = new gm0();
            gm0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            gm0Var.h(nn0Var.b);
            km0 km0Var = gm0Var.p;
            km0Var.a = nn0Var.c;
            gm0Var.d = nn0Var.a;
            km0Var.o = nn0Var.e;
            km0Var.p = nn0Var.f;
            km0Var.n = nn0Var.d;
            gm0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(nn0Var.g)) {
                gm0Var.q.b = nn0Var.g;
            } else {
                gm0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(nn0Var.h)) {
                gm0Var.q.c = nn0Var.h;
            } else {
                gm0Var.q.c = "apk_yuansheng";
            }
            gm0Var.l = Long.MAX_VALUE - (a * 2);
            xl0.b().update(gm0Var);
            xl0.b().e(gm0Var);
        }
    }

    public void c(String str, boolean z) {
        gm0 gm0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (gm0Var = (gm0) z31.b(xl0.b().a(), str)) == null) {
            return;
        }
        gm0Var.p.p = z;
        xl0.b().update(gm0Var);
        xl0.b().e(gm0Var);
    }
}
