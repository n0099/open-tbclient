package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d cwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.cwE = dVar;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void k(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.j.d dVar;
        dVar = this.cwE.cwB;
        dVar.s(list);
    }
}
