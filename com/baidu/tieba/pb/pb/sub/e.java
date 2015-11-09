package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        am amVar;
        am amVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.o oVar = null;
        amVar = this.cnS.cnH;
        if (amVar.aic() != null) {
            amVar2 = this.cnS.cnH;
            oVar = amVar2.aic().afs();
        }
        if (oVar != null) {
            if (i == 0) {
                oVar.aR(this.cnS.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cnS.c(oVar);
            }
        }
    }
}
