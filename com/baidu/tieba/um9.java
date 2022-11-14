package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class um9 implements ts9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ um9 a = new um9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ um9() {
    }

    @Override // com.baidu.tieba.ts9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? xn9.c(objectInput) : invokeL.objValue;
    }
}
