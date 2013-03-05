package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements DialogInterface.OnCancelListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dk dkVar;
        dk dkVar2;
        this.a.c();
        dkVar = this.a.G;
        if (dkVar != null) {
            dkVar2 = this.a.G;
            dkVar2.a();
        }
    }
}
