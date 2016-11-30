package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f duO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.duO = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.duO;
        imMessageCenterListAdapter = this.duO.duF;
        fVar.duD = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.duO;
        imMessageCenterShowItemData = this.duO.duD;
        fVar2.c(imMessageCenterShowItemData);
        if (this.duO.duI != null) {
            this.duO.duI.tt();
        }
        return true;
    }
}
