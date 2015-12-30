package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e cdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.cdL = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.cdL;
        imMessageCenterListAdapter = this.cdL.cdC;
        eVar.cdA = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.cdL;
        imMessageCenterShowItemData = this.cdL.cdA;
        eVar2.c(imMessageCenterShowItemData);
        if (this.cdL.cdF != null) {
            this.cdL.cdF.tj();
        }
        return true;
    }
}
