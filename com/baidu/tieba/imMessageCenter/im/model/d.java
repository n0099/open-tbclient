package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends l<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel bNG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.bNG = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: ZI */
    public CommonMsgPojo doInBackground() {
        return com.baidu.tieba.im.db.l.TU().H(this.bNG.getUser().getUserId(), 23);
    }
}
