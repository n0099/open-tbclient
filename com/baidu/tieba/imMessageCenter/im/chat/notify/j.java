package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bGV = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.bGV;
        imMessageCenterListAdapter = this.bGV.bGM;
        eVar.bGK = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.bGV;
        imMessageCenterShowItemData = this.bGV.bGK;
        eVar2.c(imMessageCenterShowItemData);
        if (this.bGV.bGP != null) {
            this.bGV.bGP.sX();
        }
        return true;
    }
}
