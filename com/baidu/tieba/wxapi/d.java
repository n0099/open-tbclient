package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity fMW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.fMW = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.fMW.showToast(r.l.wxentry_not_install);
        this.fMW.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.fMW.showToast(this.fMW.getResources().getString(r.l.error_system, str));
        this.fMW.closeActivity();
    }
}
