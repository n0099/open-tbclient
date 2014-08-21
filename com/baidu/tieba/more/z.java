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
        com.baidu.tieba.person.p pVar;
        com.baidu.tieba.person.p pVar2;
        com.baidu.tieba.person.p pVar3;
        com.baidu.tieba.person.p pVar4;
        com.baidu.tieba.person.p pVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        pVar = this.a.c;
        if (pVar.a() != null) {
            pVar2 = this.a.c;
            personChangeData.setName(pVar2.a().getName_show());
            pVar3 = this.a.c;
            personChangeData.setIntro(pVar3.a().getIntro());
            pVar4 = this.a.c;
            personChangeData.setPortrait(pVar4.a().getPortrait());
            pVar5 = this.a.c;
            personChangeData.setSex(pVar5.a().getSex());
            this.a.a(personChangeData);
        }
    }
}
