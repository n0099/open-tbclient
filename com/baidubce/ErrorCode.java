package com.baidubce;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class ErrorCode {
    public static final /* synthetic */ ErrorCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ErrorCode ACCESS_DENIED;
    public static final ErrorCode INAPPROPRIATE_JSON;
    public static final ErrorCode INTERNAL_ERROR;
    public static final ErrorCode INVALID_ACCESS_KEY_ID;
    public static final ErrorCode INVALID_HTTP_AUTH_HEADER;
    public static final ErrorCode INVALID_HTTP_REQUEST;
    public static final ErrorCode INVALID_URI;
    public static final ErrorCode INVALID_VERSION;
    public static final ErrorCode MALFORMED_JSON;
    public static final ErrorCode OPT_IN_REQUIRED;
    public static final ErrorCode PRECONDITION_FAILED;
    public static final ErrorCode REQUEST_EXPIRED;
    public static final ErrorCode REQUEST_TIME_TOO_SKEWED;
    public static final ErrorCode SIGNATURE_DOES_NOT_MATCH;
    public transient /* synthetic */ FieldHolder $fh;
    public String code;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(492228882, "Lcom/baidubce/ErrorCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(492228882, "Lcom/baidubce/ErrorCode;");
                return;
            }
        }
        ACCESS_DENIED = new ErrorCode("ACCESS_DENIED", 0, "AccessDenied");
        INAPPROPRIATE_JSON = new ErrorCode("INAPPROPRIATE_JSON", 1, "InappropriateJSON");
        INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, "InternalError");
        INVALID_ACCESS_KEY_ID = new ErrorCode("INVALID_ACCESS_KEY_ID", 3, "InvalidAccessKeyId");
        INVALID_HTTP_AUTH_HEADER = new ErrorCode("INVALID_HTTP_AUTH_HEADER", 4, "InvalidHTTPAuthHeader");
        INVALID_HTTP_REQUEST = new ErrorCode("INVALID_HTTP_REQUEST", 5, "InvalidHTTPRequest");
        INVALID_URI = new ErrorCode("INVALID_URI", 6, "InvalidURI");
        MALFORMED_JSON = new ErrorCode("MALFORMED_JSON", 7, "MalformedJSON");
        INVALID_VERSION = new ErrorCode("INVALID_VERSION", 8, "InvalidVersion");
        OPT_IN_REQUIRED = new ErrorCode("OPT_IN_REQUIRED", 9, "OptInRequired");
        PRECONDITION_FAILED = new ErrorCode("PRECONDITION_FAILED", 10, "PreconditionFailed");
        REQUEST_EXPIRED = new ErrorCode("REQUEST_EXPIRED", 11, "RequestExpired");
        REQUEST_TIME_TOO_SKEWED = new ErrorCode("REQUEST_TIME_TOO_SKEWED", 12, "RequestTimeTooSkewed");
        ErrorCode errorCode = new ErrorCode("SIGNATURE_DOES_NOT_MATCH", 13, "SignatureDoesNotMatch");
        SIGNATURE_DOES_NOT_MATCH = errorCode;
        $VALUES = new ErrorCode[]{ACCESS_DENIED, INAPPROPRIATE_JSON, INTERNAL_ERROR, INVALID_ACCESS_KEY_ID, INVALID_HTTP_AUTH_HEADER, INVALID_HTTP_REQUEST, INVALID_URI, MALFORMED_JSON, INVALID_VERSION, OPT_IN_REQUIRED, PRECONDITION_FAILED, REQUEST_EXPIRED, REQUEST_TIME_TOO_SKEWED, errorCode};
    }

    public ErrorCode(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = str2;
    }

    public static ErrorCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ErrorCode) Enum.valueOf(ErrorCode.class, str) : (ErrorCode) invokeL.objValue;
    }

    public static ErrorCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ErrorCode[]) $VALUES.clone() : (ErrorCode[]) invokeV.objValue;
    }

    public boolean equals(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.code.equals(str) : invokeL.booleanValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.code : (String) invokeV.objValue;
    }
}
