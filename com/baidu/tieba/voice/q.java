package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2616a;

    private q(RecordVoiceBnt recordVoiceBnt) {
        this.f2616a = recordVoiceBnt;
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
            f = this.f2616a.E;
            if (f >= 360.0f) {
                this.f2616a.E = 360.0f;
                this.f2616a.C = false;
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                j = this.f2616a.H;
                this.f2616a.H = uptimeMillis;
                this.f2616a.I = uptimeMillis + 25;
                RecordVoiceBnt recordVoiceBnt = this.f2616a;
                f2 = this.f2616a.D;
                RecordVoiceBnt.a(recordVoiceBnt, f2 * (((float) (uptimeMillis - j)) / 1000.0f));
                j2 = this.f2616a.I;
                sendEmptyMessageAtTime(1, j2);
            }
            this.f2616a.invalidate();
        }
    }
}
