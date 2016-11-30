package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity eoE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FillUProfileActivity fillUProfileActivity) {
        this.eoE = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.eoE.eoD;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.eoE.eoD;
            sapiWebView2.goBack();
            return;
        }
        this.eoE.finish();
    }
}
