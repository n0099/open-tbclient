package com.baidubce.callback;

import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes12.dex */
public interface BceProgressCallback<T extends AbstractBceRequest> {
    void onProgress(T t, long j2, long j3);
}
