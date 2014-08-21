package com.baidu.tieba.mention;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.a = aiVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PostActivity postActivity;
        if (dialogInterface instanceof Dialog) {
            postActivity = this.a.b;
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, postActivity);
        }
    }
}
