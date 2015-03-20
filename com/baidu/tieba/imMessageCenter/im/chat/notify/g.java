package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ d bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bpB = dVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        d dVar = this.bpB;
        imMessageCenterListAdapter = this.bpB.bpr;
        dVar.bpp = imMessageCenterListAdapter.getItem(i);
        d dVar2 = this.bpB;
        imMessageCenterShowItemData = this.bpB.bpp;
        dVar2.c(imMessageCenterShowItemData);
        if (this.bpB.bpu != null) {
            this.bpB.bpu.rg();
        }
        return true;
    }
}
