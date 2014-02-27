package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class cv implements DialogInterface.OnClickListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.g();
        } else if (i == 1) {
            com.baidu.tieba.write.by.a(this.a.getActivity());
        } else if (i == 2) {
            com.baidu.tieba.write.by.b(this.a.getActivity());
        }
    }
}
