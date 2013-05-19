package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bl blVar;
        NewPbActivity newPbActivity = this.a;
        blVar = this.a.o;
        newPbActivity.p = blVar.S();
        if (i == 0) {
            com.baidu.tieba.write.bb.a(this.a);
        } else if (i == 1) {
            com.baidu.tieba.write.bb.b(this.a);
        }
    }
}
