package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ e dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dcL = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.log("c10073");
        aVar.dismiss();
        com.baidu.tbadk.core.c.b.b(TbadkCoreApplication.m411getInst(), 12, false);
    }
}
