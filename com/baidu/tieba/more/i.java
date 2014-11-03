package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ AppsActivity bqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AppsActivity appsActivity) {
        this.bqw = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bqw.finish();
    }
}
