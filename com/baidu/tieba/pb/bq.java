package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements DialogInterface.OnClickListener {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.a = bpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        PbActivity pbActivity;
        int i2;
        pbActivity = this.a.b;
        i2 = this.a.d;
        pbActivity.c(i2);
    }
}
