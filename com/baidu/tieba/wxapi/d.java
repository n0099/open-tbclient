package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity ggj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.ggj = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.ggj.showToast(t.j.wxentry_not_install);
        this.ggj.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.ggj.showToast(this.ggj.getResources().getString(t.j.error_system, str));
        this.ggj.closeActivity();
    }
}
