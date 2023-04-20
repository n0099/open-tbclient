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
public class mk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<nk0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947975415, "Lcom/baidu/tieba/mk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947975415, "Lcom/baidu/tieba/mk0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static nk0 a(@NonNull yj0 yj0Var) {
        InterceptResult invokeL;
        nk0 nk0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yj0Var)) == null) {
            WeakReference<nk0> weakReference = a.get(yj0Var.e());
            if (weakReference == null || (nk0Var = weakReference.get()) == null) {
                nk0 nk0Var2 = new nk0(yj0Var);
                a.put(yj0Var.e(), new WeakReference<>(nk0Var2));
                return nk0Var2;
            }
            return nk0Var;
        }
        return (nk0) invokeL.objValue;
    }

    public static void b(@NonNull yj0 yj0Var) {
        WeakReference<nk0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, yj0Var) == null) && (remove = a.remove(yj0Var.e())) != null) {
            remove.clear();
        }
    }
}
