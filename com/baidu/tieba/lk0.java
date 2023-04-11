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
/* loaded from: classes5.dex */
public class lk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<mk0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947945624, "Lcom/baidu/tieba/lk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947945624, "Lcom/baidu/tieba/lk0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static mk0 a(@NonNull xj0 xj0Var) {
        InterceptResult invokeL;
        mk0 mk0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xj0Var)) == null) {
            WeakReference<mk0> weakReference = a.get(xj0Var.e());
            if (weakReference == null || (mk0Var = weakReference.get()) == null) {
                mk0 mk0Var2 = new mk0(xj0Var);
                a.put(xj0Var.e(), new WeakReference<>(mk0Var2));
                return mk0Var2;
            }
            return mk0Var;
        }
        return (mk0) invokeL.objValue;
    }

    public static void b(@NonNull xj0 xj0Var) {
        WeakReference<mk0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, xj0Var) == null) && (remove = a.remove(xj0Var.e())) != null) {
            remove.clear();
        }
    }
}
