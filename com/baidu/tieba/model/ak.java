package com.baidu.tieba.model;

import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import java.util.Comparator;
/* loaded from: classes.dex */
class ak implements Comparator<ImMessageCenterShowItemData> {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ag agVar) {
        this.a = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ImMessageCenterShowItemData imMessageCenterShowItemData, ImMessageCenterShowItemData imMessageCenterShowItemData2) {
        if (imMessageCenterShowItemData == null || imMessageCenterShowItemData2 == null) {
            return 0;
        }
        if (imMessageCenterShowItemData.getServerTime() < imMessageCenterShowItemData2.getServerTime()) {
            return 1;
        }
        return imMessageCenterShowItemData.getServerTime() > imMessageCenterShowItemData2.getServerTime() ? -1 : 0;
    }
}
