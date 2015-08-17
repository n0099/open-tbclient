package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (this.bYY.checkUpIsLogin()) {
            dVar = this.bYY.aTh;
            if (dVar != null) {
                dVar2 = this.bYY.aTh;
                if (dVar2.Ay() != null) {
                    dVar3 = this.bYY.aTh;
                    dVar3.Ay().oy();
                    mVar = this.bYY.bYF;
                    mVar.setVisible(false);
                    TiebaStatic.log("c10094");
                }
            }
        }
    }
}
