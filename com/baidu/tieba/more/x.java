package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.a = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tieba.h.a.a().a(true);
                com.baidu.tieba.h.a.a().c(0);
                break;
            case 1:
                com.baidu.tieba.h.a.a().a(true);
                com.baidu.tieba.h.a.a().c(1);
                break;
            case 2:
                com.baidu.tieba.h.a.a().a(true);
                com.baidu.tieba.h.a.a().c(2);
                break;
            case 3:
                com.baidu.tieba.h.a.a().a(false);
                break;
        }
        this.a.B();
        this.a.q();
    }
}
