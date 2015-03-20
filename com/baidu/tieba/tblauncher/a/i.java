package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d csd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.csd = dVar;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void j(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.j.d dVar;
        dVar = this.csd.csa;
        dVar.r(list);
    }
}
