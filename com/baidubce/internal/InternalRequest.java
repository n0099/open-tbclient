package com.baidubce.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.AbstractBceRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class InternalRequest<T extends AbstractBceRequest> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RestartableInputStream content;
    public BceCredentials credentials;
    public boolean expectContinueEnabled;
    public Map<String, String> headers;
    public HttpMethodName httpMethod;
    public Map<String, String> parameters;
    public T request;
    public SignOptions signOptions;
    public URI uri;

    public InternalRequest(HttpMethodName httpMethodName, URI uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpMethodName, uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parameters = new HashMap();
        this.headers = new HashMap();
        this.httpMethod = httpMethodName;
        this.uri = uri;
    }

    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.headers.put(str, str2);
        }
    }

    public void addParameter(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.parameters.put(str, str2);
        }
    }

    public RestartableInputStream getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.content;
        }
        return (RestartableInputStream) invokeV.objValue;
    }

    public BceCredentials getCredentials() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.credentials;
        }
        return (BceCredentials) invokeV.objValue;
    }

    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.headers;
        }
        return (Map) invokeV.objValue;
    }

    public HttpMethodName getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.httpMethod;
        }
        return (HttpMethodName) invokeV.objValue;
    }

    public Map<String, String> getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.parameters;
        }
        return (Map) invokeV.objValue;
    }

    public T getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.request;
        }
        return (T) invokeV.objValue;
    }

    public SignOptions getSignOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.signOptions;
        }
        return (SignOptions) invokeV.objValue;
    }

    public URI getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.uri;
        }
        return (URI) invokeV.objValue;
    }

    public boolean isExpectContinueEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.expectContinueEnabled;
        }
        return invokeV.booleanValue;
    }

    public void setContent(RestartableInputStream restartableInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, restartableInputStream) == null) {
            this.content = restartableInputStream;
        }
    }

    public void setCredentials(BceCredentials bceCredentials) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bceCredentials) == null) {
            this.credentials = bceCredentials;
        }
    }

    public void setExpectContinueEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.expectContinueEnabled = z;
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            this.headers.clear();
            this.headers.putAll(map);
        }
    }

    public void setParameters(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, map) == null) {
            this.parameters.clear();
            this.parameters.putAll(map);
        }
    }

    public void setRequest(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, t) == null) {
            this.request = t;
        }
    }

    public void setSignOptions(SignOptions signOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, signOptions) == null) {
            this.signOptions = signOptions;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "InternalRequest [httpMethod=" + this.httpMethod + ", uri=" + this.uri + ", expectContinueEnabled=" + this.expectContinueEnabled + ", parameters=" + this.parameters + ", headers=" + this.headers + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
