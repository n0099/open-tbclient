package com.baidubce.model;

import com.baidubce.auth.BceCredentials;
import okhttp3.Call;
/* loaded from: classes6.dex */
public abstract class AbstractBceRequest {
    public Call call;
    public boolean canceled = false;
    public BceCredentials credentials;

    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
        this.canceled = true;
    }

    public boolean getCanceled() {
        return this.canceled;
    }

    public BceCredentials getRequestCredentials() {
        return this.credentials;
    }

    public boolean isCanceled() {
        Call call = this.call;
        if (call == null) {
            return this.canceled;
        }
        return call.isCanceled();
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public void setRequestCredentials(BceCredentials bceCredentials) {
        this.credentials = bceCredentials;
    }

    public abstract AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials);
}
