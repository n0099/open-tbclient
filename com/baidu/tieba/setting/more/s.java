package com.baidu.tieba.setting.more;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.i {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        wVar = this.this$0.cft;
        if (wVar.getUser() != null) {
            wVar2 = this.this$0.cft;
            personChangeData.setName(wVar2.getUser().getName_show());
            wVar3 = this.this$0.cft;
            personChangeData.setIntro(wVar3.getUser().getIntro());
            wVar4 = this.this$0.cft;
            personChangeData.setPortrait(wVar4.getUser().getPortrait());
            wVar5 = this.this$0.cft;
            personChangeData.setSex(wVar5.getUser().getSex());
            this.this$0.b(personChangeData);
        }
    }
}
