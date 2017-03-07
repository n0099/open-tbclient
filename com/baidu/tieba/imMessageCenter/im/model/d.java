package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel dkR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.dkR = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: avg */
    public CommonMsgPojo doInBackground() {
        return l.apQ().W(this.dkR.getUser().getUserId(), 23);
    }
}
