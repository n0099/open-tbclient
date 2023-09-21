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
public class mm0 {
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
        public static final mm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-599539205, "Lcom/baidu/tieba/mm0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-599539205, "Lcom/baidu/tieba/mm0$b;");
                    return;
                }
            }
            a = new mm0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947977337, "Lcom/baidu/tieba/mm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947977337, "Lcom/baidu/tieba/mm0;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(10L);
    }

    public mm0() {
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

    public static mm0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (mm0) invokeV.objValue;
    }

    public /* synthetic */ mm0(a aVar) {
        this();
    }

    public void a(om0 om0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, om0Var) == null) {
            hl0 hl0Var = new hl0();
            hl0Var.g = "https://cover.baidu.com/cover/deeplink_android?downloadUrl=";
            hl0Var.h(om0Var.b);
            ll0 ll0Var = hl0Var.p;
            ll0Var.a = om0Var.c;
            hl0Var.d = om0Var.a;
            ll0Var.o = om0Var.e;
            ll0Var.p = om0Var.f;
            ll0Var.n = om0Var.d;
            hl0Var.q.a = "SCHEDULEDDOWNLOAD";
            if (!TextUtils.isEmpty(om0Var.g)) {
                hl0Var.q.b = om0Var.g;
            } else {
                hl0Var.q.b = "na_ads";
            }
            if (!TextUtils.isEmpty(om0Var.h)) {
                hl0Var.q.c = om0Var.h;
            } else {
                hl0Var.q.c = "apk_yuansheng";
            }
            hl0Var.l = Long.MAX_VALUE - (a * 2);
            yk0.b().update(hl0Var);
            yk0.b().e(hl0Var);
        }
    }

    public void c(String str, boolean z) {
        hl0 hl0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) != null) || (hl0Var = (hl0) i31.b(yk0.b().a(), str)) == null) {
            return;
        }
        hl0Var.p.p = z;
        yk0.b().update(hl0Var);
        yk0.b().e(hl0Var);
    }
}
