package com.baidu.wallet.paysdk.fingerprint;

import android.app.Activity;
import java.io.Serializable;
/* loaded from: classes5.dex */
public interface IFingerprintPay extends Serializable {

    /* loaded from: classes5.dex */
    public enum Action {
        OPEN,
        CLOSE,
        VERIFY
    }

    void close(Activity activity, FingerprintCallback fingerprintCallback);

    void destory();

    void open(Activity activity, FingerprintCallback fingerprintCallback);

    void verify(Activity activity, FingerprintCallback fingerprintCallback);
}
