package com.baidu.tieba.more;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {
    final /* synthetic */ l bqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bqD = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                com.baidu.tbadk.core.k.js().M(true);
                com.baidu.tbadk.core.k.js().aK(0);
                break;
            case 1:
                com.baidu.tbadk.core.k.js().M(true);
                com.baidu.tbadk.core.k.js().aK(1);
                break;
            case 2:
                com.baidu.tbadk.core.k.js().M(true);
                com.baidu.tbadk.core.k.js().aK(2);
                break;
            case 3:
                com.baidu.tbadk.core.k.js().M(false);
                break;
        }
        this.bqD.Uy();
        this.bqD.Ux();
    }
}
