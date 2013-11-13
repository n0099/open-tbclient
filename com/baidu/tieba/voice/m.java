package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecordVoiceBnt recordVoiceBnt) {
        this.f2630a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2630a.e();
        if (this.f2630a.getVoiceManager() != null) {
            this.f2630a.getVoiceManager().a(this.f2630a.f2605a.voiceId);
            this.f2630a.f2605a = null;
        }
    }
}
