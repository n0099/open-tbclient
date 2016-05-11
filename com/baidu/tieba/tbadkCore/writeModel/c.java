package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amF;
    final /* synthetic */ a evN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.evN = aVar;
        this.amF = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.amF.dismiss();
        this.evN.cancel();
    }
}
