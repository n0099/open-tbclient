package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class x implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.c != null) {
            if (i == 0) {
                this.a.c.c(this.a);
                this.a.c = null;
            } else if (i == 1) {
                this.a.a(this.a.c);
            }
        }
    }
}
