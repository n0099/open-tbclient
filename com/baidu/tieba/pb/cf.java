package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements DialogInterface.OnCancelListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        df dfVar;
        df dfVar2;
        this.a.c();
        dfVar = this.a.G;
        if (dfVar != null) {
            dfVar2 = this.a.G;
            dfVar2.a();
        }
    }
}
