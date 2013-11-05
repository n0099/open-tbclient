package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2578a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(RecordVoiceBnt recordVoiceBnt) {
        this.f2578a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2578a.f();
        if (this.f2578a.getVoiceManager() != null && this.f2578a.f2550a != null && this.f2578a.f2550a.voiceId != null) {
            this.f2578a.getVoiceManager().a(this.f2578a.f2550a.voiceId);
            this.f2578a.f2550a = null;
        }
    }
}
