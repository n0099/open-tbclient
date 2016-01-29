package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class ak implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiWebViewActivity dLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SapiWebViewActivity sapiWebViewActivity) {
        this.dLP = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.dLP.finish();
    }
}
