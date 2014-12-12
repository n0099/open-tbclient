package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ k bug;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar) {
        this.bug = kVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                TbadkCoreApplication.m255getInst().setFontSize(1);
                break;
            case 1:
                TbadkCoreApplication.m255getInst().setFontSize(2);
                break;
            case 2:
                TbadkCoreApplication.m255getInst().setFontSize(3);
                break;
        }
        this.bug.UQ();
    }
}
