package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.i {
    final /* synthetic */ PersonInfoActivity bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bIm = personInfoActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bIm.bIc;
        aeVar.hideProgress();
        aeVar2 = this.bIm.bIc;
        aeVar2.abD();
    }
}
