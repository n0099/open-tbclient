package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class w implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(l lVar) {
        this.duq = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i <= 1) {
            return false;
        }
        l lVar = this.duq;
        messageAggregationListAdapter = this.duq.duj;
        lVar.dro = messageAggregationListAdapter.getItem(i);
        l lVar2 = this.duq;
        imMessageCenterShowItemData = this.duq.dro;
        lVar2.c(imMessageCenterShowItemData);
        if (this.duq.drt != null) {
            this.duq.drt.td();
            return true;
        }
        return true;
    }
}
