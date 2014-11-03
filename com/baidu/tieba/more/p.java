package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ l bqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bqR = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.js().aI(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.js().aI(1);
                break;
            case 2:
                com.baidu.tbadk.core.l.js().aI(2);
                break;
        }
        this.bqR.UD();
        this.bqR.UA();
    }
}
