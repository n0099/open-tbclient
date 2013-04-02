package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements DialogInterface.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.an anVar;
        com.baidu.tieba.a.an anVar2;
        if (i == 0) {
            anVar = this.a.w;
            if (anVar != null) {
                anVar2 = this.a.w;
                anVar2.d(this.a);
            }
            this.a.w = null;
        }
    }
}
