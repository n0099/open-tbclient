package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKS;
    final /* synthetic */ PbEditor cqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cqW = pbEditor;
        this.aKS = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.cqW.iN(i);
        } else if (i == 3) {
            this.cqW.add();
        } else if (i == 5) {
            this.cqW.iN(i);
        } else if (i == 6) {
            this.cqW.add();
        } else if (i == 8) {
            this.cqW.iN(i);
        } else if (i == 9) {
            this.cqW.add();
        } else if (i != 0) {
            if (i == 18) {
                if (this.cqW.anR()) {
                    this.cqW.cqO.anP();
                } else {
                    this.cqW.cqO.anQ();
                }
            } else if (i == 12 || i == 64) {
                this.aKS.handleAction(35, obj);
                this.cqW.cqO.anf();
                this.cqW.cqP.ab(this.cqW.cqO.getEditText());
            } else if (i == 38) {
                this.cqW.iN(i);
            } else if (i == 44) {
                this.cqW.iN(i);
            } else if (i == 50) {
                this.cqW.iN(i);
            }
        }
        this.aKS.handleAction(i, obj);
    }
}
