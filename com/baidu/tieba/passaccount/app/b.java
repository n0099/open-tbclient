package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity dUF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FillUProfileActivity fillUProfileActivity) {
        this.dUF = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.dUF.dUE;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.dUF.dUE;
            sapiWebView2.goBack();
            return;
        }
        this.dUF.finish();
    }
}
