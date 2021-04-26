package com.baidubce.http;

import com.baidubce.BceClientException;
/* loaded from: classes5.dex */
public interface RetryPolicy {
    public static final int DEFAULT_MAX_DELAY_IN_MILLIS = 30000;
    public static final int DEFAULT_MAX_ERROR_RETRY = 3;
    public static final DefaultRetryPolicy DEFAULT_RETRY_POLICY = new DefaultRetryPolicy();

    long getDelayBeforeNextRetryInMillis(BceClientException bceClientException, int i2);

    long getMaxDelayInMillis();

    int getMaxErrorRetry();
}
