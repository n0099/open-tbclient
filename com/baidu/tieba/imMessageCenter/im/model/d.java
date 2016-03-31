package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.p;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends p<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.cwt = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: akS */
    public CommonMsgPojo doInBackground() {
        return l.aeE().U(this.cwt.getUser().getUserId(), 23);
    }
}
