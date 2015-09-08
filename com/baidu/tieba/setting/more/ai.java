package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ai implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity cHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiWebViewActivity sapiWebViewActivity) {
        this.cHg = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.cHg.showToast(i.h.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bb.ag(this.cHg.getPageContext().getPageActivity());
        this.cHg.finish();
    }
}
