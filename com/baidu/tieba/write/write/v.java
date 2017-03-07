package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class v implements a.InterfaceC0073a {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0073a
    public void kZ() {
        com.baidu.tbadk.editortools.j jVar;
        this.fQG.dLc = null;
        this.fQG.lN(false);
        jVar = this.fQG.ayN;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
