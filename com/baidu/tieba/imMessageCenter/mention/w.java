package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(l lVar) {
        this.dmU = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i <= 1) {
            return false;
        }
        l lVar = this.dmU;
        messageAggregationListAdapter = this.dmU.dmN;
        lVar.djV = messageAggregationListAdapter.getItem(i);
        l lVar2 = this.dmU;
        imMessageCenterShowItemData = this.dmU.djV;
        lVar2.c(imMessageCenterShowItemData);
        if (this.dmU.dka != null) {
            this.dmU.dka.tT();
            return true;
        }
        return true;
    }
}
