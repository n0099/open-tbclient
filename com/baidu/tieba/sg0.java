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
public class sg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<tg0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948150317, "Lcom/baidu/tieba/sg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948150317, "Lcom/baidu/tieba/sg0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static tg0 a(@NonNull eg0 eg0Var) {
        InterceptResult invokeL;
        tg0 tg0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eg0Var)) == null) {
            WeakReference<tg0> weakReference = a.get(eg0Var.e());
            if (weakReference == null || (tg0Var = weakReference.get()) == null) {
                tg0 tg0Var2 = new tg0(eg0Var);
                a.put(eg0Var.e(), new WeakReference<>(tg0Var2));
                return tg0Var2;
            }
            return tg0Var;
        }
        return (tg0) invokeL.objValue;
    }

    public static void b(@NonNull eg0 eg0Var) {
        WeakReference<tg0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, eg0Var) == null) && (remove = a.remove(eg0Var.e())) != null) {
            remove.clear();
        }
    }
}
