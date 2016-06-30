package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class w implements a.InterfaceC0075a {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0075a
    public void jp() {
        com.baidu.tbadk.editortools.l lVar;
        this.fJw.dxW = null;
        this.fJw.ln(false);
        lVar = this.fJw.aqo;
        lVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
