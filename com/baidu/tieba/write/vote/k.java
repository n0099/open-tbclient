package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteVoteActivity dnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVoteActivity writeVoteActivity) {
        this.dnv = writeVoteActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dnv.destroyWaitingDialog();
        this.dnv.aBR();
    }
}
