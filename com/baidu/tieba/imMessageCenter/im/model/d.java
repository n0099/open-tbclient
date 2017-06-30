package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends w<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel dtb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.dtb = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: axy */
    public CommonMsgPojo doInBackground() {
        return m.aso().Z(this.dtb.getUser().getUserId(), 23);
    }
}
