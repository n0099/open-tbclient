package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecordVoiceBnt recordVoiceBnt) {
        this.f2731a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2731a.e();
        if (this.f2731a.getVoiceManager() != null) {
            this.f2731a.getVoiceManager().a(this.f2731a.f2706a.voiceId);
            this.f2731a.f2706a = null;
        }
    }
}
