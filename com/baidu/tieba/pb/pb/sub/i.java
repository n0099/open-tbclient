package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements c.b {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ax axVar;
        ax axVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.q qVar = null;
        axVar = this.evy.evl;
        if (axVar.aQK() != null) {
            axVar2 = this.evy.evl;
            qVar = axVar2.aQK().aMh();
        }
        if (qVar != null) {
            if (i == 0) {
                qVar.bi(this.evy.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.evy.d(qVar);
            }
        }
    }
}
