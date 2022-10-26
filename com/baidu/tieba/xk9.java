package com.baidu.tieba;

import com.baidu.tieba.kr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class xk9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ xk9 a = new xk9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ xk9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? kr9.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
    }
}
