package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity enX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForgetPwdActivity forgetPwdActivity) {
        this.enX = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.enX.enW;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.enX.enW;
            sapiWebView2.goBack();
            return;
        }
        this.enX.finish();
    }
}
