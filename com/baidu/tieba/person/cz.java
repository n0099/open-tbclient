package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements DialogInterface.OnClickListener {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ct ctVar) {
        this.a = ctVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.s();
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ax.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tbadk.core.util.ax.c(this.a.getActivity());
        }
    }
}
