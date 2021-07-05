package com.bytedance.sdk.component.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
/* loaded from: classes6.dex */
public class NetResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHE_DISPATCH_FAIL_CODE = 607;
    public static final int CONNECT_FAIL_CODE = 601;
    public static final int CONNECT_TIMEOUT_CODE = 602;
    public static final int DOWNLOAD_FILE_CANCEL_FAIL_CODE = 611;
    public static final int DOWNLOAD_FILE_INVALID_FAIL_CODE = 610;
    public static final int IMAGE_OOM_FAIL_CODE = 612;
    public static final int NETWORK_DISPATCH_FAIL_CODE = 608;
    public static final int NETWORK_FAIL_CODE = 603;
    public static final int PARSE_RESPONSE_CONTENT_FAIL_CODE = 606;
    public static final int PARSE_RESPONSE_FAIL_CODE = 605;
    public static final int RENAME_DOWNLOAD_FILE_FAIL_CODE = 609;
    public static final int UNSUPPORT_ENCODE_FAIL_CODE = 604;
    public transient /* synthetic */ FieldHolder $fh;
    public final String body;
    public final int code;
    public File file;
    public final Map<String, String> headers;
    public final boolean isSuccess;
    public final String message;
    public final long receivedResponseAtMillis;
    public final long sentRequestAtMillis;

    public NetResponse(boolean z, int i2, String str, Map<String, String> map, String str2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), str, map, str2, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.file = null;
        this.isSuccess = z;
        this.code = i2;
        this.message = str;
        this.headers = map;
        this.body = str2;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (String) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.code : invokeV.intValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sentRequestAtMillis - this.receivedResponseAtMillis : invokeV.longValue;
    }

    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.file : (File) invokeV.objValue;
    }

    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.headers : (Map) invokeV.objValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public long getReceivedResponseAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.receivedResponseAtMillis : invokeV.longValue;
    }

    public long getSentRequestAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sentRequestAtMillis : invokeV.longValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isSuccess : invokeV.booleanValue;
    }

    public void setFile(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, file) == null) {
            this.file = file;
        }
    }
}
