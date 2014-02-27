package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class i implements DialogInterface.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.a.a;
        if (onClickListener != null) {
            onClickListener2 = this.a.a;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
