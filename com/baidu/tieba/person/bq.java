package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bq implements com.baidu.adp.widget.ListView.t {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        com.baidu.tieba.model.av avVar;
        aj ajVar;
        aj ajVar2;
        if (!this.a.isIsloading()) {
            avVar = this.a.mModel;
            if (avVar.b()) {
                ajVar2 = this.a.mPersonCenterView;
                ajVar2.a();
                return;
            }
            this.a.setIsloading(true);
            ajVar = this.a.mPersonCenterView;
            ajVar.d();
            this.a.refresh();
        }
    }
}
