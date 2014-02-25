package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bz.a(this.a);
        } else {
            com.baidu.tieba.write.bz.b(this.a);
        }
    }
}
