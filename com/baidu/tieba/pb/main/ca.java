package com.baidu.tieba.pb.main;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jq() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bEB.bEe;
        if (pbEditor != null) {
            pbEditor2 = this.bEB.bEe;
            pbEditor2.refresh();
        }
    }
}
