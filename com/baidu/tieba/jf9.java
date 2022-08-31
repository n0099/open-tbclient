package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class jf9 implements ol9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ jf9 a = new jf9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ jf9() {
    }

    @Override // com.baidu.tieba.ol9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? sg9.h(objectInput) : invokeL.objValue;
    }
}
