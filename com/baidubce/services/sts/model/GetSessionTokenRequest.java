package com.baidubce.services.sts.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes2.dex */
public class GetSessionTokenRequest extends AbstractBceRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String acl;
    public Integer durationSeconds;

    public GetSessionTokenRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.durationSeconds = 43200;
    }

    public String getAcl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.acl : (String) invokeV.objValue;
    }

    public Integer getDurationSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.durationSeconds : (Integer) invokeV.objValue;
    }

    public void setAcl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.acl = str;
        }
    }

    public void setDurationSeconds(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, num) == null) {
            this.durationSeconds = num;
        }
    }

    public GetSessionTokenRequest withAcl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.acl = str;
            return this;
        }
        return (GetSessionTokenRequest) invokeL.objValue;
    }

    public GetSessionTokenRequest withDurationSeconds(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, num)) == null) {
            this.durationSeconds = num;
            return this;
        }
        return (GetSessionTokenRequest) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GetSessionTokenRequest withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (GetSessionTokenRequest) invokeL.objValue;
    }
}
