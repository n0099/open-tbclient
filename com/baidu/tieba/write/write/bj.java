package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.c.a;
/* loaded from: classes.dex */
class bj implements a.InterfaceC0074a {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0074a
    public void nn() {
        com.baidu.tbadk.editortools.j jVar;
        this.dqi.bWw = null;
        this.dqi.hb(false);
        jVar = this.dqi.dpD;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
