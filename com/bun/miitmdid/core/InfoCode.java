package com.bun.miitmdid.core;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class InfoCode {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final int INIT_ERROR_CERT_ERROR = 1008616;
    @Keep
    public static final int INIT_ERROR_DEVICE_NOSUPPORT = 1008612;
    @Keep
    public static final int INIT_ERROR_LOAD_CONFIGFILE = 1008613;
    @Keep
    public static final int INIT_ERROR_MANUFACTURER_NOSUPPORT = 1008611;
    @Keep
    public static final int INIT_ERROR_SDK_CALL_ERROR = 1008615;
    @Keep
    public static final int INIT_INFO_RESULT_DELAY = 1008614;
    @Keep
    public static final int INIT_INFO_RESULT_OK = 1008610;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    public InfoCode() {
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
}
