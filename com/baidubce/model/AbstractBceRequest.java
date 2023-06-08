package com.baidubce.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import okhttp3.Call;
/* loaded from: classes9.dex */
public abstract class AbstractBceRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Call call;
    public boolean canceled;
    public BceCredentials credentials;

    public abstract AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials);

    public AbstractBceRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.canceled = false;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Call call = this.call;
            if (call != null) {
                call.cancel();
            }
            this.canceled = true;
        }
    }

    public boolean getCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.canceled;
        }
        return invokeV.booleanValue;
    }

    public BceCredentials getRequestCredentials() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.credentials;
        }
        return (BceCredentials) invokeV.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Call call = this.call;
            if (call == null) {
                return this.canceled;
            }
            return call.isCanceled();
        }
        return invokeV.booleanValue;
    }

    public void setCall(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, call) == null) {
            this.call = call;
        }
    }

    public void setRequestCredentials(BceCredentials bceCredentials) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bceCredentials) == null) {
            this.credentials = bceCredentials;
        }
    }
}
