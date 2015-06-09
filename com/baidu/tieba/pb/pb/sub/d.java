package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        ak akVar;
        ak akVar2;
        eVar.dismiss();
        com.baidu.tieba.tbadkCore.data.j jVar = null;
        akVar = this.bPx.bPo;
        if (akVar.adC() != null) {
            akVar2 = this.bPx.bPo;
            jVar = akVar2.adC().aaB();
        }
        if (jVar != null) {
            if (i == 0) {
                jVar.aJ(this.bPx.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.bPx.b(jVar);
            }
        }
    }
}
