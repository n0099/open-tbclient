package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ k dzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.dzt = kVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        k kVar = this.dzt;
        imMessageCenterListAdapter = this.dzt.duF;
        kVar.duD = imMessageCenterListAdapter.getItem(i);
        k kVar2 = this.dzt;
        imMessageCenterShowItemData = this.dzt.duD;
        kVar2.c(imMessageCenterShowItemData);
        if (this.dzt.duI != null) {
            this.dzt.duI.tt();
        }
        return true;
    }
}
