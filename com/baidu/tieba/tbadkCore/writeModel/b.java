package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amm;
    final /* synthetic */ a dbG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.dbG = aVar;
        this.amm = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.amm.dismiss();
        this.dbG.axQ();
    }
}
