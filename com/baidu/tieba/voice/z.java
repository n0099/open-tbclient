package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ VoiceManager a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VoiceManager voiceManager, String str, int i) {
        this.a = voiceManager;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tieba.voice.a.e.a(aj.c(this.b)).a;
        handler = this.a.p;
        if (handler != null) {
            handler2 = this.a.p;
            handler2.removeCallbacks(this.a.c);
            if (com.baidu.adp.lib.util.m.a(str)) {
                handler4 = this.a.p;
                handler4.post(new aa(this));
                return;
            }
            handler3 = this.a.p;
            handler3.post(new ab(this, str, this.c));
        }
    }
}
