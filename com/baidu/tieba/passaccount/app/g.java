package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ ForgetPwdActivity czH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForgetPwdActivity forgetPwdActivity) {
        this.czH = forgetPwdActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.czH.czF;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.czH.czF;
            sapiWebView2.goBack();
            return;
        }
        this.czH.finish();
    }
}
