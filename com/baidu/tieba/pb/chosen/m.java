package com.baidu.tieba.pb.chosen;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tieba.pb.chosen.a.l lVar;
        if (this.cIA.checkUpIsLogin()) {
            eVar = this.cIA.bej;
            if (eVar != null) {
                eVar2 = this.cIA.bej;
                if (eVar2.Cz() != null) {
                    eVar3 = this.cIA.bej;
                    eVar3.Cz().ow();
                    lVar = this.cIA.cIg;
                    lVar.setVisible(false);
                }
            }
        }
    }
}
