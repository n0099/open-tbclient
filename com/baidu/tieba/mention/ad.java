package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        postActivity = this.a.b;
        postActivity.a();
    }
}
