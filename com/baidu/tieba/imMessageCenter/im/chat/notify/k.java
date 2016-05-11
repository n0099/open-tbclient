package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f ctO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.ctO = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.ctO;
        imMessageCenterListAdapter = this.ctO.ctE;
        fVar.ctC = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.ctO;
        imMessageCenterShowItemData = this.ctO.ctC;
        fVar2.c(imMessageCenterShowItemData);
        if (this.ctO.ctH != null) {
            this.ctO.ctH.rX();
        }
        return true;
    }
}
