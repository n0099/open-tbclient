package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a anl;
    final /* synthetic */ a faD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.tbadk.core.dialog.a aVar2) {
        this.faD = aVar;
        this.anl = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.anl.dismiss();
        this.faD.bdw();
    }
}
