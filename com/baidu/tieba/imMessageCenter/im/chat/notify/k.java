package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.dgY = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.dgY;
        imMessageCenterListAdapter = this.dgY.dgP;
        fVar.dgN = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.dgY;
        imMessageCenterShowItemData = this.dgY.dgN;
        fVar2.c(imMessageCenterShowItemData);
        if (this.dgY.dgS != null) {
            this.dgY.dgS.sY();
        }
        return true;
    }
}
