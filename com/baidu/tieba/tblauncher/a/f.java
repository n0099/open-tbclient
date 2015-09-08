package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ d cVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.cVQ = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.log("c10073");
        aVar.dismiss();
        com.baidu.tbadk.core.c.b.a(TbadkCoreApplication.m411getInst(), 12, false);
    }
}
