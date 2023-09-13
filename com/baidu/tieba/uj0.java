package com.baidu.tieba;

import android.app.Application;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<ho0> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (ho0 ho0Var : uj0.a) {
                    ho0Var.b();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        List<ho0> list;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948212782, "Lcom/baidu/tieba/uj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948212782, "Lcom/baidu/tieba/uj0;");
                return;
            }
        }
        a = new ArrayList();
        pk1<ho0> pk1Var = new jo0().a;
        if (pk1Var != null && (list = pk1Var.getList()) != null) {
            a.addAll(list);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            y41.c(new a(), "nad_core_init_on_create", 0);
        }
    }

    public static void b(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, application) == null) {
            tj0.a = application;
            ts0.a(application);
            for (ho0 ho0Var : a) {
                ho0Var.a(application);
            }
        }
    }
}
