package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ l bqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bqR = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.l.js().aJ(0);
                break;
            case 1:
                com.baidu.tbadk.core.l.js().aJ(1);
                break;
            case 2:
                com.baidu.tbadk.core.l.js().aJ(2);
                break;
            case 3:
                com.baidu.tbadk.core.l.js().aJ(3);
                break;
        }
        this.bqR.UC();
        this.bqR.UA();
        ba.mD().mM();
    }
}
