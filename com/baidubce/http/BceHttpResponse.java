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
/* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public InputStream getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.content : (InputStream) invokeV.objValue;
    }

    public String getHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.httpResponse.header(str, null) : (String) invokeL.objValue;
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
            } catch (Exception e2) {
                BLog.error("Invalid " + str + ":" + header, (Throwable) e2);
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
            } catch (Exception e2) {
                BLog.error("Invalid " + str + ":" + header, (Throwable) e2);
                return null;
            }
        }
        return (Date) invokeL.objValue;
    }

    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            okhttp3.Headers headers = getHttpResponse().headers();
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < headers.size(); i2++) {
                hashMap.put(headers.name(i2), headers.value(i2));
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Response getHttpResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.httpResponse : (Response) invokeV.objValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.httpResponse.code() : invokeV.intValue;
    }

    public String getStatusText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.httpResponse.message() : (String) invokeV.objValue;
    }
}
