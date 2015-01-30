package com.baidu.tieba.more;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.i {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        abVar = this.this$0.bvT;
        if (abVar.getUser() != null) {
            abVar2 = this.this$0.bvT;
            personChangeData.setName(abVar2.getUser().getName_show());
            abVar3 = this.this$0.bvT;
            personChangeData.setIntro(abVar3.getUser().getIntro());
            abVar4 = this.this$0.bvT;
            personChangeData.setPortrait(abVar4.getUser().getPortrait());
            abVar5 = this.this$0.bvT;
            personChangeData.setSex(abVar5.getUser().getSex());
            this.this$0.a(personChangeData);
        }
    }
}
