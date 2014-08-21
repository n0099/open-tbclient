package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnClickListener {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        postActivity = this.a.b;
        postActivity.d();
    }
}
