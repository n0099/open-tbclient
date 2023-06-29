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
public class rm0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<sm0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948126292, "Lcom/baidu/tieba/rm0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948126292, "Lcom/baidu/tieba/rm0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static sm0 a(@NonNull dm0 dm0Var) {
        InterceptResult invokeL;
        sm0 sm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dm0Var)) == null) {
            WeakReference<sm0> weakReference = a.get(dm0Var.e());
            if (weakReference == null || (sm0Var = weakReference.get()) == null) {
                sm0 sm0Var2 = new sm0(dm0Var);
                a.put(dm0Var.e(), new WeakReference<>(sm0Var2));
                return sm0Var2;
            }
            return sm0Var;
        }
        return (sm0) invokeL.objValue;
    }

    public static void b(@NonNull dm0 dm0Var) {
        WeakReference<sm0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, dm0Var) == null) && (remove = a.remove(dm0Var.e())) != null) {
            remove.clear();
        }
    }
}
