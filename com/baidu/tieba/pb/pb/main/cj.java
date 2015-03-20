package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements com.baidu.tieba.tbadkCore.b.h {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public void mM() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bMm.bLR;
        if (pbEditor != null) {
            pbEditor2 = this.bMm.bLR;
            pbEditor2.refresh();
        }
    }
}
