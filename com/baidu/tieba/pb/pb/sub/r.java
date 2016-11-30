package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements c.b {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        bc bcVar;
        bc bcVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.q qVar = null;
        bcVar = this.eEs.eEb;
        if (bcVar.aTA() != null) {
            bcVar2 = this.eEs.eEb;
            qVar = bcVar2.aTA().aOG();
        }
        if (qVar != null) {
            if (i == 0) {
                qVar.bt(this.eEs.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.eEs.e(qVar);
            }
        }
    }
}
