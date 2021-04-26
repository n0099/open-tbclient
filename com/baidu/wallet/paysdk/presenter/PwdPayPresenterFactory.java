package com.baidu.wallet.paysdk.presenter;

import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
/* loaded from: classes5.dex */
public class PwdPayPresenterFactory {
    public static final int PWDPAYACTIVITY_FROM_AUTHORIZE = 3;
    public static final int PWDPAYACTIVITY_FROM_CASHDESK = 4;
    public static final String PWDPAYACTIVITY_FROM_KEY = "pwdpayactivity_from_key";
    public static final int PWDPAYACTIVITY_FROM_SCANCODE = 2;

    public static PwdPayContract.Presenter a(int i2, PwdPayActivity pwdPayActivity) {
        if (i2 != 2) {
            if (i2 != 3) {
                return new PwdPayPresenterForCashdesk(pwdPayActivity, pwdPayActivity.getIntent());
            }
            return new PwdPayPresenterForAuthsign(pwdPayActivity);
        }
        return new PwdPayPresenterForScancode(pwdPayActivity, pwdPayActivity.getIntent());
    }
}
