package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.i {
    final /* synthetic */ PersonInfoActivity bSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bSx = personInfoActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bSx.bSn;
        aeVar.hideProgress();
        aeVar2 = this.bSx.bSn;
        aeVar2.aeE();
    }
}
