package com.baidu.tieba.tbadkCore.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ a cbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cbs = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.cbs.aiw();
        if (this.cbs.getVoiceManager() != null && this.cbs.mModel != null) {
            this.cbs.getVoiceManager().delRecord(this.cbs.mModel.voiceId);
            this.cbs.mModel = null;
        }
    }
}
