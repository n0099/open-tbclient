package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements c.b {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.p pVar = null;
        subPbModel = this.erC.erl;
        if (subPbModel.aPn() != null) {
            subPbModel2 = this.erC.erl;
            pVar = subPbModel2.aPn().aKw();
        }
        if (pVar != null) {
            if (i == 0) {
                pVar.bu(this.erC.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.erC.d(pVar);
            }
        }
    }
}
