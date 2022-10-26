package com.baidu.turbonet.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public class UrlRequestException extends IOException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_ADDRESS_UNREACHABLE = 9;
    public static final int ERROR_CONNECTION_CLOSED = 5;
    public static final int ERROR_CONNECTION_REFUSED = 7;
    public static final int ERROR_CONNECTION_RESET = 8;
    public static final int ERROR_CONNECTION_TIMED_OUT = 6;
    public static final int ERROR_HOSTNAME_NOT_RESOLVED = 1;
    public static final int ERROR_INTERNET_DISCONNECTED = 2;
    public static final int ERROR_LISTENER_EXCEPTION_THROWN = 0;
    public static final int ERROR_NETWORK_CHANGED = 3;
    public static final int ERROR_OTHER = 12;
    public static final int ERROR_QUIC_PROTOCOL_FAILED = 11;
    public static final int ERROR_TIMED_OUT = 4;
    public static final int ERROR_ZERORTT_HANDSHAKE_ERROR = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mCronetInternalErrorCode;
    public final int mErrorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlRequestException(String str, int i, int i2) {
        super(str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mErrorCode = i;
        this.mCronetInternalErrorCode = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlRequestException(String str, Throwable th) {
        super(str, th);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, th};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mErrorCode = 0;
        this.mCronetInternalErrorCode = 0;
    }

    public int getCronetInternalErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCronetInternalErrorCode;
        }
        return invokeV.intValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mErrorCode;
        }
        return invokeV.intValue;
    }

    public boolean immediatelyRetryable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.mErrorCode;
            if (i != 3 && i != 4 && i != 5 && i != 6 && i != 8 && i != 10) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
