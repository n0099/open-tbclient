package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ak akVar;
        ak akVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.k kVar = null;
        akVar = this.cmC.cmt;
        if (akVar.ahw() != null) {
            akVar2 = this.cmC.cmt;
            kVar = akVar2.ahw().aeV();
        }
        if (kVar != null) {
            if (i == 0) {
                kVar.aS(this.cmC.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cmC.c(kVar);
            }
        }
    }
}
