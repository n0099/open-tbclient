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
/* loaded from: classes8.dex */
public final class vw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255066, "Lcom/baidu/tieba/vw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255066, "Lcom/baidu/tieba/vw0;");
                return;
            }
        }
        q21.a(253.0f);
        q21.a(9.0f);
    }

    public static final iu0 a(ArrayList<eu0> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<eu0> it = arrayList.iterator();
                while (it.hasNext()) {
                    eu0 next = it.next();
                    if (next instanceof iu0) {
                        return (iu0) next;
                    }
                }
                return null;
            }
            return null;
        }
        return (iu0) invokeL.objValue;
    }
}
