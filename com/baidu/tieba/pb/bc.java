package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        cr crVar;
        cr crVar2;
        NewPbActivity newPbActivity = this.a;
        crVar = this.a.A;
        newPbActivity.B = crVar.ae();
        crVar2 = this.a.A;
        crVar2.j();
        if (i == 0) {
            com.baidu.tieba.write.bb.a(this.a);
        } else if (i == 1) {
            com.baidu.tieba.write.bb.c(this.a);
        }
    }
}
