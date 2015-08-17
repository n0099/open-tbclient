package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ak akVar;
        ak akVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.i iVar = null;
        akVar = this.cfY.cfP;
        if (akVar.afo() != null) {
            akVar2 = this.cfY.cfP;
            iVar = akVar2.afo().acQ();
        }
        if (iVar != null) {
            if (i == 0) {
                iVar.aQ(this.cfY.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cfY.b(iVar);
            }
        }
    }
}
