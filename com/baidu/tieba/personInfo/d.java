package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.i {
    final /* synthetic */ PersonInfoActivity bVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bVe = personInfoActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ad adVar;
        ad adVar2;
        adVar = this.bVe.bUU;
        adVar.hideProgress();
        adVar2 = this.bVe.bUU;
        adVar2.afK();
    }
}
