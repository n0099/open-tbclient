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
/* loaded from: classes9.dex */
public class zk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final long b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, il0> a;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229207284, "Lcom/baidu/tieba/zk0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-229207284, "Lcom/baidu/tieba/zk0$b;");
                    return;
                }
            }
            a = new zk0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948362698, "Lcom/baidu/tieba/zk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948362698, "Lcom/baidu/tieba/zk0;");
                return;
            }
        }
        b = TimeUnit.DAYS.toMillis(10L);
    }

    public zk0() {
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

    public static zk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (zk0) invokeV.objValue;
    }

    @NonNull
    public HashMap<String, il0> a() {
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
            al0.e().b(this.a);
        }
    }

    public /* synthetic */ zk0(a aVar) {
        this();
    }

    public void e(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, il0Var) == null) {
            al0.e().c(bl0.a(il0Var));
        }
    }

    public void f(@NonNull v31 v31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v31Var) == null) {
            al0.e().update(v31Var);
        }
    }

    public il0 query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return (il0) j31.b(this.a, str);
        }
        return (il0) invokeL.objValue;
    }

    public void update(il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, il0Var) != null) || il0Var == null) {
            return;
        }
        j31.e(this.a, il0Var.e(), il0Var);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<il0> a2 = al0.e().a();
            if (h31.g(a2)) {
                return;
            }
            int l = h31.l(a2);
            for (int i = 0; i != l; i++) {
                il0 il0Var = (il0) h31.d(a2, i);
                if (il0Var != null) {
                    if (il0Var.c == AdDownloadStatus.DOWNLOADING) {
                        il0Var.c = AdDownloadStatus.PAUSE;
                    }
                    j31.e(this.a, il0Var.e(), il0Var);
                }
            }
        }
    }
}
