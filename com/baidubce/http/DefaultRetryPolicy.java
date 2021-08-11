package com.baidubce.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.ErrorCode;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
/* loaded from: classes9.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SCALE_FACTOR = 300;
    public transient /* synthetic */ FieldHolder $fh;
    public long maxDelayInMillis;
    public int maxErrorRetry;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultRetryPolicy() {
        this(3, 30000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidubce.http.RetryPolicy
    public long getDelayBeforeNextRetryInMillis(BceClientException bceClientException, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bceClientException, i2)) == null) {
            if (shouldRetry(bceClientException, i2)) {
                if (i2 < 0) {
                    return 0L;
                }
                return (1 << (i2 + 1)) * 300;
            }
            return -1L;
        }
        return invokeLI.longValue;
    }

    @Override // com.baidubce.http.RetryPolicy
    public long getMaxDelayInMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.maxDelayInMillis : invokeV.longValue;
    }

    @Override // com.baidubce.http.RetryPolicy
    public int getMaxErrorRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.maxErrorRetry : invokeV.intValue;
    }

    public boolean shouldRetry(BceClientException bceClientException, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bceClientException, i2)) == null) {
            if (bceClientException.getCause() instanceof IOException) {
                BLog.error("Retry for IOException.");
                return true;
            } else if (bceClientException instanceof BceServiceException) {
                BceServiceException bceServiceException = (BceServiceException) bceClientException;
                if (bceServiceException.getStatusCode() == 500) {
                    BLog.error("Retry for internal server error.");
                    return true;
                } else if (bceServiceException.getStatusCode() == 502) {
                    BLog.debug("Retry for bad gateway.");
                    return true;
                } else if (bceServiceException.getStatusCode() == 503) {
                    BLog.error("Retry for service unavailable.");
                    return true;
                } else {
                    String errorCode = bceServiceException.getErrorCode();
                    if (ErrorCode.REQUEST_EXPIRED.equals(errorCode)) {
                        BLog.error("Retry for request expired.");
                        return true;
                    } else if (ErrorCode.REQUEST_TIME_TOO_SKEWED.equals(errorCode)) {
                        BLog.error("Retry for request time too skewed");
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public DefaultRetryPolicy(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        CheckUtils.checkArgument(i2 >= 0, "maxErrorRetry should be a non-negative.");
        CheckUtils.checkArgument(j2 >= 0, "maxDelayInMillis should be a non-negative.");
        this.maxErrorRetry = i2;
        this.maxDelayInMillis = j2;
    }
}
