package com.baidu.turbonet.net.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.NetworkException;
/* loaded from: classes9.dex */
public class NetworkExceptionImpl extends NetworkException {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mCronetInternalErrorCode;
    public final int mErrorCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-664396737, "Lcom/baidu/turbonet/net/impl/NetworkExceptionImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-664396737, "Lcom/baidu/turbonet/net/impl/NetworkExceptionImpl;");
            }
        }
    }

    @Override // com.baidu.turbonet.net.NetworkException
    public int getCronetInternalErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCronetInternalErrorCode;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.turbonet.net.NetworkException
    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mErrorCode;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.turbonet.net.NetworkException
    public boolean immediatelyRetryable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.mErrorCode;
            if (i != 3 && i != 4 && i != 5 && i != 6 && i != 8) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkExceptionImpl(String str, int i, int i2) {
        super(str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Throwable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mErrorCode = i;
        this.mCronetInternalErrorCode = i2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder(super.getMessage());
            sb.append(", ErrorCode=");
            sb.append(this.mErrorCode);
            if (this.mCronetInternalErrorCode != 0) {
                sb.append(", InternalErrorCode=");
                sb.append(this.mCronetInternalErrorCode);
            }
            sb.append(", Retryable=");
            sb.append(immediatelyRetryable());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
