package com.baidu.vi;

import android.os.Handler;
import android.os.Message;
import com.baidu.vi.AudioRecorder;
/* loaded from: classes3.dex */
final class a extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        AudioRecorder audioRecorder = ((AudioRecorder.a) message.obj).f5911a;
        switch (message.what) {
            case 1:
                z2 = audioRecorder.h;
                if (z2) {
                    audioRecorder.onReadData(((AudioRecorder.a) message.obj).f5912b, ((AudioRecorder.a) message.obj).c);
                    return;
                }
                return;
            case 2:
                z = audioRecorder.h;
                if (z) {
                    audioRecorder.onReadError();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
