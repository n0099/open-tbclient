package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class b implements SapiWebView.OnFinishCallback {
    final /* synthetic */ WXEntryActivity eud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WXEntryActivity wXEntryActivity) {
        this.eud = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.eud.closeActivity();
    }
}
