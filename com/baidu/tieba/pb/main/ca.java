package com.baidu.tieba.pb.main;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tieba.tbadkCore.bubble.y {
    final /* synthetic */ bz bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.bEC = bzVar;
    }

    @Override // com.baidu.tieba.tbadkCore.bubble.y
    public void jx() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        pbEditor = this.bEC.bEf;
        if (pbEditor != null) {
            pbEditor2 = this.bEC.bEf;
            pbEditor2.refresh();
        }
    }
}
