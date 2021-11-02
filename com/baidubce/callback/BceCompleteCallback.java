package com.baidubce.callback;

import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
/* loaded from: classes11.dex */
public interface BceCompleteCallback<T> {
    void onFailure(BceClientException bceClientException, BceServiceException bceServiceException);

    void onSuccess(T t);
}
