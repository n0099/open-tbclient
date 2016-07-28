package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        aw awVar;
        aw awVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.s sVar = null;
        awVar = this.ejr.eje;
        if (awVar.aLS() != null) {
            awVar2 = this.ejr.eje;
            sVar = awVar2.aLS().aHp();
        }
        if (sVar != null) {
            if (i == 0) {
                sVar.aV(this.ejr.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.ejr.d(sVar);
            }
        }
    }
}
