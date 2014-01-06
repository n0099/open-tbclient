package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ RecordVoiceBnt a;

    private q(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(RecordVoiceBnt recordVoiceBnt, l lVar) {
        this(recordVoiceBnt);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        float f;
        long j;
        float f2;
        long j2;
        if (message.what == 1) {
            f = this.a.A;
            if (f >= 360.0f) {
                this.a.A = 360.0f;
                this.a.y = false;
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                j = this.a.D;
                this.a.D = uptimeMillis;
                this.a.E = uptimeMillis + 25;
                RecordVoiceBnt recordVoiceBnt = this.a;
                f2 = this.a.z;
                RecordVoiceBnt.a(recordVoiceBnt, f2 * (((float) (uptimeMillis - j)) / 1000.0f));
                j2 = this.a.E;
                sendEmptyMessageAtTime(1, j2);
            }
            this.a.invalidate();
        }
    }
}
