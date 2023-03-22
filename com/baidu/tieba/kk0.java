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
public class kk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<lk0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947915833, "Lcom/baidu/tieba/kk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947915833, "Lcom/baidu/tieba/kk0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static lk0 a(@NonNull wj0 wj0Var) {
        InterceptResult invokeL;
        lk0 lk0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wj0Var)) == null) {
            WeakReference<lk0> weakReference = a.get(wj0Var.e());
            if (weakReference == null || (lk0Var = weakReference.get()) == null) {
                lk0 lk0Var2 = new lk0(wj0Var);
                a.put(wj0Var.e(), new WeakReference<>(lk0Var2));
                return lk0Var2;
            }
            return lk0Var;
        }
        return (lk0) invokeL.objValue;
    }

    public static void b(@NonNull wj0 wj0Var) {
        WeakReference<lk0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, wj0Var) == null) && (remove = a.remove(wj0Var.e())) != null) {
            remove.clear();
        }
    }
}
