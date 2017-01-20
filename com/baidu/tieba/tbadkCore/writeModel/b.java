package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqv;
    final /* synthetic */ NewWriteModel fsY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewWriteModel newWriteModel, com.baidu.tbadk.core.dialog.a aVar) {
        this.fsY = newWriteModel;
        this.aqv = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqv.dismiss();
        this.fsY.dealPost();
    }
}
