package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ k dgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.dgL = kVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        k kVar = this.dgL;
        imMessageCenterListAdapter = this.dgL.dbR;
        kVar.dbP = imMessageCenterListAdapter.getItem(i);
        k kVar2 = this.dgL;
        imMessageCenterShowItemData = this.dgL.dbP;
        kVar2.c(imMessageCenterShowItemData);
        if (this.dgL.dbU != null) {
            this.dgL.dbU.rV();
        }
        return true;
    }
}
