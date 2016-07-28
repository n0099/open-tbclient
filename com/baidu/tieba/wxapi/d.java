package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity fWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.fWe = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.fWe.showToast(u.j.wxentry_not_install);
        this.fWe.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.fWe.showToast(this.fWe.getResources().getString(u.j.error_system, str));
        this.fWe.closeActivity();
    }
}
