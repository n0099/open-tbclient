package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: GroupChatService.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class rp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sp5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return (sp5) ServiceManager.getService(sp5.a);
        }
        return (sp5) invokeV.objValue;
    }
}
