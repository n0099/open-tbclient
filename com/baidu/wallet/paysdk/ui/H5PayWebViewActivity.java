package com.baidu.wallet.paysdk.ui;

import com.baidu.wallet.paysdk.PayCallBackManager;
/* loaded from: classes5.dex */
public class H5PayWebViewActivity extends BaseWebViewActivity {
    @Override // com.baidu.wallet.paysdk.ui.BaseWebViewActivity
    public void notifyResultMsg() {
        if (this.mIsSuccessFlag) {
            PayCallBackManager.callBackClientSuccess(this, "");
            this.mIsSuccessFlag = false;
        } else {
            PayCallBackManager.callBackClientCancel(this, "H5PayWebViewActivity.notifyResultMsg().1");
        }
        finish();
    }
}
