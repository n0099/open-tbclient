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
        bk bkVar;
        bk bkVar2;
        NewPbActivity newPbActivity = this.a;
        bkVar = this.a.p;
        newPbActivity.q = bkVar.T();
        bkVar2 = this.a.p;
        bkVar2.a();
        if (i == 0) {
            com.baidu.tieba.write.bb.a(this.a);
        } else if (i == 1) {
            com.baidu.tieba.write.bb.b(this.a);
        }
    }
}
