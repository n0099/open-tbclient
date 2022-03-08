package com.baidubce.auth;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.CheckUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class DefaultBceCredentials implements BceCredentials {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String accessKeyId;
    public final String secretKey;

    public DefaultBceCredentials(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CheckUtils.isNotNull(str, "accessKeyId should not be null.");
        CheckUtils.checkArgument(!str.isEmpty(), "accessKeyId should not be empty.");
        CheckUtils.isNotNull(str2, "secretKey should not be null.");
        CheckUtils.checkArgument(!str2.isEmpty(), "secretKey should not be empty.");
        this.accessKeyId = str;
        this.secretKey = str2;
    }

    @Override // com.baidubce.auth.BceCredentials
    public String getAccessKeyId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.accessKeyId : (String) invokeV.objValue;
    }

    @Override // com.baidubce.auth.BceCredentials
    public String getSecretKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.secretKey : (String) invokeV.objValue;
    }
}
