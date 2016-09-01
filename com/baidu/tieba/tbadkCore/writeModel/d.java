package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arh;
    final /* synthetic */ b fvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.fvA = bVar;
        this.arh = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arh.dismiss();
        this.fvA.cancel();
    }
}
