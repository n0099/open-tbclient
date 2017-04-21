package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class u implements a.InterfaceC0072a {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0072a
    public void le() {
        com.baidu.tbadk.editortools.j jVar;
        this.fUM.dJR = null;
        this.fUM.ma(false);
        jVar = this.fUM.azf;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
