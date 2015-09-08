package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.cmR = personInfoActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        ag agVar;
        ag agVar2;
        agVar = this.cmR.cmG;
        agVar.hideProgress();
        agVar2 = this.cmR.cmG;
        agVar2.ahZ();
    }
}
