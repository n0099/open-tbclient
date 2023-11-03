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
public class jh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<kh0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883159, "Lcom/baidu/tieba/jh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883159, "Lcom/baidu/tieba/jh0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static kh0 a(@NonNull vg0 vg0Var) {
        InterceptResult invokeL;
        kh0 kh0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vg0Var)) == null) {
            WeakReference<kh0> weakReference = a.get(vg0Var.e());
            if (weakReference == null || (kh0Var = weakReference.get()) == null) {
                kh0 kh0Var2 = new kh0(vg0Var);
                a.put(vg0Var.e(), new WeakReference<>(kh0Var2));
                return kh0Var2;
            }
            return kh0Var;
        }
        return (kh0) invokeL.objValue;
    }

    public static void b(@NonNull vg0 vg0Var) {
        WeakReference<kh0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, vg0Var) == null) && (remove = a.remove(vg0Var.e())) != null) {
            remove.clear();
        }
    }
}
