package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.editortools.c.e eVar;
        com.baidu.tbadk.editortools.c.e eVar2;
        com.baidu.tbadk.editortools.c.e eVar3;
        com.baidu.tieba.pb.chosen.a.m mVar;
        if (this.cfM.checkUpIsLogin()) {
            eVar = this.cfM.aSK;
            if (eVar != null) {
                eVar2 = this.cfM.aSK;
                if (eVar2.Az() != null) {
                    eVar3 = this.cfM.aSK;
                    eVar3.Az().ox();
                    mVar = this.cfM.cft;
                    mVar.setVisible(false);
                    TiebaStatic.log("c10094");
                }
            }
        }
    }
}
