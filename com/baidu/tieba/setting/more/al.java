package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements SapiWebView.OnBackCallback {
    final /* synthetic */ SapiWebViewActivity eep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SapiWebViewActivity sapiWebViewActivity) {
        this.eep = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        this.eep.goBack();
    }
}
