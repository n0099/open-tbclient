package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity cde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForgetPwdActivity forgetPwdActivity) {
        this.cde = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.cde.cdc;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.cde.cdc;
            sapiWebView2.goBack();
            return;
        }
        this.cde.finish();
    }
}
