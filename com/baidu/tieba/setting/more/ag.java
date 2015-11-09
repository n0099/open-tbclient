package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements SapiWebView.OnBackCallback {
    final /* synthetic */ SapiWebViewActivity cQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SapiWebViewActivity sapiWebViewActivity) {
        this.cQc = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.cQc.goBack();
    }
}
