package com.baidubce.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.BLog;
import com.baidubce.util.DateUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class BceHttpResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream content;
    public Response httpResponse;

    public BceHttpResponse(Response response) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {response};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.httpResponse = response;
        try {
            this.content = response.body().byteStream();
        } catch (Exception unused) {
            this.content = null;
        }
    }

    public long getHeaderAsLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String header = getHeader(str);
            if (header == null) {
                return -1L;
            }
            try {
                return Long.valueOf(header).longValue();
            } catch (Exception e) {
                BLog.error("Invalid " + str + ":" + header, (Throwable) e);
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public Date getHeaderAsRfc822Date(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String header = getHeader(str);
            if (header == null) {
                return null;
            }
            try {
                return DateUtils.parseRfc822Date(header);
            } catch (Exception e) {
                BLog.error("Invalid " + str + ":" + header, (Throwable) e);
                return null;
            }
        }
        return (Date) invokeL.objValue;
    }

    public InputStream getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.content;
        }
        return (InputStream) invokeV.objValue;
    }

    public Response getHttpResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.httpResponse;
        }
        return (Response) invokeV.objValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.httpResponse.code();
        }
        return invokeV.intValue;
    }

    public String getStatusText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.httpResponse.message();
        }
        return (String) invokeV.objValue;
    }

    public String getHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.httpResponse.header(str, null);
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            okhttp3.Headers headers = getHttpResponse().headers();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < headers.size(); i++) {
                hashMap.put(headers.name(i), headers.value(i));
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
