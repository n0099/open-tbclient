package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ k ddP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.ddP = kVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        k kVar = this.ddP;
        imMessageCenterListAdapter = this.ddP.cYU;
        kVar.cYS = imMessageCenterListAdapter.getItem(i);
        k kVar2 = this.ddP;
        imMessageCenterShowItemData = this.ddP.cYS;
        kVar2.c(imMessageCenterShowItemData);
        if (this.ddP.cYX != null) {
            this.ddP.cYX.rW();
        }
        return true;
    }
}
