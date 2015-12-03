package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements SapiWebView.OnBackCallback {
    final /* synthetic */ SapiWebViewActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiWebViewActivity sapiWebViewActivity) {
        this.doy = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.doy.goBack();
    }
}
