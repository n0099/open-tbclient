package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity eex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FillUProfileActivity fillUProfileActivity) {
        this.eex = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.eex.eew;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.eex.eew;
            sapiWebView2.goBack();
            return;
        }
        this.eex.finish();
    }
}
