package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c.b {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        an anVar;
        an anVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.o oVar = null;
        anVar = this.cHd.cGS;
        if (anVar.amF() != null) {
            anVar2 = this.cHd.cGS;
            oVar = anVar2.amF().ajK();
        }
        if (oVar != null) {
            if (i == 0) {
                oVar.aQ(this.cHd.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cHd.c(oVar);
            }
        }
    }
}
