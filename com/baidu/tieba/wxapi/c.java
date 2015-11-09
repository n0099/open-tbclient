package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity dsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WXEntryActivity wXEntryActivity) {
        this.dsL = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.dsL.showToast(i.h.wxentry_not_install);
        this.dsL.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.dsL.showToast(this.dsL.getResources().getString(i.h.error_system, str));
        this.dsL.closeActivity();
    }
}
