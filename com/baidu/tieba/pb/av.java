package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.c != null) {
            this.a.c.f(this.a);
            this.a.c = null;
        }
    }
}
