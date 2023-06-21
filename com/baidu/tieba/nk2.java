package com.baidu.tieba;

import android.app.Activity;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class nk2 implements yx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948005268, "Lcom/baidu/tieba/nk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948005268, "Lcom/baidu/tieba/nk2;");
                return;
            }
        }
        a = js1.a;
    }

    public nk2() {
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

    @Override // com.baidu.tieba.yx2
    public void a(boolean z, Activity activity) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) && pk2.a() && !z) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            boolean B = qp3.B();
            if (a) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("DiskCleanerLifecycleObserver", "detect all process is on baground cost - " + (currentTimeMillis - j) + "ms");
            }
            if (B) {
                boolean n = rk2.n();
                z82.k("DiskCleanerLifecycleObserver", "all app process in background，run clean task");
                lk2.c().d().u(null, n, 16);
                rk2.p(false);
            }
        }
    }
}
