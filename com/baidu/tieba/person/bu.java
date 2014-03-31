package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bu extends com.baidu.adp.a.h {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        af afVar;
        com.baidu.tieba.model.av avVar;
        aj ajVar;
        com.baidu.tieba.model.av avVar2;
        aj ajVar2;
        com.baidu.tieba.model.av avVar3;
        aj ajVar3;
        com.baidu.tbadk.core.e eVar;
        com.baidu.tieba.model.av avVar4;
        com.baidu.tieba.model.av avVar5;
        com.baidu.tieba.model.av avVar6;
        aj ajVar4;
        com.baidu.tbadk.core.e eVar2;
        com.baidu.tbadk.core.e eVar3;
        af afVar2;
        afVar = this.a.mHeadView;
        if (afVar != null) {
            afVar2 = this.a.mHeadView;
            afVar2.c();
        }
        avVar = this.a.mModel;
        if (avVar.getLoadDataMode() != 1) {
            avVar5 = this.a.mModel;
            if (avVar5.getLoadDataMode() != 2) {
                avVar6 = this.a.mModel;
                if (avVar6.getLoadDataMode() == 3) {
                    ajVar4 = this.a.mPersonCenterView;
                    if (ajVar4 != null) {
                        if (((Boolean) obj).booleanValue()) {
                            eVar2 = this.a.mContext;
                            eVar3 = this.a.mContext;
                            eVar2.a(eVar3.getResources().getString(com.baidu.tieba.a.k.success));
                            this.a.fresh();
                            return;
                        }
                        eVar = this.a.mContext;
                        avVar4 = this.a.mModel;
                        eVar.a(avVar4.getErrorString());
                    }
                    return;
                }
                return;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            avVar2 = this.a.mModel;
            if (avVar2.b()) {
                ajVar3 = this.a.mPersonCenterView;
                ajVar3.a();
                return;
            }
            this.a.setHeadItemView();
            ajVar2 = this.a.mPersonCenterView;
            avVar3 = this.a.mModel;
            ajVar2.a(avVar3);
            return;
        }
        ajVar = this.a.mPersonCenterView;
        ajVar.e();
        eVar = this.a.mContext;
        avVar4 = this.a.mModel;
        eVar.a(avVar4.getErrorString());
    }
}
