package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.b {
    final /* synthetic */ r dgC;
    private final /* synthetic */ an dgD;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dgE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dgC = rVar;
        this.dgD = anVar;
        this.dgE = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.dgC.b(this.dgD, this.dgE);
        aVar.dismiss();
    }
}
