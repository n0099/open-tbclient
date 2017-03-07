package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a avQ;
    final /* synthetic */ NewWriteModel fxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewWriteModel newWriteModel, com.baidu.tbadk.core.dialog.a aVar) {
        this.fxw = newWriteModel;
        this.avQ = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.avQ.dismiss();
        this.fxw.cancel();
    }
}
