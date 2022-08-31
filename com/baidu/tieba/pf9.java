package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class pf9 implements ol9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ pf9 a = new pf9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ pf9() {
    }

    @Override // com.baidu.tieba.ol9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? sg9.c(objectInput) : invokeL.objValue;
    }
}
