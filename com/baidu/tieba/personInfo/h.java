package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonInfoActivity personInfoActivity) {
        this.csI = personInfoActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        aj ajVar;
        aj ajVar2;
        ajVar = this.csI.csw;
        ajVar.hideProgress();
        ajVar2 = this.csI.csw;
        ajVar2.ajW();
    }
}
