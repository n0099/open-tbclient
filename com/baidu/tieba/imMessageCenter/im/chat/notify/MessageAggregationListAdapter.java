package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.chat.a.c;
/* loaded from: classes4.dex */
public class MessageAggregationListAdapter extends ImMessageCenterListAdapter {
    public MessageAggregationListAdapter(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter, com.baidu.tieba.im.chat.a.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        super.g(aVar, imMessageCenterShowItemData);
        aVar.gcB.setIsRound(true);
    }
}
