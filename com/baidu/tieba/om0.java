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
public class om0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<pm0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948036919, "Lcom/baidu/tieba/om0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948036919, "Lcom/baidu/tieba/om0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static pm0 a(@NonNull am0 am0Var) {
        InterceptResult invokeL;
        pm0 pm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, am0Var)) == null) {
            WeakReference<pm0> weakReference = a.get(am0Var.e());
            if (weakReference == null || (pm0Var = weakReference.get()) == null) {
                pm0 pm0Var2 = new pm0(am0Var);
                a.put(am0Var.e(), new WeakReference<>(pm0Var2));
                return pm0Var2;
            }
            return pm0Var;
        }
        return (pm0) invokeL.objValue;
    }

    public static void b(@NonNull am0 am0Var) {
        WeakReference<pm0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, am0Var) == null) && (remove = a.remove(am0Var.e())) != null) {
            remove.clear();
        }
    }
}
