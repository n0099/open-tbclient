package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class om9 implements ts9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ om9 a = new om9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ om9() {
    }

    @Override // com.baidu.tieba.ts9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? xn9.h(objectInput) : invokeL.objValue;
    }
}
