package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ PbEditor bWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.bWq = pbEditor;
        this.aCI = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.bWq.hQ(i);
        } else if (i == 3) {
            this.bWq.aae();
        } else if (i == 5) {
            this.bWq.hQ(i);
        } else if (i == 6) {
            this.bWq.aae();
        } else if (i == 8) {
            this.bWq.hQ(i);
        } else if (i == 9) {
            this.bWq.aae();
        } else if (i != 0) {
            if (i == 18) {
                if (this.bWq.agh()) {
                    this.bWq.bWj.agf();
                } else {
                    this.bWq.bWj.agg();
                }
            } else if (i == 12) {
                this.aCI.handleAction(35, obj);
                this.bWq.bWj.afw();
                this.bWq.bWk.X(this.bWq.bWj.getEditText());
            } else if (i == 38) {
                this.bWq.hQ(i);
            } else if (i == 44) {
                this.bWq.hQ(i);
            } else if (i == 50) {
                this.bWq.hQ(i);
            }
        }
        this.aCI.handleAction(i, obj);
    }
}
