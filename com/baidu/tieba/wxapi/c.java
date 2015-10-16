package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity dqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.dqT = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.dqT.showToast(i.h.wxentry_not_install);
        this.dqT.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.dqT.showToast(this.dqT.getResources().getString(i.h.error_system, str));
        this.dqT.closeActivity();
    }
}
