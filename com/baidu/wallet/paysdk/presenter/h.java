package com.baidu.wallet.paysdk.presenter;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
/* loaded from: classes5.dex */
public class h {
    public static PayTypeContract.Presenter a(String str, PayTypeActivity payTypeActivity) {
        if (TextUtils.isEmpty(str)) {
            return new PayTypePresenter(payTypeActivity);
        }
        if (str.equals("FORM_PRECASHIER")) {
            return new PreCashierPayTypePresenter(payTypeActivity);
        }
        if (str.equals("FROM_AUTHORIZE")) {
            return new AuthorizePayTypePresenter(payTypeActivity);
        }
        return new PayTypePresenter(payTypeActivity);
    }
}
