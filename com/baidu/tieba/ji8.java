package com.baidu.tieba;

import com.baidu.searchbox.live.imp.LiveUserSecurityDeviceInfoServiceImpl;
import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class ji8 extends qj1<LiveUserSecurityDeviceInfoService> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ji8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qj1
    /* renamed from: a */
    public LiveUserSecurityDeviceInfoService createService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new LiveUserSecurityDeviceInfoServiceImpl();
        }
        return (LiveUserSecurityDeviceInfoService) invokeV.objValue;
    }
}
