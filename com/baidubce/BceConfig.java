package com.baidubce;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BceConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BCE_AUTH_VERSION = "bce-auth-v1";
    public static final String BOS_DELIMITER = "/";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final String VERSION = "1.0.7";
    public transient /* synthetic */ FieldHolder $fh;

    public BceConfig() {
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
