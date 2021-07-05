package com.bytedance.sdk.component.net.callback;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class NetCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NetCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void onDownloadProgress(NetExecutor netExecutor, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{netExecutor, Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    public abstract void onFailure(NetExecutor netExecutor, IOException iOException);

    public abstract void onResponse(NetExecutor netExecutor, NetResponse netResponse);
}
