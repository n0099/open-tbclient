package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity feS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.feS = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.feS.showToast(t.j.wxentry_not_install);
        this.feS.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.feS.showToast(this.feS.getResources().getString(t.j.error_system, str));
        this.feS.closeActivity();
    }
}
