package com.baidubce.services.bos.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.AbstractBceRequest;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class GeneratePresignedUrlRequest extends AbstractBceRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bucketName;
    public String contentMd5;
    public String contentType;
    public int expirationInSeconds;
    public String key;
    public HttpMethodName method;
    public Map<String, String> requestHeaders;
    public Map<String, String> requestParameters;
    public ResponseHeaderOverrides responseHeaders;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GeneratePresignedUrlRequest(String str, String str2) {
        this(str, str2, HttpMethodName.GET);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (HttpMethodName) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void addRequestHeaders(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.requestHeaders.put(str, str2);
        }
    }

    public void addRequestParameter(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.requestParameters.put(str, str2);
        }
    }

    public String getBucketName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bucketName : (String) invokeV.objValue;
    }

    public String getContentMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.contentMd5 : (String) invokeV.objValue;
    }

    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.contentType : (String) invokeV.objValue;
    }

    public int getExpiration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.expirationInSeconds : invokeV.intValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.key : (String) invokeV.objValue;
    }

    public HttpMethodName getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.method : (HttpMethodName) invokeV.objValue;
    }

    public Map<String, String> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.requestHeaders : (Map) invokeV.objValue;
    }

    public Map<String, String> getRequestParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.requestParameters : (Map) invokeV.objValue;
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.responseHeaders : (ResponseHeaderOverrides) invokeV.objValue;
    }

    public void setBucketName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.bucketName = str;
        }
    }

    public void setContentMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.contentMd5 = str;
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.contentType = str;
        }
    }

    public void setExpiration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.expirationInSeconds = i;
        }
    }

    public void setKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.key = str;
        }
    }

    public void setMethod(HttpMethodName httpMethodName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, httpMethodName) == null) {
            this.method = httpMethodName;
        }
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, responseHeaderOverrides) == null) {
            this.responseHeaders = responseHeaderOverrides;
        }
    }

    public GeneratePresignedUrlRequest withBucketName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            setBucketName(str);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }

    public GeneratePresignedUrlRequest withContentMd5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.contentMd5 = str;
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }

    public GeneratePresignedUrlRequest withContentType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            setContentType(str);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }

    public GeneratePresignedUrlRequest withExpiration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            setExpiration(i);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeI.objValue;
    }

    public GeneratePresignedUrlRequest withKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            setKey(str);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }

    public GeneratePresignedUrlRequest withMethod(HttpMethodName httpMethodName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, httpMethodName)) == null) {
            setMethod(httpMethodName);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }

    public GeneratePresignedUrlRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, responseHeaderOverrides)) == null) {
            setResponseHeaders(responseHeaderOverrides);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }

    public GeneratePresignedUrlRequest(String str, String str2, HttpMethodName httpMethodName) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, httpMethodName};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.expirationInSeconds = -1;
        this.requestParameters = new HashMap();
        this.requestHeaders = new HashMap();
        this.bucketName = str;
        this.key = str2;
        this.method = httpMethodName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GeneratePresignedUrlRequest withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (GeneratePresignedUrlRequest) invokeL.objValue;
    }
}
