package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements a.b {
    final /* synthetic */ ad fQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar) {
        this.fQS = adVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        au auVar = new au("c12137");
        auVar.Z("obj_locate", "2");
        TiebaStatic.log(auVar);
        aVar.dismiss();
        com.baidu.tieba.h.a.akj();
    }
}
