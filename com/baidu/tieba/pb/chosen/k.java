package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tbadk.editortools.c.d dVar2;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (this.bZS.checkUpIsLogin()) {
            dVar = this.bZS.aTv;
            if (dVar != null) {
                dVar2 = this.bZS.aTv;
                if (dVar2.AL() != null) {
                    dVar3 = this.bZS.aTv;
                    dVar3.AL().ov();
                    mVar = this.bZS.bZz;
                    mVar.setVisible(false);
                    TiebaStatic.log("c10094");
                }
            }
        }
    }
}
