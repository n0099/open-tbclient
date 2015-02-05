package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {
    final /* synthetic */ k bvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bvB = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.lV().bj(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.lV().bj(1);
                break;
            case 2:
                com.baidu.tbadk.core.l.lV().bj(2);
                break;
        }
        this.bvB.Vi();
        this.bvB.Vf();
    }
}
