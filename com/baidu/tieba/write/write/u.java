package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class u implements a.InterfaceC0072a {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0072a
    public void ld() {
        com.baidu.tbadk.editortools.j jVar;
        this.fSq.dHB = null;
        this.fSq.lQ(false);
        jVar = this.fSq.azd;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
