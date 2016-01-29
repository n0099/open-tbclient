package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqA;
    final /* synthetic */ a dZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.dZL = aVar;
        this.aqA = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqA.dismiss();
        this.dZL.cancel();
    }
}
