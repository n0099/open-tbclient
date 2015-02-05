package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ k bvB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.bvB = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.lV().ac(true);
                com.baidu.tbadk.core.l.lV().bl(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.lV().ac(true);
                com.baidu.tbadk.core.l.lV().bl(1);
                break;
            case 2:
                com.baidu.tbadk.core.l.lV().ac(true);
                com.baidu.tbadk.core.l.lV().bl(2);
                break;
            case 3:
                com.baidu.tbadk.core.l.lV().ac(false);
                break;
        }
        this.bvB.Vg();
        this.bvB.Vf();
    }
}
