package com.baidu.tieba.pb.main;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jw() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bCR.bCu;
        if (pbEditor != null) {
            pbEditor2 = this.bCR.bCu;
            pbEditor2.refresh();
        }
    }
}
