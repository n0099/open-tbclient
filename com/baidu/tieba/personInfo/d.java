package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.i {
    final /* synthetic */ PersonInfoActivity bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bJX = personInfoActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bJX.bJN;
        aeVar.hideProgress();
        aeVar2 = this.bJX.bJN;
        aeVar2.acc();
    }
}
