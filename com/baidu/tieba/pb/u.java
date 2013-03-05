package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnCancelListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ai aiVar;
        ai aiVar2;
        this.a.c();
        aiVar = this.a.v;
        if (aiVar != null) {
            aiVar2 = this.a.v;
            aiVar2.a();
        }
    }
}
