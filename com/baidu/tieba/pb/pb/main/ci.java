package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements com.baidu.tieba.tbadkCore.c.h {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.bOG = chVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public void nf() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bOG.bOi;
        if (pbEditor != null) {
            pbEditor2 = this.bOG.bOi;
            pbEditor2.refresh();
        }
    }
}
