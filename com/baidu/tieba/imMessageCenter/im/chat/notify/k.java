package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f csQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.csQ = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.csQ;
        imMessageCenterListAdapter = this.csQ.csG;
        fVar.csE = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.csQ;
        imMessageCenterShowItemData = this.csQ.csE;
        fVar2.c(imMessageCenterShowItemData);
        if (this.csQ.csJ != null) {
            this.csQ.csJ.us();
        }
        return true;
    }
}
