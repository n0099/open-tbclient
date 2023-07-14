package com.baidu.tieba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class p83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015870, "Lcom/baidu/tieba/p83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015870, "Lcom/baidu/tieba/p83;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends v73> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bundle, cls) == null) {
            Iterator<u83> it = w83.k().q().iterator();
            while (it.hasNext()) {
                u83 next = it.next();
                if (next != null && next.T()) {
                    b(next.b, bundle, cls, null);
                }
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends v73> cls, @Nullable c83 c83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, swanAppProcessInfo, bundle, cls, c83Var) == null) {
            if (a) {
                Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = w83.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (c83Var != null) {
                bundle2.putString("ai_apps_observer_id", c83Var.b());
                z73.b().e(c83Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            l83 e = l83.e();
            n83 n83Var = new n83(obtain);
            n83Var.b(swanAppProcessInfo);
            e.h(n83Var);
        }
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends v73> cls, @Nullable c83 c83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bundle, cls, c83Var) == null) {
            q83.Q().X(bundle, cls, c83Var);
        }
    }
}
