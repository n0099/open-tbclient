package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements DialogInterface.OnCancelListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dd ddVar;
        dd ddVar2;
        this.a.b();
        ddVar = this.a.F;
        if (ddVar != null) {
            ddVar2 = this.a.F;
            ddVar2.a();
        }
    }
}
