package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.h {
    final /* synthetic */ PersonInfoActivity bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonInfoActivity personInfoActivity) {
        this.bED = personInfoActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bED.bEt;
        aeVar.hideProgress();
        aeVar2 = this.bED.bEt;
        aeVar2.abe();
    }
}
