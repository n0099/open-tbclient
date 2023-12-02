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
/* loaded from: classes7.dex */
public final class px0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948077281, "Lcom/baidu/tieba/px0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948077281, "Lcom/baidu/tieba/px0;");
                return;
            }
        }
        k31.a(253.0f);
        k31.a(9.0f);
    }

    public static final cv0 a(ArrayList<yu0> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<yu0> it = arrayList.iterator();
                while (it.hasNext()) {
                    yu0 next = it.next();
                    if (next instanceof cv0) {
                        return (cv0) next;
                    }
                }
                return null;
            }
            return null;
        }
        return (cv0) invokeL.objValue;
    }
}
