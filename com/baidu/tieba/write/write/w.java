package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class w implements a.InterfaceC0072a {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0072a
    public void kj() {
        com.baidu.tbadk.editortools.j jVar;
        this.fDQ.dzm = null;
        this.fDQ.lF(false);
        jVar = this.fDQ.aun;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
