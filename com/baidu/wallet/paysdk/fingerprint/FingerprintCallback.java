package com.baidu.wallet.paysdk.fingerprint;

import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import java.io.Serializable;
/* loaded from: classes5.dex */
public interface FingerprintCallback extends Serializable {
    public static final int FP_AUTHENCIATE_CANCLE = 1;
    public static final int FP_AUTHENCIATE_FAILED = 2;
    public static final int FP_AUTHENCIATE_SUCCESS = 0;
    public static final int FP_AUTHENCIATE_TURNTO_PWD = 3;

    void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str);
}
