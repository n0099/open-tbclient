package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends t<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel drm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalMsglistModel personalMsglistModel) {
        this.drm = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: ayN */
    public CommonMsgPojo doInBackground() {
        return l.asu().af(this.drm.getUser().getUserId(), 23);
    }
}
