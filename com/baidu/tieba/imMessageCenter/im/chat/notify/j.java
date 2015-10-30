package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e bKl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bKl = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.bKl;
        imMessageCenterListAdapter = this.bKl.bKc;
        eVar.bKa = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.bKl;
        imMessageCenterShowItemData = this.bKl.bKa;
        eVar2.c(imMessageCenterShowItemData);
        if (this.bKl.bKf != null) {
            this.bKl.bKf.sR();
        }
        return true;
    }
}
