package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.i {
    final /* synthetic */ PersonInfoActivity bVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bVf = personInfoActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ad adVar;
        ad adVar2;
        adVar = this.bVf.bUV;
        adVar.hideProgress();
        adVar2 = this.bVf.bUV;
        adVar2.afL();
    }
}
