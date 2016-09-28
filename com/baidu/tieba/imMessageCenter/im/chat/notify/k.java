package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f dpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.dpg = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.dpg;
        imMessageCenterListAdapter = this.dpg.doX;
        fVar.doV = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.dpg;
        imMessageCenterShowItemData = this.dpg.doV;
        fVar2.c(imMessageCenterShowItemData);
        if (this.dpg.dpa != null) {
            this.dpg.dpa.tp();
        }
        return true;
    }
}
