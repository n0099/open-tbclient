package com.baidu.tieba.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioTrack audioTrack;
        AudioTrack audioTrack2;
        int i;
        int i2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        int i3;
        Handler handler3;
        audioTrack = this.a.b;
        if (audioTrack != null) {
            audioTrack2 = this.a.b;
            if (audioTrack2.getPlayState() == 3) {
                int a = this.a.a();
                i = this.a.h;
                int i4 = a + i;
                com.baidu.adp.lib.util.f.a(getClass(), "TestVoice2", "elapsedTime=" + i4);
                i2 = this.a.i;
                if (i4 != i2) {
                    this.a.i = i4;
                    handler2 = this.a.f;
                    Message obtainMessage = handler2.obtainMessage(6);
                    i3 = this.a.i;
                    obtainMessage.arg1 = i3;
                    handler3 = this.a.f;
                    handler3.sendMessage(obtainMessage);
                }
                handler = this.a.j;
                runnable = this.a.k;
                handler.postDelayed(runnable, 100L);
            }
        }
    }
}
