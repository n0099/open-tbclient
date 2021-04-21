package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import d.b.j0.e1.f.i.c;
/* loaded from: classes4.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    public MessageAggregationListAdapter(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, d.b.j0.e1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.f55632b.setIsRound(true);
    }
}
