package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class yp9 implements dw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ yp9 a = new yp9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ yp9() {
    }

    @Override // com.baidu.tieba.dw9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? hr9.h(objectInput) : invokeL.objValue;
    }
}
