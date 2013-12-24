package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ VoiceManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VoiceManager voiceManager, String str, int i) {
        this.c = voiceManager;
        this.a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tieba.voice.a.e.a(aj.c(this.a)).a;
        handler = this.c.p;
        if (handler != null) {
            handler2 = this.c.p;
            handler2.removeCallbacks(this.c.c);
            if (com.baidu.adp.lib.h.m.a(str)) {
                handler4 = this.c.p;
                handler4.post(new w(this));
                return;
            }
            handler3 = this.c.p;
            handler3.post(new x(this, str));
        }
    }
}
