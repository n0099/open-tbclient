package com.baidu.tieba.write;

import com.baidu.tieba.voice.RecordVoiceBnt;
/* loaded from: classes.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.f2635a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordVoiceBnt recordVoiceBnt;
        recordVoiceBnt = this.f2635a.N;
        if (recordVoiceBnt.getVisibility() != 0) {
            this.f2635a.n();
        }
    }
}
