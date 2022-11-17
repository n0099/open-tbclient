package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class pm9 implements us9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ pm9 a = new pm9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ pm9() {
    }

    @Override // com.baidu.tieba.us9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? yn9.h(objectInput) : invokeL.objValue;
    }
}
