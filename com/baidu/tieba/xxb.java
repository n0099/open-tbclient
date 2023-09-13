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
public abstract class xxb implements uxb {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, xxb> a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948317159, "Lcom/baidu/tieba/xxb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948317159, "Lcom/baidu/tieba/xxb;");
                return;
            }
        }
        a = new HashMap();
        b = new Object();
    }

    public xxb() {
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

    public static xxb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            return d(context, context.getPackageName());
        }
        return (xxb) invokeL.objValue;
    }

    public static xxb d(Context context, String str) {
        InterceptResult invokeLL;
        xxb xxbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (b) {
                xxbVar = a.get(str);
                if (xxbVar == null) {
                    xxbVar = new dyb(context, str);
                    a.put(str, xxbVar);
                }
            }
            return xxbVar;
        }
        return (xxb) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.uxb
    public abstract /* synthetic */ Context getContext();

    @Override // com.baidu.tieba.uxb
    public abstract /* synthetic */ String getIdentifier();
}
