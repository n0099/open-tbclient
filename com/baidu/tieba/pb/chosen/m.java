package com.baidu.tieba.pb.chosen;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tieba.pb.chosen.a.l lVar;
        if (this.cBV.checkUpIsLogin()) {
            eVar = this.cBV.bbY;
            if (eVar != null) {
                eVar2 = this.cBV.bbY;
                if (eVar2.Bj() != null) {
                    eVar3 = this.cBV.bbY;
                    eVar3.Bj().ob();
                    lVar = this.cBV.cBA;
                    lVar.setVisible(false);
                }
            }
        }
    }
}
