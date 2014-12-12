package com.baidu.tieba.tbadkCore.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditor bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.bUy = pbEditor;
        this.aBH = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 2) {
            this.bUy.hH(i);
        } else if (i == 3) {
            this.bUy.Zz();
        } else if (i == 5) {
            this.bUy.hH(i);
        } else if (i == 6) {
            this.bUy.Zz();
        } else if (i == 8) {
            this.bUy.hH(i);
        } else if (i == 9) {
            this.bUy.Zz();
        } else if (i != 0) {
            if (i == 18) {
                if (this.bUy.afD()) {
                    this.bUy.bUr.afB();
                } else {
                    this.bUy.bUr.afC();
                }
            } else if (i == 12) {
                this.aBH.handleAction(35, obj);
                this.bUy.bUr.aeS();
                this.bUy.bUs.V(this.bUy.bUr.getEditText());
            } else if (i == 38) {
                this.bUy.hH(i);
            } else if (i == 44) {
                this.bUy.hH(i);
            } else if (i == 50) {
                this.bUy.hH(i);
            }
        }
        this.aBH.handleAction(i, obj);
    }
}
