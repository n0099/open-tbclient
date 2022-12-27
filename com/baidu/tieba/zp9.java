package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class zp9 implements ew9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ zp9 a = new zp9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ zp9() {
    }

    @Override // com.baidu.tieba.ew9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? ir9.h(objectInput) : invokeL.objValue;
    }
}
