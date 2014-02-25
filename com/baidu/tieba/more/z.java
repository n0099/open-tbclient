package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar) {
        this.a = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tieba.h.a.a().a(0);
                break;
            case 1:
                com.baidu.tieba.h.a.a().a(1);
                break;
            case 2:
                com.baidu.tieba.h.a.a().a(2);
                break;
        }
        this.a.s();
        this.a.q();
    }
}
