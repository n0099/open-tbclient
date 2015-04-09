package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d cst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.cst = dVar;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void j(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.j.d dVar;
        dVar = this.cst.csq;
        dVar.r(list);
    }
}
