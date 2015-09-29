package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aml;
    final /* synthetic */ a dbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.dbg = aVar;
        this.aml = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aml.dismiss();
        this.dbg.axG();
    }
}
