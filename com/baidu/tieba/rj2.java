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
public abstract class rj2 implements cx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948123471, "Lcom/baidu/tieba/rj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948123471, "Lcom/baidu/tieba/rj2;");
                return;
            }
        }
        a = nr1.a;
    }

    public rj2() {
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

    @Override // com.baidu.tieba.cx2
    public void a(boolean z, Activity activity) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) && tj2.a() && !z) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            boolean B = uo3.B();
            if (a) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("DiskCleanerLifecycleObserver", "detect all process is on baground cost - " + (currentTimeMillis - j) + "ms");
            }
            if (B) {
                boolean n = vj2.n();
                d82.k("DiskCleanerLifecycleObserver", "all app process in background，run clean task");
                pj2.c().d().u(null, n, 16);
                vj2.p(false);
            }
        }
    }
}
