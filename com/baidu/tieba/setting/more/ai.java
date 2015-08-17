package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ai implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity cyI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiWebViewActivity sapiWebViewActivity) {
        this.cyI = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.cyI.showToast(i.C0057i.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bb.ag(this.cyI.getPageContext().getPageActivity());
        this.cyI.finish();
    }
}
