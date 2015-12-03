package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends m<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel cdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.cdp = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: adf */
    public CommonMsgPojo doInBackground() {
        return l.Xr().M(this.cdp.getUser().getUserId(), 23);
    }
}
