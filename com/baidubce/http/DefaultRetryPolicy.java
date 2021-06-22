package com.baidubce.http;

import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.ErrorCode;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import java.io.IOException;
/* loaded from: classes6.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final int SCALE_FACTOR = 300;
    public long maxDelayInMillis;
    public int maxErrorRetry;

    public DefaultRetryPolicy() {
        this(3, 30000L);
    }

    @Override // com.baidubce.http.RetryPolicy
    public long getDelayBeforeNextRetryInMillis(BceClientException bceClientException, int i2) {
        if (shouldRetry(bceClientException, i2)) {
            if (i2 < 0) {
                return 0L;
            }
            return (1 << (i2 + 1)) * 300;
        }
        return -1L;
    }

    @Override // com.baidubce.http.RetryPolicy
    public long getMaxDelayInMillis() {
        return this.maxDelayInMillis;
    }

    @Override // com.baidubce.http.RetryPolicy
    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public boolean shouldRetry(BceClientException bceClientException, int i2) {
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

    public DefaultRetryPolicy(int i2, long j) {
        CheckUtils.checkArgument(i2 >= 0, "maxErrorRetry should be a non-negative.");
        CheckUtils.checkArgument(j >= 0, "maxDelayInMillis should be a non-negative.");
        this.maxErrorRetry = i2;
        this.maxDelayInMillis = j;
    }
}
