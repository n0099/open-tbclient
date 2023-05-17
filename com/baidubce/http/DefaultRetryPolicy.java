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
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public DefaultRetryPolicy(int i, long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        CheckUtils.checkArgument(z, "maxErrorRetry should be a non-negative.");
        CheckUtils.checkArgument(j >= 0, "maxDelayInMillis should be a non-negative.");
        this.maxErrorRetry = i;
        this.maxDelayInMillis = j;
    }

    @Override // com.baidubce.http.RetryPolicy
    public long getDelayBeforeNextRetryInMillis(BceClientException bceClientException, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bceClientException, i)) == null) {
            if (!shouldRetry(bceClientException, i)) {
                return -1L;
            }
            if (i < 0) {
                return 0L;
            }
            return (1 << (i + 1)) * 300;
        }
        return invokeLI.longValue;
    }

    @Override // com.baidubce.http.RetryPolicy
    public long getMaxDelayInMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.maxDelayInMillis;
        }
        return invokeV.longValue;
    }

    @Override // com.baidubce.http.RetryPolicy
    public int getMaxErrorRetry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.maxErrorRetry;
        }
        return invokeV.intValue;
    }

    public boolean shouldRetry(BceClientException bceClientException, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bceClientException, i)) == null) {
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
}
