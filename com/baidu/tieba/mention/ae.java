package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ae implements DialogInterface.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.a = acVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
