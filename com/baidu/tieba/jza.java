package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Deprecated
/* loaded from: classes5.dex */
public abstract class jza implements gza {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, jza> a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947901976, "Lcom/baidu/tieba/jza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947901976, "Lcom/baidu/tieba/jza;");
                return;
            }
        }
        a = new HashMap();
        b = new Object();
    }

    public jza() {
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

    public static jza c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            return d(context, context.getPackageName());
        }
        return (jza) invokeL.objValue;
    }

    public static jza d(Context context, String str) {
        InterceptResult invokeLL;
        jza jzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (b) {
                jzaVar = a.get(str);
                if (jzaVar == null) {
                    jzaVar = new pza(context, str);
                    a.put(str, jzaVar);
                }
            }
            return jzaVar;
        }
        return (jza) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gza
    public abstract /* synthetic */ Context getContext();

    @Override // com.baidu.tieba.gza
    public abstract /* synthetic */ String getIdentifier();
}
