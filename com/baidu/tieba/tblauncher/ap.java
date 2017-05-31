package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ap implements a.b {
    final /* synthetic */ ak fHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar) {
        this.fHb = akVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c12137");
        asVar.Z("obj_locate", "1");
        TiebaStatic.log(asVar);
        aVar.dismiss();
    }
}
