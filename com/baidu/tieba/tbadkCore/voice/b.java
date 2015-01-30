package com.baidu.tieba.tbadkCore.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ a cbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cbt = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.cbt.aiB();
        if (this.cbt.getVoiceManager() != null && this.cbt.mModel != null) {
            this.cbt.getVoiceManager().delRecord(this.cbt.mModel.voiceId);
            this.cbt.mModel = null;
        }
    }
}
