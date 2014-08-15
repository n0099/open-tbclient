package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        postActivity = this.a.b;
        postActivity.d();
    }
}
