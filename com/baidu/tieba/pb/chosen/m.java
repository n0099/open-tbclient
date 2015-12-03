package com.baidu.tieba.pb.chosen;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        com.baidu.tbadk.editortools.d.e eVar3;
        com.baidu.tieba.pb.chosen.a.l lVar;
        if (this.cyo.checkUpIsLogin()) {
            eVar = this.cyo.aXY;
            if (eVar != null) {
                eVar2 = this.cyo.aXY;
                if (eVar2.Bu() != null) {
                    eVar3 = this.cyo.aXY;
                    eVar3.Bu().oD();
                    lVar = this.cyo.cxT;
                    lVar.setVisible(false);
                }
            }
        }
    }
}
