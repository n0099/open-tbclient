package com.baidu.tieba.voice;

import android.os.Handler;
import com.baidu.tieba.util.be;
import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements j {
    final /* synthetic */ VoiceManager a;

    private ag(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(VoiceManager voiceManager, s sVar) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(String str, int i) {
        ad adVar;
        VoiceManager.VoiceModel voiceModel;
        boolean z;
        ad m;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceManager.VoiceModel voiceModel2;
        com.baidu.adp.lib.h.e.a("VoiceManager", "Voice-Play-Succ", "");
        adVar = this.a.y;
        if (adVar != null) {
            voiceModel = this.a.v;
            if (voiceModel != null) {
                z = this.a.M;
                if (!z) {
                    VoiceManager voiceManager = this.a;
                    voiceModel2 = this.a.v;
                    voiceManager.b(voiceModel2);
                    this.a.y = null;
                }
                this.a.v = null;
                m = this.a.m();
                z2 = this.a.M;
                if (!z2 || m == null) {
                    this.a.q();
                    return;
                }
                VoiceManager.VoiceModel voiceModel3 = m.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.a.p;
                if (handler != null) {
                    handler2 = this.a.p;
                    handler2.removeCallbacks(this.a.j);
                    handler3 = this.a.p;
                    handler3.postDelayed(this.a.j, 10L);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(int i, String str) {
        ad adVar;
        ad adVar2;
        VoiceManager.VoiceModel voiceModel;
        VoiceManager.VoiceModel voiceModel2;
        be.b("VoiceManager", "Voice-Play-Fail", " " + i + " " + str);
        adVar = this.a.y;
        if (adVar != null) {
            adVar2 = this.a.y;
            adVar2.b(i, str);
            voiceModel = this.a.v;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.v;
                voiceManager.b(voiceModel2);
                this.a.v = null;
            }
            this.a.q();
        }
    }

    @Override // com.baidu.tieba.voice.j
    public void a(int i) {
        ad m;
        VoiceManager.VoiceModel voiceModel;
        VoiceManager.VoiceModel voiceModel2;
        m = this.a.m();
        if (m != null) {
            m.c(i);
        }
        voiceModel = this.a.v;
        if (voiceModel != null) {
            voiceModel2 = this.a.v;
            voiceModel2.elapse = i;
        }
    }
}
