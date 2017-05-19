package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class w implements a.InterfaceC0078a {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0078a
    public void ld() {
        com.baidu.tbadk.editortools.j jVar;
        this.fSV.dEo = null;
        this.fSV.lJ(false);
        jVar = this.fSV.azd;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
