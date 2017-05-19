package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends v<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel dfL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.dfL = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: asV */
    public CommonMsgPojo doInBackground() {
        return m.anD().X(this.dfL.getUser().getUserId(), 23);
    }
}
