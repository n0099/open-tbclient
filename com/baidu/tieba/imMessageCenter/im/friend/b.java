package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity bMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IMBlackListActivity iMBlackListActivity) {
        this.bMJ = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        blackListModel = this.bMJ.bMG;
        if (blackListModel != null) {
            blackListModel2 = this.bMJ.bMG;
            blackListModel2.cancelLoadData();
            this.bMJ.bMI = null;
        }
    }
}
