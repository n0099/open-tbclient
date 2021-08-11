package com.bytedance.sdk.component.image;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_CANCEL = 1003;
    public static final int CODE_DECODE_FAIL = 1002;
    public static final int CODE_EXCEPTION = 2000;
    public static final int CODE_NET_FAILED = 1004;
    public static final int CODE_NOT_IMAGE = 1001;
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
