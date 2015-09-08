package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.cgV = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ak akVar;
        ak akVar2;
        cVar.dismiss();
        com.baidu.tieba.tbadkCore.data.i iVar = null;
        akVar = this.cgV.cgM;
        if (akVar.afD() != null) {
            akVar2 = this.cgV.cgM;
            iVar = akVar2.afD().adb();
        }
        if (iVar != null) {
            if (i == 0) {
                iVar.aT(this.cgV.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.cgV.b(iVar);
            }
        }
    }
}
