package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class bm implements a.InterfaceC0073a {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0073a
    public void jm() {
        com.baidu.tbadk.editortools.l lVar;
        this.fea.cSm = null;
        this.fea.kB(false);
        lVar = this.fea.apy;
        lVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
