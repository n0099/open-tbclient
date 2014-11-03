package com.baidu.tieba.more;

import com.baidu.tieba.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.h {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        acVar = this.this$0.brj;
        if (acVar.getUser() != null) {
            acVar2 = this.this$0.brj;
            personChangeData.setName(acVar2.getUser().getName_show());
            acVar3 = this.this$0.brj;
            personChangeData.setIntro(acVar3.getUser().getIntro());
            acVar4 = this.this$0.brj;
            personChangeData.setPortrait(acVar4.getUser().getPortrait());
            acVar5 = this.this$0.brj;
            personChangeData.setSex(acVar5.getUser().getSex());
            this.this$0.b(personChangeData);
        }
    }
}
