package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ AppsActivity btK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AppsActivity appsActivity) {
        this.btK = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.btK.finish();
    }
}
