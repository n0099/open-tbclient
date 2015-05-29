package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKR;
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, com.baidu.tbadk.editortool.v vVar) {
        this.bPT = sVar;
        this.aKR = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        PbEditor pbEditor;
        if (i == 0) {
            this.aKR.handleAction(26, obj);
        } else if (i == 10) {
            this.aKR.handleAction(27, obj);
        } else if (i == 33) {
            pbEditor = this.bPT.aKO;
            pbEditor.anR();
            this.aKR.handleAction(33, obj);
        } else {
            this.aKR.handleAction(i, obj);
        }
    }
}
