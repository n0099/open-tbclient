package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ PbEditor cmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cmG = pbEditor;
        this.aIB = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.cmG.io(i);
        } else if (i == 3) {
            this.cmG.acj();
        } else if (i == 5) {
            this.cmG.io(i);
        } else if (i == 6) {
            this.cmG.acj();
        } else if (i == 8) {
            this.cmG.io(i);
        } else if (i == 9) {
            this.cmG.acj();
        } else if (i != 0) {
            if (i == 18) {
                if (this.cmG.alP()) {
                    this.cmG.cmy.alN();
                } else {
                    this.cmG.cmy.alO();
                }
            } else if (i == 12 || i == 64) {
                this.aIB.handleAction(35, obj);
                this.cmG.cmy.ale();
                this.cmG.cmz.aa(this.cmG.cmy.getEditText());
            } else if (i == 38) {
                this.cmG.io(i);
            } else if (i == 44) {
                this.cmG.io(i);
            } else if (i == 50) {
                this.cmG.io(i);
            }
        }
        this.aIB.handleAction(i, obj);
    }
}
