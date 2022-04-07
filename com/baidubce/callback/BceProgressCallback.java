package com.baidubce.callback;

import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes4.dex */
public interface BceProgressCallback<T extends AbstractBceRequest> {
    void onProgress(T t, long j, long j2);
}
