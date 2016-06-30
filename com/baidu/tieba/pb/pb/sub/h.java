package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        aw awVar;
        aw awVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.s sVar = null;
        awVar = this.dWP.dWC;
        if (awVar.aIH() != null) {
            awVar2 = this.dWP.dWC;
            sVar = awVar2.aIH().aEe();
        }
        if (sVar != null) {
            if (i == 0) {
                sVar.aV(this.dWP.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.dWP.c(sVar);
            }
        }
    }
}
