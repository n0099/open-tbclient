package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class sf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public tf2 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948149418, "Lcom/baidu/tieba/sf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948149418, "Lcom/baidu/tieba/sf2;");
                return;
            }
        }
        b = fs1.a;
    }

    public sf2() {
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
        this.a = tf2.a;
    }

    public final void a(@NonNull u83 u83Var, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, u83Var, prefetchEvent, pMSAppInfo) == null) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
            if (pMSAppInfo == null) {
                pMSAppInfo = sj4.i().u(prefetchEvent.appId);
            }
            if (pMSAppInfo == null) {
                return;
            }
            bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
            if (!this.a.a(prefetchEvent, pMSAppInfo, bundle)) {
                return;
            }
            l83 e = l83.e();
            n83 n83Var = new n83(120, bundle);
            n83Var.b(u83Var.b);
            n83Var.p(false);
            e.h(n83Var);
        }
    }

    public void b(@NonNull PrefetchEvent prefetchEvent, @NonNull u83 u83Var, @Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, u83Var, pMSAppInfo) == null) {
            a(u83Var, prefetchEvent, pMSAppInfo);
            u83Var.j0(prefetchEvent);
            if (b) {
                Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
                Log.d("PrefetchMessenger", "onPrefetchReady client id: " + u83Var.b.index);
            }
        }
    }
}
