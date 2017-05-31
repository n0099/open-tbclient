package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class w implements a.InterfaceC0080a {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0080a
    public void ld() {
        com.baidu.tbadk.editortools.j jVar;
        this.gaR.dJM = null;
        this.gaR.mc(false);
        jVar = this.gaR.ayP;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
