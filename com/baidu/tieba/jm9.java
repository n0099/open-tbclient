package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class jm9 implements is9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ jm9 a = new jm9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ jm9() {
    }

    @Override // com.baidu.tieba.is9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? mn9.c(objectInput) : invokeL.objValue;
    }
}
