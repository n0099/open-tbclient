package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements DialogInterface.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.an anVar;
        com.baidu.tieba.a.an anVar2;
        if (i == 0) {
            anVar = this.a.A;
            if (anVar != null) {
                anVar2 = this.a.A;
                anVar2.d(this.a);
            }
            this.a.A = null;
        }
    }
}
