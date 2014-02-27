package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class l implements DialogInterface.OnClickListener {
    final /* synthetic */ RecordVoiceBnt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.c();
        if (this.a.getVoiceManager() != null && this.a.a != null) {
            this.a.getVoiceManager().a(this.a.a.voiceId);
            this.a.a = null;
        }
    }
}
