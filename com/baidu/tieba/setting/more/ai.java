package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ai implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity cOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiWebViewActivity sapiWebViewActivity) {
        this.cOh = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.cOh.showToast(i.h.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bc.ag(this.cOh.getPageContext().getPageActivity());
        this.cOh.finish();
    }
}
