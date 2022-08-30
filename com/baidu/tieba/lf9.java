package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class lf9 implements ql9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ lf9 a = new lf9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ lf9() {
    }

    @Override // com.baidu.tieba.ql9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? ug9.h(objectInput) : invokeL.objValue;
    }
}
