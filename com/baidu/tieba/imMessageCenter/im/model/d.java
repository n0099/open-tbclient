package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel djq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.djq = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: auZ */
    public CommonMsgPojo doInBackground() {
        return m.apJ().W(this.djq.getUser().getUserId(), 23);
    }
}
