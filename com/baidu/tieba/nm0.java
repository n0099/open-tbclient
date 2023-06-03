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
public class nm0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<om0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948007128, "Lcom/baidu/tieba/nm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948007128, "Lcom/baidu/tieba/nm0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static om0 a(@NonNull zl0 zl0Var) {
        InterceptResult invokeL;
        om0 om0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zl0Var)) == null) {
            WeakReference<om0> weakReference = a.get(zl0Var.e());
            if (weakReference == null || (om0Var = weakReference.get()) == null) {
                om0 om0Var2 = new om0(zl0Var);
                a.put(zl0Var.e(), new WeakReference<>(om0Var2));
                return om0Var2;
            }
            return om0Var;
        }
        return (om0) invokeL.objValue;
    }

    public static void b(@NonNull zl0 zl0Var) {
        WeakReference<om0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, zl0Var) == null) && (remove = a.remove(zl0Var.e())) != null) {
            remove.clear();
        }
    }
}
