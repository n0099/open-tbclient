package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKR;
    final /* synthetic */ PbEditor cqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cqV = pbEditor;
        this.aKR = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.cqV.iN(i);
        } else if (i == 3) {
            this.cqV.adc();
        } else if (i == 5) {
            this.cqV.iN(i);
        } else if (i == 6) {
            this.cqV.adc();
        } else if (i == 8) {
            this.cqV.iN(i);
        } else if (i == 9) {
            this.cqV.adc();
        } else if (i != 0) {
            if (i == 18) {
                if (this.cqV.anQ()) {
                    this.cqV.cqN.anO();
                } else {
                    this.cqV.cqN.anP();
                }
            } else if (i == 12 || i == 64) {
                this.aKR.handleAction(35, obj);
                this.cqV.cqN.ane();
                this.cqV.cqO.ab(this.cqV.cqN.getEditText());
            } else if (i == 38) {
                this.cqV.iN(i);
            } else if (i == 44) {
                this.cqV.iN(i);
            } else if (i == 50) {
                this.cqV.iN(i);
            }
        }
        this.aKR.handleAction(i, obj);
    }
}
