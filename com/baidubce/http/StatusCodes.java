package com.baidubce.http;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class StatusCodes {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BAD_GATEWAY = 502;
    public static final int FORBIDDEN = 403;
    public static final int HTTP_OK = 200;
    public static final int INTERNAL_ERROR = 500;
    public static final int NOT_FOUND = 404;
    public static final int SERVICE_UNAVAILABLE = 503;
    public transient /* synthetic */ FieldHolder $fh;

    public StatusCodes() {
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
