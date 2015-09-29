package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class ah implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiWebViewActivity cOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SapiWebViewActivity sapiWebViewActivity) {
        this.cOh = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.cOh.finish();
    }
}
