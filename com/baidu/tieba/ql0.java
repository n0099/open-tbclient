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
/* loaded from: classes6.dex */
public class ql0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<rl0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095540, "Lcom/baidu/tieba/ql0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095540, "Lcom/baidu/tieba/ql0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static rl0 a(@NonNull cl0 cl0Var) {
        InterceptResult invokeL;
        rl0 rl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cl0Var)) == null) {
            WeakReference<rl0> weakReference = a.get(cl0Var.e());
            if (weakReference == null || (rl0Var = weakReference.get()) == null) {
                rl0 rl0Var2 = new rl0(cl0Var);
                a.put(cl0Var.e(), new WeakReference<>(rl0Var2));
                return rl0Var2;
            }
            return rl0Var;
        }
        return (rl0) invokeL.objValue;
    }

    public static void b(@NonNull cl0 cl0Var) {
        WeakReference<rl0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, cl0Var) == null) && (remove = a.remove(cl0Var.e())) != null) {
            remove.clear();
        }
    }
}
