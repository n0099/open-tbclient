package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class bj implements a.InterfaceC0071a {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0071a
    public void nm() {
        com.baidu.tbadk.editortools.j jVar;
        this.ddQ.bSz = null;
        this.ddQ.gK(false);
        jVar = this.ddQ.ddl;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
