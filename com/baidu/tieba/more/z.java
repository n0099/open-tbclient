package com.baidu.tieba.more;

import com.baidu.tieba.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.h {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        com.baidu.tieba.person.o oVar;
        com.baidu.tieba.person.o oVar2;
        com.baidu.tieba.person.o oVar3;
        com.baidu.tieba.person.o oVar4;
        com.baidu.tieba.person.o oVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        oVar = this.a.c;
        if (oVar.a() != null) {
            oVar2 = this.a.c;
            personChangeData.setName(oVar2.a().getName_show());
            oVar3 = this.a.c;
            personChangeData.setIntro(oVar3.a().getIntro());
            oVar4 = this.a.c;
            personChangeData.setPortrait(oVar4.a().getPortrait());
            oVar5 = this.a.c;
            personChangeData.setSex(oVar5.a().getSex());
            this.a.a(personChangeData);
        }
    }
}
