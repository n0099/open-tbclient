package com.baidu.tieba.tbadkCore.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ a bZA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bZA = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.bZA.ahX();
        if (this.bZA.getVoiceManager() != null && this.bZA.mModel != null) {
            this.bZA.getVoiceManager().delRecord(this.bZA.mModel.voiceId);
            this.bZA.mModel = null;
        }
    }
}
