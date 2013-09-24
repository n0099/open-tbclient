package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
class p extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2040a;

    private p(RecordVoiceBnt recordVoiceBnt) {
        this.f2040a = recordVoiceBnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(RecordVoiceBnt recordVoiceBnt, p pVar) {
        this(recordVoiceBnt);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (RecordVoiceBnt.a(this.f2040a) < 360.0f) {
                long uptimeMillis = SystemClock.uptimeMillis();
                RecordVoiceBnt.a(this.f2040a, uptimeMillis);
                RecordVoiceBnt.b(this.f2040a, uptimeMillis + 25);
                RecordVoiceBnt recordVoiceBnt = this.f2040a;
                RecordVoiceBnt.a(recordVoiceBnt, RecordVoiceBnt.a(recordVoiceBnt) + ((((float) (uptimeMillis - RecordVoiceBnt.b(this.f2040a))) / 1000.0f) * RecordVoiceBnt.c(this.f2040a)));
                sendEmptyMessageAtTime(1, RecordVoiceBnt.d(this.f2040a));
            } else {
                RecordVoiceBnt.a(this.f2040a, 360.0f);
                RecordVoiceBnt.a(this.f2040a, false);
            }
            this.f2040a.invalidate();
        }
    }
}
