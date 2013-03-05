package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements DialogInterface.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.al alVar;
        com.baidu.tieba.a.al alVar2;
        if (i == 0) {
            alVar = this.a.A;
            if (alVar != null) {
                alVar2 = this.a.A;
                alVar2.d(this.a);
            }
            this.a.A = null;
        }
    }
}
