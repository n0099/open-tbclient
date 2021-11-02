package com.baidu.webkit.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Map;
/* loaded from: classes11.dex */
public class WebResourceResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mEncoding;
    public boolean mImmutable;
    public InputStream mInputStream;
    public String mMimeType;
    public String mReasonPhrase;
    public Map<String, String> mResponseHeaders;
    public int mStatusCode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebResourceResponse(String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, map, inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (InputStream) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setStatusCodeAndReasonPhrase(i2, str3);
        setResponseHeaders(map);
    }

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, inputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMimeType = str;
        this.mEncoding = str2;
        setData(inputStream);
    }

    public WebResourceResponse(boolean z, String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, str2, Integer.valueOf(i2), str3, map, inputStream};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImmutable = z;
        this.mMimeType = str;
        this.mEncoding = str2;
        this.mStatusCode = i2;
        this.mReasonPhrase = str3;
        this.mResponseHeaders = map;
        this.mInputStream = inputStream;
    }

    private void checkImmutable() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mImmutable) {
            throw new IllegalStateException("This WebResourceResponse instance is immutable");
        }
    }

    public InputStream getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInputStream : (InputStream) invokeV.objValue;
    }

    public String getEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEncoding : (String) invokeV.objValue;
    }

    public boolean getImmutable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImmutable : invokeV.booleanValue;
    }

    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMimeType : (String) invokeV.objValue;
    }

    public String getReasonPhrase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mReasonPhrase : (String) invokeV.objValue;
    }

    public Map<String, String> getResponseHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mResponseHeaders : (Map) invokeV.objValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStatusCode : invokeV.intValue;
    }

    public void setData(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, inputStream) == null) {
            checkImmutable();
            if (inputStream != null && StringBufferInputStream.class.isAssignableFrom(inputStream.getClass())) {
                throw new IllegalArgumentException("StringBufferInputStream is deprecated and must not be passed to a WebResourceResponse");
            }
            this.mInputStream = inputStream;
        }
    }

    public void setEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            checkImmutable();
            this.mEncoding = str;
        }
    }

    public void setMimeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            checkImmutable();
            this.mMimeType = str;
        }
    }

    public void setResponseHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            checkImmutable();
            this.mResponseHeaders = map;
        }
    }

    public void setStatusCodeAndReasonPhrase(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            checkImmutable();
            if (i2 < 100) {
                throw new IllegalArgumentException("statusCode can't be less than 100.");
            }
            if (i2 > 599) {
                throw new IllegalArgumentException("statusCode can't be greater than 599.");
            }
            if (i2 > 299 && i2 < 400) {
                throw new IllegalArgumentException("statusCode can't be in the [300, 399] range.");
            }
            if (str == null) {
                throw new IllegalArgumentException("reasonPhrase can't be null.");
            }
            if (str.trim().isEmpty()) {
                throw new IllegalArgumentException("reasonPhrase can't be empty.");
            }
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (str.charAt(i3) > 127) {
                    throw new IllegalArgumentException("reasonPhrase can't contain non-ASCII characters.");
                }
            }
            this.mStatusCode = i2;
            this.mReasonPhrase = str;
        }
    }
}
