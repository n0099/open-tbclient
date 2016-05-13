package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity feR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.feR = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.feR.showToast(t.j.wxentry_not_install);
        this.feR.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.feR.showToast(this.feR.getResources().getString(t.j.error_system, str));
        this.feR.closeActivity();
    }
}
