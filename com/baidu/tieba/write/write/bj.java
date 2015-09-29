package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class bj implements a.InterfaceC0074a {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0074a
    public void nn() {
        com.baidu.tbadk.editortools.j jVar;
        this.dpI.bWl = null;
        this.dpI.hb(false);
        jVar = this.dpI.dpc;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
