package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class am implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiWebViewActivity eep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SapiWebViewActivity sapiWebViewActivity) {
        this.eep = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.eep.finish();
    }
}
