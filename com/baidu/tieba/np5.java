package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: ChatBoxDialogService.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class np5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static op5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return (op5) ServiceManager.getService(op5.a);
        }
        return (op5) invokeV.objValue;
    }
}
