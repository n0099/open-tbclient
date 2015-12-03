package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVoteActivity dON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVoteActivity writeVoteActivity) {
        this.dON = writeVoteActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dON.destroyWaitingDialog();
        this.dON.aIk();
    }
}
