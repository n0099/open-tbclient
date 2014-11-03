package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.h {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bER = personInfoActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bER.bEH;
        aeVar.hideProgress();
        aeVar2 = this.bER.bEH;
        aeVar2.abh();
    }
}
