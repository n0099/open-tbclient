package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.i {
    final /* synthetic */ PersonInfoActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bJY = personInfoActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bJY.bJO;
        aeVar.hideProgress();
        aeVar2 = this.bJY.bJO;
        aeVar2.ach();
    }
}
