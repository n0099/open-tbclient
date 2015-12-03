package com.baidu.tieba.setting.more;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class ak implements SapiWebView.ChangePwdCallback {
    final /* synthetic */ SapiWebViewActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SapiWebViewActivity sapiWebViewActivity) {
        this.doy = sapiWebViewActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
    public void onSuccess() {
        this.doy.showToast(n.i.succ_modify_pwd);
        SapiAccountManager.getInstance().logout();
        bj.ag(this.doy.getPageContext().getPageActivity());
        this.doy.finish();
    }
}
