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
/* loaded from: classes7.dex */
public class sl0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<tl0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948155122, "Lcom/baidu/tieba/sl0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948155122, "Lcom/baidu/tieba/sl0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static tl0 a(@NonNull el0 el0Var) {
        InterceptResult invokeL;
        tl0 tl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, el0Var)) == null) {
            WeakReference<tl0> weakReference = a.get(el0Var.e());
            if (weakReference == null || (tl0Var = weakReference.get()) == null) {
                tl0 tl0Var2 = new tl0(el0Var);
                a.put(el0Var.e(), new WeakReference<>(tl0Var2));
                return tl0Var2;
            }
            return tl0Var;
        }
        return (tl0) invokeL.objValue;
    }

    public static void b(@NonNull el0 el0Var) {
        WeakReference<tl0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, el0Var) == null) && (remove = a.remove(el0Var.e())) != null) {
            remove.clear();
        }
    }
}
