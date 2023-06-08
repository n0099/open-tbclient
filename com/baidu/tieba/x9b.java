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
/* loaded from: classes8.dex */
public abstract class x9b implements u9b {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, x9b> a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948256616, "Lcom/baidu/tieba/x9b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948256616, "Lcom/baidu/tieba/x9b;");
                return;
            }
        }
        a = new HashMap();
        b = new Object();
    }

    public x9b() {
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

    public static x9b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            return d(context, context.getPackageName());
        }
        return (x9b) invokeL.objValue;
    }

    public static x9b d(Context context, String str) {
        InterceptResult invokeLL;
        x9b x9bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (b) {
                x9bVar = a.get(str);
                if (x9bVar == null) {
                    x9bVar = new dab(context, str);
                    a.put(str, x9bVar);
                }
            }
            return x9bVar;
        }
        return (x9b) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.u9b
    public abstract /* synthetic */ Context getContext();

    @Override // com.baidu.tieba.u9b
    public abstract /* synthetic */ String getIdentifier();
}
