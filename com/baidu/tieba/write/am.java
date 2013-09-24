package com.baidu.tieba.write;

import com.baidu.tieba.voice.RecordVoiceBnt;
/* loaded from: classes.dex */
class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.f2090a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordVoiceBnt recordVoiceBnt;
        recordVoiceBnt = this.f2090a.N;
        if (recordVoiceBnt.getVisibility() == 0) {
            return;
        }
        this.f2090a.n();
    }
}
