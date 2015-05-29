package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d cwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.cwD = dVar;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void k(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.j.d dVar;
        com.baidu.tbadk.mvc.j.d dVar2;
        dVar = this.cwD.cwA;
        dVar.s(list);
        dVar2 = this.cwD.cwA;
        dVar2.notifyDataSetChanged();
    }
}
