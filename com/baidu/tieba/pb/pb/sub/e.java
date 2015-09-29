package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ak akVar;
        ak akVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.k kVar = null;
        akVar = this.cmr.cmi;
        if (akVar.ahA() != null) {
            akVar2 = this.cmr.cmi;
            kVar = akVar2.ahA().aeZ();
        }
        if (kVar != null) {
            if (i == 0) {
                kVar.aS(this.cmr.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cmr.c(kVar);
            }
        }
    }
}
