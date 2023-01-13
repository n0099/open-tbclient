package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class z46 implements n56 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ z46 a = new z46();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ z46() {
    }

    @Override // com.baidu.tieba.n56, java.util.concurrent.Callable
    public final Object call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? v76.e() : invokeV.objValue;
    }
}
