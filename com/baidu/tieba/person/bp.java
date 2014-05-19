package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements DialogInterface.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.t();
        } else if (i == 1) {
            com.baidu.tbadk.core.util.bb.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tbadk.core.util.bb.c(this.a.getActivity());
        }
    }
}
