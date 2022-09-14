package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class nj9 implements sp9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ nj9 a = new nj9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ nj9() {
    }

    @Override // com.baidu.tieba.sp9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? wk9.h(objectInput) : invokeL.objValue;
    }
}
