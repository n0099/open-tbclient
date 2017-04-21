package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity eeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForgetPwdActivity forgetPwdActivity) {
        this.eeY = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.eeY.eeX;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.eeY.eeX;
            sapiWebView2.goBack();
            return;
        }
        this.eeY.finish();
    }
}
