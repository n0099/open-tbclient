package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f cZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.cZJ = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.cZJ;
        imMessageCenterListAdapter = this.cZJ.cZA;
        fVar.cZy = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.cZJ;
        imMessageCenterShowItemData = this.cZJ.cZy;
        fVar2.c(imMessageCenterShowItemData);
        if (this.cZJ.cZD != null) {
            this.cZJ.cZD.te();
        }
        return true;
    }
}
