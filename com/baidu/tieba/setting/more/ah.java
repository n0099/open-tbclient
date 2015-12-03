package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ SapiWebViewActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SapiWebViewActivity sapiWebViewActivity) {
        this.doy = sapiWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.doy.goBack();
    }
}
