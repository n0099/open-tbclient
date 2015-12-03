package com.baidu.tieba.setting.more;

import com.baidu.tbadk.coreExtra.data.PersonChangeData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.setting.model.c cVar;
        com.baidu.tieba.setting.model.c cVar2;
        com.baidu.tieba.setting.model.c cVar3;
        com.baidu.tieba.setting.model.c cVar4;
        com.baidu.tieba.setting.model.c cVar5;
        PersonChangeData personChangeData = new PersonChangeData();
        cVar = this.this$0.dnm;
        if (cVar.getUser() != null) {
            cVar2 = this.this$0.dnm;
            personChangeData.setName(cVar2.getUser().getName_show());
            cVar3 = this.this$0.dnm;
            personChangeData.setIntro(cVar3.getUser().getIntro());
            cVar4 = this.this$0.dnm;
            personChangeData.setPortrait(cVar4.getUser().getPortrait());
            cVar5 = this.this$0.dnm;
            personChangeData.setSex(cVar5.getUser().getSex());
            this.this$0.c(personChangeData);
        }
    }
}
