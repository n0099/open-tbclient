package com.baidu.wallet.api;

import android.content.Context;
/* loaded from: classes8.dex */
public interface IWalletCreditFacade {

    /* loaded from: classes8.dex */
    public interface Callback {
        void onResult(boolean z, String str);
    }

    void getUserFinancialInfo(Context context, Callback callback);
}
