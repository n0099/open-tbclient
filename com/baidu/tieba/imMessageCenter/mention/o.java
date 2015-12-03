package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ k ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.ceq = kVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        k kVar = this.ceq;
        imMessageCenterListAdapter = this.ceq.bZC;
        kVar.bZA = imMessageCenterListAdapter.getItem(i);
        k kVar2 = this.ceq;
        imMessageCenterShowItemData = this.ceq.bZA;
        kVar2.c(imMessageCenterShowItemData);
        if (this.ceq.bZF != null) {
            this.ceq.bZF.tz();
        }
        return true;
    }
}
