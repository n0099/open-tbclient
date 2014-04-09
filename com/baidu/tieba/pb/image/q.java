package com.baidu.tieba.pb.image;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
final class q implements DialogInterface.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            az.a(this.a);
        } else {
            az.b(this.a);
        }
    }
}
