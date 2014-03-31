package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class n implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
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
        this.a.n();
        this.a.m();
    }
}
