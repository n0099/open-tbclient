package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {
    final /* synthetic */ k bvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.bvB = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        com.baidu.tbadk.core.l.lV().bk(i2);
        this.bvB.gU(i2);
        this.bvB.Vf();
        com.baidu.tbadk.core.util.bg.pB().pK();
    }
}
