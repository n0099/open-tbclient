package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amr;
    final /* synthetic */ a ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.ddQ = aVar;
        this.amr = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.amr.dismiss();
        this.ddQ.cancel();
    }
}
