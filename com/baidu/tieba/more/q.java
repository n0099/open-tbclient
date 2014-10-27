package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class q implements DialogInterface.OnClickListener {
    final /* synthetic */ l bqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.bqD = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TbadkApplication.m251getInst().setFontSize(1);
                break;
            case 1:
                TbadkApplication.m251getInst().setFontSize(2);
                break;
            case 2:
                TbadkApplication.m251getInst().setFontSize(3);
                break;
        }
        this.bqD.UB();
    }
}
