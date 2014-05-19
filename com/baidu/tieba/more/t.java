package com.baidu.tieba.more;

import com.baidu.tieba.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.g {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        com.baidu.tieba.person.t tVar;
        com.baidu.tieba.person.t tVar2;
        com.baidu.tieba.person.t tVar3;
        com.baidu.tieba.person.t tVar4;
        com.baidu.tieba.person.t tVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        tVar = this.a.c;
        if (tVar.a() != null) {
            tVar2 = this.a.c;
            personChangeData.setName(tVar2.a().getName_show());
            tVar3 = this.a.c;
            personChangeData.setIntro(tVar3.a().getIntro());
            tVar4 = this.a.c;
            personChangeData.setPortrait(tVar4.a().getPortrait());
            tVar5 = this.a.c;
            personChangeData.setSex(tVar5.a().getSex());
            this.a.a(personChangeData);
        }
    }
}
