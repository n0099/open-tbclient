package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKS;
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, com.baidu.tbadk.editortool.v vVar) {
        this.bPU = sVar;
        this.aKS = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        PbEditor pbEditor;
        if (i == 0) {
            this.aKS.handleAction(26, obj);
        } else if (i == 10) {
            this.aKS.handleAction(27, obj);
        } else if (i == 33) {
            pbEditor = this.bPU.aKP;
            pbEditor.anS();
            this.aKS.handleAction(33, obj);
        } else {
            this.aKS.handleAction(i, obj);
        }
    }
}
