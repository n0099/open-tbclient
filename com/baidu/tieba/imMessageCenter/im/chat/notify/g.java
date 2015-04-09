package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ d bpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bpR = dVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        d dVar = this.bpR;
        imMessageCenterListAdapter = this.bpR.bpH;
        dVar.bpF = imMessageCenterListAdapter.getItem(i);
        d dVar2 = this.bpR;
        imMessageCenterShowItemData = this.bpR.bpF;
        dVar2.c(imMessageCenterShowItemData);
        if (this.bpR.bpK != null) {
            this.bpR.bpK.rg();
        }
        return true;
    }
}
