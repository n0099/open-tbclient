package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f djq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.djq = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.djq;
        imMessageCenterListAdapter = this.djq.djh;
        fVar.djf = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.djq;
        imMessageCenterShowItemData = this.djq.djf;
        fVar2.c(imMessageCenterShowItemData);
        if (this.djq.djk != null) {
            this.djq.djk.tv();
        }
        return true;
    }
}
