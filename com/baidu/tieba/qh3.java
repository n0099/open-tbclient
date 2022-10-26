package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class qh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SafeVarargs
    public static HashSet a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, objArr)) == null) {
            if (objArr != null && objArr.length > 0) {
                HashSet hashSet = new HashSet(objArr.length);
                Collections.addAll(hashSet, objArr);
                return hashSet;
            }
            return new HashSet();
        }
        return (HashSet) invokeL.objValue;
    }
}
