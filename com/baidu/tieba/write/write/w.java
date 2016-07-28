package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class w implements a.InterfaceC0074a {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0074a
    public void jo() {
        com.baidu.tbadk.editortools.l lVar;
        this.fVn.dBu = null;
        this.fVn.lz(false);
        lVar = this.fVn.ard;
        lVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
