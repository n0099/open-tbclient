package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class xl0 {
    public static /* synthetic */ Interceptable $ic;
    public static final long b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, gm0> a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xl0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-285542065, "Lcom/baidu/tieba/xl0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-285542065, "Lcom/baidu/tieba/xl0$b;");
                    return;
                }
            }
            a = new xl0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948304077, "Lcom/baidu/tieba/xl0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948304077, "Lcom/baidu/tieba/xl0;");
                return;
            }
        }
        b = TimeUnit.DAYS.toMillis(10L);
    }

    public xl0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static xl0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (xl0) invokeV.objValue;
    }

    @NonNull
    public HashMap<String, gm0> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (HashMap) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yl0.e().b(this.a);
        }
    }

    public /* synthetic */ xl0(a aVar) {
        this();
    }

    public void e(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gm0Var) == null) {
            yl0.e().c(zl0.a(gm0Var));
        }
    }

    public void f(@NonNull l41 l41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l41Var) == null) {
            yl0.e().update(l41Var);
        }
    }

    public gm0 query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return (gm0) z31.b(this.a, str);
        }
        return (gm0) invokeL.objValue;
    }

    public void update(gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, gm0Var) != null) || gm0Var == null) {
            return;
        }
        z31.e(this.a, gm0Var.e(), gm0Var);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<gm0> a2 = yl0.e().a();
            if (x31.g(a2)) {
                return;
            }
            int l = x31.l(a2);
            for (int i = 0; i != l; i++) {
                gm0 gm0Var = (gm0) x31.d(a2, i);
                if (gm0Var != null) {
                    if (gm0Var.c == AdDownloadStatus.DOWNLOADING) {
                        gm0Var.c = AdDownloadStatus.PAUSE;
                    }
                    z31.e(this.a, gm0Var.e(), gm0Var);
                }
            }
        }
    }
}
