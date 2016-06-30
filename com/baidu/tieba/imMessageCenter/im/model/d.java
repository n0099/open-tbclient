package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends s<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel dcI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.dcI = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: atn */
    public CommonMsgPojo doInBackground() {
        return l.amU().af(this.dcI.getUser().getUserId(), 23);
    }
}
