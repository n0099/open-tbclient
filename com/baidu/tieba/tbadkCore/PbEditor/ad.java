package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCF;
    final /* synthetic */ PbEditor bWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.bWp = pbEditor;
        this.aCF = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.bWp.hQ(i);
        } else if (i == 3) {
            this.bWp.ZZ();
        } else if (i == 5) {
            this.bWp.hQ(i);
        } else if (i == 6) {
            this.bWp.ZZ();
        } else if (i == 8) {
            this.bWp.hQ(i);
        } else if (i == 9) {
            this.bWp.ZZ();
        } else if (i != 0) {
            if (i == 18) {
                if (this.bWp.agc()) {
                    this.bWp.bWi.aga();
                } else {
                    this.bWp.bWi.agb();
                }
            } else if (i == 12) {
                this.aCF.handleAction(35, obj);
                this.bWp.bWi.afr();
                this.bWp.bWj.X(this.bWp.bWi.getEditText());
            } else if (i == 38) {
                this.bWp.hQ(i);
            } else if (i == 44) {
                this.bWp.hQ(i);
            } else if (i == 50) {
                this.bWp.hQ(i);
            }
        }
        this.aCF.handleAction(i, obj);
    }
}
