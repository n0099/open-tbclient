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
public class vl0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<wl0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244495, "Lcom/baidu/tieba/vl0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244495, "Lcom/baidu/tieba/vl0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static wl0 a(@NonNull hl0 hl0Var) {
        InterceptResult invokeL;
        wl0 wl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hl0Var)) == null) {
            WeakReference<wl0> weakReference = a.get(hl0Var.e());
            if (weakReference == null || (wl0Var = weakReference.get()) == null) {
                wl0 wl0Var2 = new wl0(hl0Var);
                a.put(hl0Var.e(), new WeakReference<>(wl0Var2));
                return wl0Var2;
            }
            return wl0Var;
        }
        return (wl0) invokeL.objValue;
    }

    public static void b(@NonNull hl0 hl0Var) {
        WeakReference<wl0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, hl0Var) == null) && (remove = a.remove(hl0Var.e())) != null) {
            remove.clear();
        }
    }
}
