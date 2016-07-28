package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends t<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel dfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.dfF = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: atZ */
    public CommonMsgPojo doInBackground() {
        return l.anF().af(this.dfF.getUser().getUserId(), 23);
    }
}
