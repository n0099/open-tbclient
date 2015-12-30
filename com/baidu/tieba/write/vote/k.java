package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVoteActivity dWm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVoteActivity writeVoteActivity) {
        this.dWm = writeVoteActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dWm.destroyWaitingDialog();
        this.dWm.aKF();
    }
}
