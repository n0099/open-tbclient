package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonInfoActivity personInfoActivity) {
        this.cue = personInfoActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        aj ajVar;
        aj ajVar2;
        ajVar = this.cue.ctS;
        ajVar.hideProgress();
        ajVar2 = this.cue.ctS;
        ajVar2.akC();
    }
}
