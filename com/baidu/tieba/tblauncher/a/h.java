package com.baidu.tieba.tblauncher.a;

import android.content.DialogInterface;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    final /* synthetic */ d cdN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.cdN = dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.b.b.a(TbadkCoreApplication.m255getInst(), 12, false);
    }
}
