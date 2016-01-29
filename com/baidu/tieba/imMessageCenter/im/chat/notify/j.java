package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e cil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.cil = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.cil;
        imMessageCenterListAdapter = this.cil.cia;
        eVar.chY = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.cil;
        imMessageCenterShowItemData = this.cil.chY;
        eVar2.c(imMessageCenterShowItemData);
        if (this.cil.cie != null) {
            this.cil.cie.un();
        }
        return true;
    }
}
