package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ai implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity cQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiWebViewActivity sapiWebViewActivity) {
        this.cQc = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.cQc.showToast(i.h.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bd.ag(this.cQc.getPageContext().getPageActivity());
        this.cQc.finish();
    }
}
