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
public class zk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<al0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948362698, "Lcom/baidu/tieba/zk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948362698, "Lcom/baidu/tieba/zk0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static al0 a(@NonNull lk0 lk0Var) {
        InterceptResult invokeL;
        al0 al0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lk0Var)) == null) {
            WeakReference<al0> weakReference = a.get(lk0Var.e());
            if (weakReference == null || (al0Var = weakReference.get()) == null) {
                al0 al0Var2 = new al0(lk0Var);
                a.put(lk0Var.e(), new WeakReference<>(al0Var2));
                return al0Var2;
            }
            return al0Var;
        }
        return (al0) invokeL.objValue;
    }

    public static void b(@NonNull lk0 lk0Var) {
        WeakReference<al0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, lk0Var) == null) && (remove = a.remove(lk0Var.e())) != null) {
            remove.clear();
        }
    }
}
