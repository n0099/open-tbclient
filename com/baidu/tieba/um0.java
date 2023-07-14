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
public class um0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<vm0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948215665, "Lcom/baidu/tieba/um0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948215665, "Lcom/baidu/tieba/um0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static vm0 a(@NonNull gm0 gm0Var) {
        InterceptResult invokeL;
        vm0 vm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gm0Var)) == null) {
            WeakReference<vm0> weakReference = a.get(gm0Var.e());
            if (weakReference == null || (vm0Var = weakReference.get()) == null) {
                vm0 vm0Var2 = new vm0(gm0Var);
                a.put(gm0Var.e(), new WeakReference<>(vm0Var2));
                return vm0Var2;
            }
            return vm0Var;
        }
        return (vm0) invokeL.objValue;
    }

    public static void b(@NonNull gm0 gm0Var) {
        WeakReference<vm0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, gm0Var) == null) && (remove = a.remove(gm0Var.e())) != null) {
            remove.clear();
        }
    }
}
