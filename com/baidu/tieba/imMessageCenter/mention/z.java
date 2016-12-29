package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(o oVar) {
        this.dcz = oVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        MessageAggregationListAdapter messageAggregationListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i <= 1) {
            return false;
        }
        o oVar = this.dcz;
        messageAggregationListAdapter = this.dcz.dcr;
        oVar.cZy = messageAggregationListAdapter.getItem(i);
        o oVar2 = this.dcz;
        imMessageCenterShowItemData = this.dcz.cZy;
        oVar2.c(imMessageCenterShowItemData);
        if (this.dcz.cZD != null) {
            this.dcz.cZD.te();
            return true;
        }
        return true;
    }
}
