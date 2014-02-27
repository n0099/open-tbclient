package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.by.a(this.a);
        } else {
            com.baidu.tieba.write.by.b(this.a);
        }
    }
}
