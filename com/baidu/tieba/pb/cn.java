package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements DialogInterface.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.am amVar;
        com.baidu.tieba.a.am amVar2;
        if (i == 0) {
            amVar = this.a.z;
            if (amVar != null) {
                amVar2 = this.a.z;
                amVar2.d(this.a);
            }
            this.a.z = null;
        }
    }
}
