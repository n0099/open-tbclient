package com.baidu.tieba.wxapi;

import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements SapiWebView.WeixinHandler {
    final /* synthetic */ WXEntryActivity gng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WXEntryActivity wXEntryActivity) {
        this.gng = wXEntryActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleNotInstall() {
        this.gng.showToast(w.l.wxentry_not_install);
        this.gng.closeActivity();
    }

    @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
    public void handleServerError(String str) {
        this.gng.showToast(this.gng.getResources().getString(w.l.error_system, str));
        this.gng.closeActivity();
    }
}
