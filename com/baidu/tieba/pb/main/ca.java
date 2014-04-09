package com.baidu.tieba.pb.main;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ca implements View.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog;
        dialog = this.a.av;
        dialog.dismiss();
    }
}
