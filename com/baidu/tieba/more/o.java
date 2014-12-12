package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {
    final /* synthetic */ k bug;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.bug = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.mc().be(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.mc().be(1);
                break;
            case 2:
                com.baidu.tbadk.core.l.mc().be(2);
                break;
        }
        this.bug.UP();
        this.bug.UM();
    }
}
