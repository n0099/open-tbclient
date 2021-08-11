package com.baidubce.services.bos.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes9.dex */
public class ResponseHeaderOverrides extends AbstractBceRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] PARAMETER_ORDER;
    public static final String RESPONSE_HEADER_CACHE_CONTROL = "responseCacheControl";
    public static final String RESPONSE_HEADER_CONTENT_DISPOSITION = "responseContentDisposition";
    public static final String RESPONSE_HEADER_CONTENT_ENCODING = "responseContentEncoding";
    public static final String RESPONSE_HEADER_CONTENT_LANGUAGE = "responseContentLanguage";
    public static final String RESPONSE_HEADER_CONTENT_TYPE = "responseContentType";
    public static final String RESPONSE_HEADER_EXPIRES = "responseExpires";
    public transient /* synthetic */ FieldHolder $fh;
    public String cacheControl;
    public String contentDisposition;
    public String contentEncoding;
    public String contentLanguage;
    public String contentType;
    public String expires;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(14418966, "Lcom/baidubce/services/bos/model/ResponseHeaderOverrides;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(14418966, "Lcom/baidubce/services/bos/model/ResponseHeaderOverrides;");
                return;
            }
        }
        PARAMETER_ORDER = new String[]{RESPONSE_HEADER_CACHE_CONTROL, RESPONSE_HEADER_CONTENT_DISPOSITION, RESPONSE_HEADER_CONTENT_ENCODING, RESPONSE_HEADER_CONTENT_LANGUAGE, RESPONSE_HEADER_CONTENT_TYPE, RESPONSE_HEADER_EXPIRES};
    }

    public ResponseHeaderOverrides() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String getCacheControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cacheControl : (String) invokeV.objValue;
    }

    public String getContentDisposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contentDisposition : (String) invokeV.objValue;
    }

    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.contentEncoding : (String) invokeV.objValue;
    }

    public String getContentLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.contentLanguage : (String) invokeV.objValue;
    }

    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.contentType : (String) invokeV.objValue;
    }

    public String getExpires() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.expires : (String) invokeV.objValue;
    }

    public void setCacheControl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.cacheControl = str;
        }
    }

    public void setContentDisposition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.contentDisposition = str;
        }
    }

    public void setContentEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.contentEncoding = str;
        }
    }

    public void setContentLanguage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.contentLanguage = str;
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.contentType = str;
        }
    }

    public void setExpires(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.expires = str;
        }
    }

    public ResponseHeaderOverrides withCacheControl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            setCacheControl(str);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }

    public ResponseHeaderOverrides withContentDisposition(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            setContentDisposition(str);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }

    public ResponseHeaderOverrides withContentEncoding(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            setContentEncoding(str);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }

    public ResponseHeaderOverrides withContentLanguage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            setContentLanguage(str);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }

    public ResponseHeaderOverrides withContentType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            setContentType(str);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }

    public ResponseHeaderOverrides withExpires(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            setExpires(str);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public ResponseHeaderOverrides withRequestCredentials(BceCredentials bceCredentials) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bceCredentials)) == null) {
            setRequestCredentials(bceCredentials);
            return this;
        }
        return (ResponseHeaderOverrides) invokeL.objValue;
    }
}
