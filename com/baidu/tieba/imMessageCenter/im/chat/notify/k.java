package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.cZd = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.cZd;
        imMessageCenterListAdapter = this.cZd.cYU;
        fVar.cYS = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.cZd;
        imMessageCenterShowItemData = this.cZd.cYS;
        fVar2.c(imMessageCenterShowItemData);
        if (this.cZd.cYX != null) {
            this.cZd.cYX.rW();
        }
        return true;
    }
}
