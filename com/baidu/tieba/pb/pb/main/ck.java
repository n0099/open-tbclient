package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements com.baidu.tieba.tbadkCore.b.h {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public void mM() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bMC.bMh;
        if (pbEditor != null) {
            pbEditor2 = this.bMC.bMh;
            pbEditor2.refresh();
        }
    }
}
