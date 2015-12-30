package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class al implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity dvL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SapiWebViewActivity sapiWebViewActivity) {
        this.dvL = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.dvL.showToast(n.j.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bj.ag(this.dvL.getPageContext().getPageActivity());
        this.dvL.finish();
    }
}
