package com.baidu.tieba.passaccount.app;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ FillUProfileActivity egL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FillUProfileActivity fillUProfileActivity) {
        this.egL = fillUProfileActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.egL.egK;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.egL.egK;
            sapiWebView2.goBack();
            return;
        }
        this.egL.finish();
    }
}
