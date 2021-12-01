package com.baidu.wallet.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.UUID;
/* loaded from: classes12.dex */
public class Identifier implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static String sSessionID;
    public transient /* synthetic */ FieldHolder $fh;

    public Identifier() {
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

    public static synchronized String sessionID() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (Identifier.class) {
                if (sSessionID == null) {
                    LogUtil.d("Creating a session id.");
                    sSessionID = UUID.randomUUID().toString();
                }
                str = sSessionID;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
