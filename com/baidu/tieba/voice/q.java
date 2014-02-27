package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
final class q extends Handler {
    final /* synthetic */ RecordVoiceBnt a;

    private q(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(RecordVoiceBnt recordVoiceBnt, byte b) {
        this(recordVoiceBnt);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            if (RecordVoiceBnt.a(this.a) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                RecordVoiceBnt.a(this.a, uptimeMillis);
                RecordVoiceBnt.b(this.a, uptimeMillis + 25);
                RecordVoiceBnt recordVoiceBnt = this.a;
                RecordVoiceBnt.a(recordVoiceBnt, RecordVoiceBnt.a(recordVoiceBnt) + ((((float) (uptimeMillis - RecordVoiceBnt.b(this.a))) / 1000.0f) * RecordVoiceBnt.c(this.a)));
                sendEmptyMessageAtTime(1, RecordVoiceBnt.d(this.a));
            } else {
                RecordVoiceBnt.a(this.a, 360.0f);
                RecordVoiceBnt.a(this.a, false);
            }
            this.a.invalidate();
        }
    }
}
