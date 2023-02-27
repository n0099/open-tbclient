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
public class ul0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<vl0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948214704, "Lcom/baidu/tieba/ul0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948214704, "Lcom/baidu/tieba/ul0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static vl0 a(@NonNull gl0 gl0Var) {
        InterceptResult invokeL;
        vl0 vl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gl0Var)) == null) {
            WeakReference<vl0> weakReference = a.get(gl0Var.e());
            if (weakReference == null || (vl0Var = weakReference.get()) == null) {
                vl0 vl0Var2 = new vl0(gl0Var);
                a.put(gl0Var.e(), new WeakReference<>(vl0Var2));
                return vl0Var2;
            }
            return vl0Var;
        }
        return (vl0) invokeL.objValue;
    }

    public static void b(@NonNull gl0 gl0Var) {
        WeakReference<vl0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, gl0Var) == null) && (remove = a.remove(gl0Var.e())) != null) {
            remove.clear();
        }
    }
}
