package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (this.cfl.checkUpIsLogin()) {
            dVar = this.cfl.aSC;
            if (dVar != null) {
                dVar2 = this.cfl.aSC;
                if (dVar2.Au() != null) {
                    dVar3 = this.cfl.aSC;
                    dVar3.Au().ow();
                    mVar = this.cfl.ceS;
                    mVar.setVisible(false);
                    TiebaStatic.log("c10094");
                }
            }
        }
    }
}
