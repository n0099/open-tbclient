package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Process;
/* loaded from: classes15.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AudioRecorder f5919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AudioRecorder audioRecorder, String str) {
        super(str);
        this.f5919a = audioRecorder;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0016 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        AudioRecord audioRecord;
        boolean z;
        int i;
        AudioRecord audioRecord2;
        AudioRecord audioRecord3;
        int i2;
        Process.setThreadPriority(-19);
        audioRecord = this.f5919a.f5908a;
        audioRecord.startRecording();
        int i3 = 0;
        while (z) {
            i = this.f5919a.f;
            byte[] bArr = new byte[i];
            audioRecord2 = this.f5919a.f5908a;
            if (audioRecord2 != null) {
                audioRecord3 = this.f5919a.f5908a;
                i2 = this.f5919a.f;
                i3 = audioRecord3.read(bArr, 0, i2);
            }
            if (i3 == -3 || i3 == -2 || i3 == -1 || i3 == 0) {
                this.f5919a.a();
            } else {
                this.f5919a.a(bArr, i3);
            }
        }
    }
}
