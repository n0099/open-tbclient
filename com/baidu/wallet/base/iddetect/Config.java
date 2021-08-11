package com.baidu.wallet.base.iddetect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class Config {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean IS_DEBUG_MODEL = true;
    public static final int MAX_UPLOAD_TIMES = 50;
    public static final int MIN_INTERVAL_TIME = 200;
    public static final int PICTURE_QUALITY = 70;
    public static final int SOCKET_OPERATION_TIMEOUT = 30000;
    public static final int START_DELAY_TIME = 2000;
    public transient /* synthetic */ FieldHolder $fh;

    public Config() {
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
}
