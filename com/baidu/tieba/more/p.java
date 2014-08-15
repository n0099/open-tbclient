package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.h.a().a(0);
                break;
            case 1:
                com.baidu.tbadk.core.h.a().a(1);
                break;
            case 2:
                com.baidu.tbadk.core.h.a().a(2);
                break;
        }
        this.a.o();
        this.a.n();
    }
}
