package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ PbEditor cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cmW = pbEditor;
        this.aIJ = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.cmW.ir(i);
        } else if (i == 3) {
            this.cmW.acy();
        } else if (i == 5) {
            this.cmW.ir(i);
        } else if (i == 6) {
            this.cmW.acy();
        } else if (i == 8) {
            this.cmW.ir(i);
        } else if (i == 9) {
            this.cmW.acy();
        } else if (i != 0) {
            if (i == 18) {
                if (this.cmW.ame()) {
                    this.cmW.cmO.amc();
                } else {
                    this.cmW.cmO.amd();
                }
            } else if (i == 12 || i == 64) {
                this.aIJ.handleAction(35, obj);
                this.cmW.cmO.alt();
                this.cmW.cmP.aa(this.cmW.cmO.getEditText());
            } else if (i == 38) {
                this.cmW.ir(i);
            } else if (i == 44) {
                this.cmW.ir(i);
            } else if (i == 50) {
                this.cmW.ir(i);
            }
        }
        this.aIJ.handleAction(i, obj);
    }
}
