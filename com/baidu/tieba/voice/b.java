package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ a bSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bSC = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.bSC.afa();
        if (this.bSC.getVoiceManager() != null && this.bSC.mModel != null) {
            this.bSC.getVoiceManager().delRecord(this.bSC.mModel.voiceId);
            this.bSC.mModel = null;
        }
    }
}
