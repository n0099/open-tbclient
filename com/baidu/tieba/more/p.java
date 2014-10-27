package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ l bqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bqD = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.k.js().aI(0);
                break;
            case 1:
                com.baidu.tbadk.core.k.js().aI(1);
                break;
            case 2:
                com.baidu.tbadk.core.k.js().aI(2);
                break;
        }
        this.bqD.UA();
        this.bqD.Ux();
    }
}
