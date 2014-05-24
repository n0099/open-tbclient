package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.g.a().a(true);
                com.baidu.tbadk.core.g.a().c(0);
                break;
            case 1:
                com.baidu.tbadk.core.g.a().a(true);
                com.baidu.tbadk.core.g.a().c(1);
                break;
            case 2:
                com.baidu.tbadk.core.g.a().a(true);
                com.baidu.tbadk.core.g.a().c(2);
                break;
            case 3:
                com.baidu.tbadk.core.g.a().a(false);
                break;
        }
        this.a.x();
        this.a.n();
    }
}
