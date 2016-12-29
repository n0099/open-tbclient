package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arp;
    final /* synthetic */ b fjO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.tbadk.core.dialog.a aVar) {
        this.fjO = bVar;
        this.arp = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arp.dismiss();
        this.fjO.cancel();
    }
}
