package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements SapiWebView.OnBackCallback {
    final /* synthetic */ SapiWebViewActivity dLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SapiWebViewActivity sapiWebViewActivity) {
        this.dLP = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.dLP.goBack();
    }
}
