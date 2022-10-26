package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ObjectInput;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class uk9 implements zq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ uk9 a = new uk9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ uk9() {
    }

    @Override // com.baidu.tieba.zq9
    public final Object a(ObjectInput objectInput) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectInput)) == null) ? dm9.h(objectInput) : invokeL.objValue;
    }
}
