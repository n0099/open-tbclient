package com.baidu.tieba;

import com.baidu.tieba.et9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class rm9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ rm9 a = new rm9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ rm9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? et9.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
    }
}
