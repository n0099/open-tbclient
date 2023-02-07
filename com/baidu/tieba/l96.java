package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class l96 implements z96 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ l96 a = new l96();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ l96() {
    }

    @Override // com.baidu.tieba.z96, java.util.concurrent.Callable
    public final Object call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hc6.e() : invokeV.objValue;
    }
}
