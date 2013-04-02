package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements DialogInterface.OnClickListener {
    final /* synthetic */ bz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.a = bzVar;
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
