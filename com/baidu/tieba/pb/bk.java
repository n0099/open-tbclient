package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar) {
        this.a = biVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        Dialog dialog;
        pbActivity = this.a.a;
        pbActivity.c(5);
        pbActivity2 = this.a.a;
        dialog = pbActivity2.x;
        dialog.dismiss();
    }
}
