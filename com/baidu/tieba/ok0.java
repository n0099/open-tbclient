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
public class ok0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<pk0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948034997, "Lcom/baidu/tieba/ok0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948034997, "Lcom/baidu/tieba/ok0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static pk0 a(@NonNull ak0 ak0Var) {
        InterceptResult invokeL;
        pk0 pk0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ak0Var)) == null) {
            WeakReference<pk0> weakReference = a.get(ak0Var.e());
            if (weakReference == null || (pk0Var = weakReference.get()) == null) {
                pk0 pk0Var2 = new pk0(ak0Var);
                a.put(ak0Var.e(), new WeakReference<>(pk0Var2));
                return pk0Var2;
            }
            return pk0Var;
        }
        return (pk0) invokeL.objValue;
    }

    public static void b(@NonNull ak0 ak0Var) {
        WeakReference<pk0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, ak0Var) == null) && (remove = a.remove(ak0Var.e())) != null) {
            remove.clear();
        }
    }
}
