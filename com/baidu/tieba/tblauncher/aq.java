package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class aq implements a.b {
    final /* synthetic */ ak fHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ak akVar) {
        this.fHb = akVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c12137");
        asVar.Z("obj_locate", "2");
        TiebaStatic.log(asVar);
        aVar.dismiss();
        com.baidu.tieba.h.a.agz();
    }
}
