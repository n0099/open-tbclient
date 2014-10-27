package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ l bqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bqD = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.k.js().aJ(0);
                break;
            case 1:
                com.baidu.tbadk.core.k.js().aJ(1);
                break;
            case 2:
                com.baidu.tbadk.core.k.js().aJ(2);
                break;
            case 3:
                com.baidu.tbadk.core.k.js().aJ(3);
                break;
        }
        this.bqD.Uz();
        this.bqD.Ux();
        az.mD().mM();
    }
}
