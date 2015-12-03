package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aoe;
    final /* synthetic */ a dCe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.dCe = aVar;
        this.aoe = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aoe.dismiss();
        this.dCe.cancel();
    }
}
