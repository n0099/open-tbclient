package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ d cwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.cwD = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.core.c.b.a(TbadkCoreApplication.m411getInst(), 12, false);
    }
}
