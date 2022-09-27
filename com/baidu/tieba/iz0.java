package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmName;
@JvmName(name = "LayerUtils")
/* loaded from: classes4.dex */
public final class iz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947870666, "Lcom/baidu/tieba/iz0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947870666, "Lcom/baidu/tieba/iz0;");
                return;
            }
        }
        c41.a(253.0f);
        c41.a(9.0f);
    }

    public static final lw0 a(ArrayList<hw0> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<hw0> it = arrayList.iterator();
                while (it.hasNext()) {
                    hw0 next = it.next();
                    if (next instanceof lw0) {
                        return (lw0) next;
                    }
                }
                return null;
            }
            return null;
        }
        return (lw0) invokeL.objValue;
    }
}
