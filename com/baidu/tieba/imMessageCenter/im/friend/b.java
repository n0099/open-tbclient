package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity dsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IMBlackListActivity iMBlackListActivity) {
        this.dsi = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        blackListModel = this.dsi.dsf;
        if (blackListModel != null) {
            blackListModel2 = this.dsi.dsf;
            blackListModel2.cancelLoadData();
            this.dsi.dsh = null;
        }
    }
}
