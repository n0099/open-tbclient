package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {
    final /* synthetic */ k bvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.bvC = kVar;
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
        com.baidu.tbadk.core.l.mc().bk(i2);
        this.bvC.gU(i2);
        this.bvC.Vk();
        com.baidu.tbadk.core.util.bg.pI().pR();
    }
}
