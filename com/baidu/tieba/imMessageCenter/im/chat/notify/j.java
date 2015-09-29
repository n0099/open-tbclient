package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bKa = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.bKa;
        imMessageCenterListAdapter = this.bKa.bJR;
        eVar.bJP = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.bKa;
        imMessageCenterShowItemData = this.bKa.bJP;
        eVar2.c(imMessageCenterShowItemData);
        if (this.bKa.bJU != null) {
            this.bKa.bJU.sU();
        }
        return true;
    }
}
