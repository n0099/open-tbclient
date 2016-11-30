package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arM;
    final /* synthetic */ b fFH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.fFH = bVar;
        this.arM = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arM.dismiss();
        this.fFH.bnp();
    }
}
