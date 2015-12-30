package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c.b {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ao aoVar;
        ao aoVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.r rVar = null;
        aoVar = this.cLc.cKR;
        if (aoVar.anR() != null) {
            aoVar2 = this.cLc.cKR;
            rVar = aoVar2.anR().akS();
        }
        if (rVar != null) {
            if (i == 0) {
                rVar.aR(this.cLc.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cLc.c(rVar);
            }
        }
    }
}
