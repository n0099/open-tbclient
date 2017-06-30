package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class b implements SapiWebView.OnBackCallback {
    final /* synthetic */ WXEntryActivity gng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WXEntryActivity wXEntryActivity) {
        this.gng = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.gng.closeActivity();
    }
}
