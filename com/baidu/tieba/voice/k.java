package com.baidu.tieba.voice;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2036a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(RecordVoiceBnt recordVoiceBnt) {
        this.f2036a = recordVoiceBnt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2036a.g();
        if (this.f2036a.getVoiceManager() != null) {
            this.f2036a.getVoiceManager().a(this.f2036a.f2015a.b);
            this.f2036a.f2015a = null;
        }
    }
}
