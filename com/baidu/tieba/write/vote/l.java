package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVoteActivity eKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVoteActivity writeVoteActivity) {
        this.eKX = writeVoteActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.eKX.destroyWaitingDialog();
        this.eKX.aZP();
    }
}
