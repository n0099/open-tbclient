package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import d.a.n0.f1.f.i.c;
/* loaded from: classes4.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    public MessageAggregationListAdapter(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, d.a.n0.f1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.f54379b.setIsRound(true);
    }
}
