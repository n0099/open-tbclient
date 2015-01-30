package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {
    final /* synthetic */ k bvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bvC = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.mc().bj(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.mc().bj(1);
                break;
            case 2:
                com.baidu.tbadk.core.l.mc().bj(2);
                break;
        }
        this.bvC.Vn();
        this.bvC.Vk();
    }
}
