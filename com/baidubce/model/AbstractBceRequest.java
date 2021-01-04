package com.baidubce.model;

import com.baidubce.auth.BceCredentials;
import okhttp3.Call;
/* loaded from: classes6.dex */
public abstract class AbstractBceRequest {
    private Call call;
    private boolean canceled = false;
    private BceCredentials credentials;

    public abstract AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials);

    public BceCredentials getRequestCredentials() {
        return this.credentials;
    }

    public void setRequestCredentials(BceCredentials bceCredentials) {
        this.credentials = bceCredentials;
    }

    public void cancel() {
        if (this.call != null) {
            this.call.cancel();
        }
        this.canceled = true;
    }

    public boolean getCanceled() {
        return this.canceled;
    }

    public boolean isCanceled() {
        return this.call == null ? this.canceled : this.call.isCanceled();
    }

    public void setCall(Call call) {
        this.call = call;
    }
}
