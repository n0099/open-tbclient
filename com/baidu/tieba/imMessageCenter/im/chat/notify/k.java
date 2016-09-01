package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f dnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.dnI = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.dnI;
        imMessageCenterListAdapter = this.dnI.dnz;
        fVar.dnx = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.dnI;
        imMessageCenterShowItemData = this.dnI.dnx;
        fVar2.c(imMessageCenterShowItemData);
        if (this.dnI.dnC != null) {
            this.dnI.dnC.ta();
        }
        return true;
    }
}
