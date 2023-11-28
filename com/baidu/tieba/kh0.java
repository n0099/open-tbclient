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
public class kh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<lh0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947912950, "Lcom/baidu/tieba/kh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947912950, "Lcom/baidu/tieba/kh0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static lh0 a(@NonNull wg0 wg0Var) {
        InterceptResult invokeL;
        lh0 lh0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wg0Var)) == null) {
            WeakReference<lh0> weakReference = a.get(wg0Var.e());
            if (weakReference == null || (lh0Var = weakReference.get()) == null) {
                lh0 lh0Var2 = new lh0(wg0Var);
                a.put(wg0Var.e(), new WeakReference<>(lh0Var2));
                return lh0Var2;
            }
            return lh0Var;
        }
        return (lh0) invokeL.objValue;
    }

    public static void b(@NonNull wg0 wg0Var) {
        WeakReference<lh0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, wg0Var) == null) && (remove = a.remove(wg0Var.e())) != null) {
            remove.clear();
        }
    }
}
