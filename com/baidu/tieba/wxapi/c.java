package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity eud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.eud = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.eud.showToast(t.j.wxentry_not_install);
        this.eud.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.eud.showToast(this.eud.getResources().getString(t.j.error_system, str));
        this.eud.closeActivity();
    }
}
