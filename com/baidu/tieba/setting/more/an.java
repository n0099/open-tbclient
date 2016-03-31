package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class an implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity eep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SapiWebViewActivity sapiWebViewActivity) {
        this.eep = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.eep.showToast(t.j.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bl.ac(this.eep.getPageContext().getPageActivity());
        this.eep.finish();
    }
}
