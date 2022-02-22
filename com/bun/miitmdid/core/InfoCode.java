package com.bun.miitmdid.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class InfoCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INIT_ERROR_CERT_ERROR = 1008616;
    public static final int INIT_ERROR_DEVICE_NOSUPPORT = 1008612;
    public static final int INIT_ERROR_LOAD_CONFIGFILE = 1008613;
    public static final int INIT_ERROR_MANUFACTURER_NOSUPPORT = 1008611;
    public static final int INIT_ERROR_SDK_CALL_ERROR = 1008615;
    public static final int INIT_INFO_RESULT_DELAY = 1008614;
    public static final int INIT_INFO_RESULT_OK = 1008610;
    public transient /* synthetic */ FieldHolder $fh;

    public InfoCode() {
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
