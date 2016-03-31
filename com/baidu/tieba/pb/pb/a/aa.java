package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.b {
    final /* synthetic */ r dej;
    private final /* synthetic */ an dek;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s del;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dej = rVar;
        this.dek = anVar;
        this.del = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.dej.b(this.dek, this.del);
        aVar.dismiss();
    }
}
