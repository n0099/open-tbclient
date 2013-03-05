package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements DialogInterface.OnClickListener {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar) {
        this.a = bwVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PbActivity pbActivity;
        int i2;
        pbActivity = this.a.b;
        i2 = this.a.d;
        pbActivity.e(i2);
    }
}
