package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ d bsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bsw = dVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        d dVar = this.bsw;
        imMessageCenterListAdapter = this.bsw.bsn;
        dVar.bsl = imMessageCenterListAdapter.getItem(i);
        d dVar2 = this.bsw;
        imMessageCenterShowItemData = this.bsw.bsl;
        dVar2.c(imMessageCenterShowItemData);
        if (this.bsw.bsq != null) {
            this.bsw.bsq.rN();
        }
        return true;
    }
}
