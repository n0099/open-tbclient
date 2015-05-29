package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IMBlackListActivity iMBlackListActivity) {
        this.bvg = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        blackListModel = this.bvg.bvd;
        if (blackListModel != null) {
            blackListModel2 = this.bvg.bvd;
            blackListModel2.cancelLoadData();
            this.bvg.bvf = null;
        }
    }
}
