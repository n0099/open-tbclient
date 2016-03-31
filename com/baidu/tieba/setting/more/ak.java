package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ SapiWebViewActivity eep;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(SapiWebViewActivity sapiWebViewActivity) {
        this.eep = sapiWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eep.goBack();
    }
}
