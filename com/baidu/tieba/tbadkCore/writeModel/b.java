package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aoa;
    final /* synthetic */ a fnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.fnG = aVar;
        this.aoa = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aoa.dismiss();
        this.fnG.bgN();
    }
}
