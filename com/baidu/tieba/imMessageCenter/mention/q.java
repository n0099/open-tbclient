package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ k cmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.cmS = kVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        k kVar = this.cmS;
        imMessageCenterListAdapter = this.cmS.cia;
        kVar.chY = imMessageCenterListAdapter.getItem(i);
        k kVar2 = this.cmS;
        imMessageCenterShowItemData = this.cmS.chY;
        kVar2.c(imMessageCenterShowItemData);
        if (this.cmS.cie != null) {
            this.cmS.cie.un();
        }
        return true;
    }
}
