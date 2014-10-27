package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ a bSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bSn = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.bSn.aeX();
        if (this.bSn.getVoiceManager() != null && this.bSn.mModel != null) {
            this.bSn.getVoiceManager().delRecord(this.bSn.mModel.voiceId);
            this.bSn.mModel = null;
        }
    }
}
