package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVoteActivity dpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVoteActivity writeVoteActivity) {
        this.dpK = writeVoteActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dpK.destroyWaitingDialog();
        this.dpK.aCN();
    }
}
