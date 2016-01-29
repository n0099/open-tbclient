package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ SapiWebViewActivity dLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiWebViewActivity sapiWebViewActivity) {
        this.dLP = sapiWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dLP.goBack();
    }
}
