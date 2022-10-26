package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.internal.api.PidLoader;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class vk9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ vk9 a = new vk9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ vk9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? cr9.e((PidLoader) obj, (PidLoader) obj2) : invokeLL.intValue;
    }
}
