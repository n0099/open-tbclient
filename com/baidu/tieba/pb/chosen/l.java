package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbChosenActivity pbChosenActivity) {
        this.cfa = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (this.cfa.checkUpIsLogin()) {
            dVar = this.cfa.aSr;
            if (dVar != null) {
                dVar2 = this.cfa.aSr;
                if (dVar2.Ax() != null) {
                    dVar3 = this.cfa.aSr;
                    dVar3.Ax().ow();
                    mVar = this.cfa.ceH;
                    mVar.setVisible(false);
                    TiebaStatic.log("c10094");
                }
            }
        }
    }
}
