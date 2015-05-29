package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        ak akVar;
        ak akVar2;
        eVar.dismiss();
        com.baidu.tieba.tbadkCore.data.j jVar = null;
        akVar = this.bPw.bPn;
        if (akVar.adB() != null) {
            akVar2 = this.bPw.bPn;
            jVar = akVar2.adB().aaA();
        }
        if (jVar != null) {
            if (i == 0) {
                jVar.aJ(this.bPw.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.bPw.b(jVar);
            }
        }
    }
}
