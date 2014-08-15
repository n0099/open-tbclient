package com.baidu.tieba.pb.image;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            ax.a(this.a);
        } else {
            ax.b(this.a);
        }
    }
}
