package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity fKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.fKn = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.fKn.showToast(u.j.wxentry_not_install);
        this.fKn.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.fKn.showToast(this.fKn.getResources().getString(u.j.error_system, str));
        this.fKn.closeActivity();
    }
}
