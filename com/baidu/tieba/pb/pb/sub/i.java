package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c.b {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ax axVar;
        ax axVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.q qVar = null;
        axVar = this.exF.exr;
        if (axVar.aRs() != null) {
            axVar2 = this.exF.exr;
            qVar = axVar2.aRs().aMN();
        }
        if (qVar != null) {
            if (i == 0) {
                qVar.bf(this.exF.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.exF.d(qVar);
            }
        }
    }
}
