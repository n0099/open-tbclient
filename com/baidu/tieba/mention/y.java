package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        postActivity = this.a.b;
        postActivity.i();
    }
}
