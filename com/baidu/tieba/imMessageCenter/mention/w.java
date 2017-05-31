package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class w implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(l lVar) {
        this.dmu = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i <= 1) {
            return false;
        }
        l lVar = this.dmu;
        messageAggregationListAdapter = this.dmu.dmn;
        lVar.djs = messageAggregationListAdapter.getItem(i);
        l lVar2 = this.dmu;
        imMessageCenterShowItemData = this.dmu.djs;
        lVar2.c(imMessageCenterShowItemData);
        if (this.dmu.djx != null) {
            this.dmu.djx.tf();
            return true;
        }
        return true;
    }
}
