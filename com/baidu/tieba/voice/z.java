package com.baidu.tieba.voice;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements Runnable {
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
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        String a = com.baidu.adp.lib.util.b.a(aj.a(this.b));
        com.baidu.tieba.voice.a.d dVar = new com.baidu.tieba.voice.a.d();
        if (a == null) {
            dVar.c = 6;
            dVar.d = com.baidu.tieba.voice.a.d.a(dVar.c);
        } else if (com.baidu.tieba.util.af.a(String.valueOf(com.baidu.tieba.util.af.d()) + SwitchKey.VOICE)) {
            String a2 = bs.a(com.baidu.tieba.util.af.i(a));
            if (a2 == null) {
                dVar.c = 5;
                dVar.d = com.baidu.tieba.voice.a.d.a(dVar.c);
            } else {
                String a3 = com.baidu.tieba.util.af.a(a2, 1, true);
                if (com.baidu.tieba.util.af.f(a, a3)) {
                    dVar.b = a3;
                    dVar.a = a2;
                } else {
                    dVar.c = 1;
                    dVar.d = com.baidu.tieba.voice.a.d.a(dVar.c);
                }
            }
        } else {
            dVar.c = 7;
            dVar.d = com.baidu.tieba.voice.a.d.a(dVar.c);
        }
        String str = dVar.a;
        handler = this.a.p;
        if (handler != null) {
            handler2 = this.a.p;
            handler2.removeCallbacks(this.a.c);
            if (com.baidu.adp.lib.util.k.a(str)) {
                handler4 = this.a.p;
                handler4.post(new aa(this));
                return;
            }
            handler3 = this.a.p;
            handler3.post(new ab(this, str, this.c));
        }
    }
}
