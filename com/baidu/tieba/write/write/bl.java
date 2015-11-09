package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class bl implements a.InterfaceC0075a {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0075a
    public void no() {
        com.baidu.tbadk.editortools.j jVar;
        this.dsa.bWX = null;
        this.dsa.he(false);
        jVar = this.dsa.drr;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
