package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ RecordVoiceBnt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.e();
        if (this.a.getVoiceManager() != null) {
            this.a.getVoiceManager().a(this.a.a.voiceId);
            this.a.a = null;
        }
    }
}
