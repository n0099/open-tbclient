package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2060a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar, String str, int i) {
        this.f2060a = rVar;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String str = com.baidu.tieba.voice.a.e.b(aj.c(this.b)).f2020a;
        handler = this.f2060a.p;
        if (handler != null) {
            handler4 = this.f2060a.p;
            handler4.removeCallbacks(this.f2060a.c);
        }
        if (com.baidu.adp.lib.f.h.a(str)) {
            handler3 = this.f2060a.p;
            handler3.post(new aa(this));
            return;
        }
        handler2 = this.f2060a.p;
        handler2.post(new ab(this, str, this.c));
    }
}
