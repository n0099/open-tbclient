package com.baidu.tieba.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f2623a = cVar;
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
        audioTrack = this.f2623a.b;
        if (audioTrack != null) {
            audioTrack2 = this.f2623a.b;
            if (audioTrack2.getPlayState() == 3) {
                int a2 = this.f2623a.a();
                i = this.f2623a.h;
                int i4 = a2 + i;
                com.baidu.adp.lib.h.d.a(getClass(), "TestVoice2", "elapsedTime=" + i4);
                i2 = this.f2623a.i;
                if (i4 != i2) {
                    this.f2623a.i = i4;
                    handler2 = this.f2623a.f;
                    Message obtainMessage = handler2.obtainMessage(6);
                    i3 = this.f2623a.i;
                    obtainMessage.arg1 = i3;
                    handler3 = this.f2623a.f;
                    handler3.sendMessage(obtainMessage);
                }
                handler = this.f2623a.j;
                runnable = this.f2623a.k;
                handler.postDelayed(runnable, 100L);
            }
        }
    }
}
