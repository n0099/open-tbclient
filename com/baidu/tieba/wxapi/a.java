package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class a implements SapiWebView.OnBackCallback {
    final /* synthetic */ WXEntryActivity eud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.eud = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.eud.closeActivity();
    }
}
