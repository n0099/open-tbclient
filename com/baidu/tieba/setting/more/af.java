package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ SapiWebViewActivity cOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SapiWebViewActivity sapiWebViewActivity) {
        this.cOh = sapiWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cOh.goBack();
    }
}
