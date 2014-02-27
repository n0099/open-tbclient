package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bt implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
