package com.baidu.tieba.square;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnClickListener {
    final /* synthetic */ bb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.a = bbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.a.a.D;
        if (i2 == 0) {
            DatabaseService.q();
            this.a.a.f();
            return;
        }
        DatabaseService.r();
        this.a.a.g();
    }
}
