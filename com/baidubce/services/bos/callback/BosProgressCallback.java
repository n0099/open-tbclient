package com.baidubce.services.bos.callback;

import com.baidubce.callback.BceProgressCallback;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes6.dex */
public abstract class BosProgressCallback<T extends AbstractBceRequest> implements BceProgressCallback<T> {
    @Deprecated
    public void onProgress(long j, long j2) {
    }

    @Override // com.baidubce.callback.BceProgressCallback
    public void onProgress(T t, long j, long j2) {
        onProgress(j, j2);
    }
}
