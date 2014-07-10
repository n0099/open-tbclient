package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements DialogInterface.OnClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cr crVar) {
        this.a = crVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.p();
        } else if (i == 1) {
            com.baidu.tbadk.core.util.bj.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tbadk.core.util.bj.c(this.a.getActivity());
        }
    }
}
