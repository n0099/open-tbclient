package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class u implements a.InterfaceC0083a {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0083a
    public void lb() {
        com.baidu.tbadk.editortools.j jVar;
        this.glP.dSk = null;
        this.glP.mD(false);
        jVar = this.glP.azR;
        jVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
