package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class aj implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiWebViewActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SapiWebViewActivity sapiWebViewActivity) {
        this.doy = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.doy.finish();
    }
}
