package com.baidubce.callback;

import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes2.dex */
public interface BceProgressCallback<T extends AbstractBceRequest> {
    void onProgress(T t, long j2, long j3);
}
