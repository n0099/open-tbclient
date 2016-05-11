package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class a implements SapiWebView.OnBackCallback {
    final /* synthetic */ WXEntryActivity feS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.feS = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.feS.closeActivity();
    }
}
