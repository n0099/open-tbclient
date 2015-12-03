package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e bZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bZK = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.bZK;
        imMessageCenterListAdapter = this.bZK.bZC;
        eVar.bZA = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.bZK;
        imMessageCenterShowItemData = this.bZK.bZA;
        eVar2.c(imMessageCenterShowItemData);
        if (this.bZK.bZF != null) {
            this.bZK.bZF.tz();
        }
        return true;
    }
}
