package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: ChatMessageDispatchService.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class n19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static o19 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return (o19) ServiceManager.getService(o19.a);
        }
        return (o19) invokeV.objValue;
    }
}
