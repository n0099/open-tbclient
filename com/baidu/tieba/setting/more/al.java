package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class al implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity dLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SapiWebViewActivity sapiWebViewActivity) {
        this.dLP = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.dLP.showToast(t.j.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bi.ag(this.dLP.getPageContext().getPageActivity());
        this.dLP.finish();
    }
}
