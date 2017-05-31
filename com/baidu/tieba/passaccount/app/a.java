package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity efd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForgetPwdActivity forgetPwdActivity) {
        this.efd = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.efd.efc;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.efd.efc;
            sapiWebView2.goBack();
            return;
        }
        this.efd.finish();
    }
}
