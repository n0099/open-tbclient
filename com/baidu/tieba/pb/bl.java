package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* loaded from: classes.dex */
class bl implements View.OnClickListener {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar) {
        this.a = biVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        Dialog dialog;
        pbActivity = this.a.a;
        dialog = pbActivity.x;
        dialog.dismiss();
    }
}
