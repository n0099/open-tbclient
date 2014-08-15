package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class q implements DialogInterface.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TbadkApplication.m252getInst().setFontSize(1);
                break;
            case 1:
                TbadkApplication.m252getInst().setFontSize(2);
                break;
            case 2:
                TbadkApplication.m252getInst().setFontSize(3);
                break;
        }
        this.a.p();
    }
}
