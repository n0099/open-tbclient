package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class wl0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<xl0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948274286, "Lcom/baidu/tieba/wl0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948274286, "Lcom/baidu/tieba/wl0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static xl0 a(@NonNull il0 il0Var) {
        InterceptResult invokeL;
        xl0 xl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, il0Var)) == null) {
            WeakReference<xl0> weakReference = a.get(il0Var.e());
            if (weakReference == null || (xl0Var = weakReference.get()) == null) {
                xl0 xl0Var2 = new xl0(il0Var);
                a.put(il0Var.e(), new WeakReference<>(xl0Var2));
                return xl0Var2;
            }
            return xl0Var;
        }
        return (xl0) invokeL.objValue;
    }

    public static void b(@NonNull il0 il0Var) {
        WeakReference<xl0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, il0Var) == null) && (remove = a.remove(il0Var.e())) != null) {
            remove.clear();
        }
    }
}
