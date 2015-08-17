package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e bGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bGo = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.bGo;
        imMessageCenterListAdapter = this.bGo.bGf;
        eVar.bGd = imMessageCenterListAdapter.getItem(i);
        e eVar2 = this.bGo;
        imMessageCenterShowItemData = this.bGo.bGd;
        eVar2.c(imMessageCenterShowItemData);
        if (this.bGo.bGi != null) {
            this.bGo.bGi.sS();
        }
        return true;
    }
}
