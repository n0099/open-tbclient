package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IMBlackListActivity iMBlackListActivity) {
        this.cgt = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        blackListModel = this.cgt.cgq;
        if (blackListModel != null) {
            blackListModel2 = this.cgt.cgq;
            blackListModel2.cancelLoadData();
            this.cgt.cgs = null;
        }
    }
}
