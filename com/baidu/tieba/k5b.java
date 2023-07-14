package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class k5b {
    public static /* synthetic */ Interceptable $ic;
    public static final k5b c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<a> a;
    public boolean b;

    /* loaded from: classes6.dex */
    public interface a {
        void U();

        void a(Activity activity);

        void b();

        void onActivityDestroyed(Activity activity);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947865489, "Lcom/baidu/tieba/k5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947865489, "Lcom/baidu/tieba/k5b;");
                return;
            }
        }
        c = new k5b();
    }

    public k5b() {
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
        this.a = new LinkedHashSet();
    }

    public static k5b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (k5b) invokeV.objValue;
    }

    public final Set<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (Set) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.a) {
                this.a.clear();
            }
        }
    }

    public final void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            synchronized (this.a) {
                this.a.add(aVar);
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && !this.b && Build.VERSION.SDK_INT >= 14) {
            try {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new r5b(this));
            } catch (Exception unused) {
                f6b.b("registerActivityLifecycleCallbacks encounter exception");
            }
            this.b = true;
        }
    }
}
