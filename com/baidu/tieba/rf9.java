package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class rf9 implements ql9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ rf9 a = new rf9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ rf9() {
    }

    @Override // com.baidu.tieba.ql9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? ug9.c(objectInput) : invokeL.objValue;
    }
}
