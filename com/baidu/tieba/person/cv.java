package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements DialogInterface.OnClickListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.q();
        } else if (i == 1) {
            com.baidu.tieba.write.bz.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tieba.write.bz.d(this.a.getActivity());
        }
    }
}
