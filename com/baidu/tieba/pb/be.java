package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class be implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.b != null) {
            if (i == 0) {
                this.a.b.c(this.a);
                this.a.b = null;
            } else if (i == 1) {
                this.a.a(this.a.b);
            }
        }
    }
}
