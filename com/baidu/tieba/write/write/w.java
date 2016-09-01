package com.baidu.tieba.write.write;

import com.baidu.tieba.tbadkCore.b.a;
/* loaded from: classes.dex */
class w implements a.InterfaceC0074a {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0074a
    public void kj() {
        com.baidu.tbadk.editortools.l lVar;
        this.gfs.dNj = null;
        this.gfs.lP(false);
        lVar = this.gfs.auk;
        lVar.b(new com.baidu.tbadk.editortools.a(2, 12, null));
    }
}
