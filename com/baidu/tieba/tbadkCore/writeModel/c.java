package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqS;
    final /* synthetic */ b fyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.fyh = bVar;
        this.aqS = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqS.dismiss();
        this.fyh.bkZ();
    }
}
