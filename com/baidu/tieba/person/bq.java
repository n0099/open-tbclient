package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bq implements DialogInterface.OnClickListener {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bn bnVar) {
        this.a = bnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.j();
        } else if (i == 1) {
            com.baidu.tbadk.core.util.az.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tbadk.core.util.az.b(this.a.getActivity());
        }
    }
}
