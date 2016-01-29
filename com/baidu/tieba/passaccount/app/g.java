package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity cGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForgetPwdActivity forgetPwdActivity) {
        this.cGn = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cGn.cGl;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.cGn.cGl;
            sapiWebView2.goBack();
            return;
        }
        this.cGn.finish();
    }
}
