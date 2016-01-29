package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    final /* synthetic */ q cKS;
    private final /* synthetic */ am cKT;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(q qVar, am amVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cKS = qVar;
        this.cKT = amVar;
        this.cKU = rVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.cKS.b(this.cKT, this.cKU);
        aVar.dismiss();
    }
}
