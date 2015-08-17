package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.g {
    final /* synthetic */ PersonInfoActivity clO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.clO = personInfoActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        ag agVar;
        ag agVar2;
        agVar = this.clO.clD;
        agVar.hideProgress();
        agVar2 = this.clO.clD;
        agVar2.ahH();
    }
}
