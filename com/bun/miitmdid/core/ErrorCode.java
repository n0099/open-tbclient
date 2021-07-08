package com.bun.miitmdid.core;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
public class ErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final int INIT_ERROR_BEGIN = 1008610;
    @Keep
    public static final int INIT_ERROR_DEVICE_NOSUPPORT = 1008612;
    @Keep
    public static final int INIT_ERROR_LOAD_CONFIGFILE = 1008613;
    @Keep
    public static final int INIT_ERROR_MANUFACTURER_NOSUPPORT = 1008611;
    @Keep
    public static final int INIT_ERROR_RESULT_DELAY = 1008614;
    @Keep
    public static final int INIT_HELPER_CALL_ERROR = 1008615;
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorCode() {
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
