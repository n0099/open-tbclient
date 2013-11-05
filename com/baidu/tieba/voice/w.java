package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2596a;
    final /* synthetic */ int b;
    final /* synthetic */ VoiceManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VoiceManager voiceManager, String str, int i) {
        this.c = voiceManager;
        this.f2596a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tieba.voice.a.e.b(ak.c(this.f2596a)).f2558a;
        handler = this.c.p;
        if (handler != null) {
            handler4 = this.c.p;
            handler4.removeCallbacks(this.c.c);
        }
        if (com.baidu.adp.lib.h.h.a(str)) {
            handler3 = this.c.p;
            handler3.post(new x(this));
            return;
        }
        handler2 = this.c.p;
        handler2.post(new y(this, str));
    }
}
