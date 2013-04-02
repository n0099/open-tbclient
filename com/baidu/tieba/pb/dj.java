package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements DialogInterface.OnCancelListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dm dmVar;
        dm dmVar2;
        this.a.c();
        dmVar = this.a.C;
        if (dmVar != null) {
            dmVar2 = this.a.C;
            dmVar2.a();
        }
    }
}
