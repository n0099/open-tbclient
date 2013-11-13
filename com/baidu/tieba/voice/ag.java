package com.baidu.tieba.voice;

import android.os.Handler;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2618a;

    private ag(VoiceManager voiceManager) {
        this.f2618a = voiceManager;
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
        com.baidu.adp.lib.h.d.a("VoiceManager", "Voice-Play-Succ", "");
        adVar = this.f2618a.y;
        if (adVar != null) {
            voiceModel = this.f2618a.v;
            if (voiceModel != null) {
                z = this.f2618a.M;
                if (!z) {
                    VoiceManager voiceManager = this.f2618a;
                    voiceModel2 = this.f2618a.v;
                    voiceManager.b(voiceModel2);
                    this.f2618a.y = null;
                }
                this.f2618a.v = null;
                m = this.f2618a.m();
                z2 = this.f2618a.M;
                if (!z2 || m == null) {
                    this.f2618a.q();
                    return;
                }
                VoiceManager.VoiceModel voiceModel3 = m.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.f2618a.p;
                if (handler != null) {
                    handler2 = this.f2618a.p;
                    handler2.removeCallbacks(this.f2618a.j);
                    handler3 = this.f2618a.p;
                    handler3.postDelayed(this.f2618a.j, 10L);
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
        bg.b("VoiceManager", "Voice-Play-Fail", " " + i + " " + str);
        adVar = this.f2618a.y;
        if (adVar != null) {
            adVar2 = this.f2618a.y;
            adVar2.b(i, str);
            voiceModel = this.f2618a.v;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.f2618a;
                voiceModel2 = this.f2618a.v;
                voiceManager.b(voiceModel2);
                this.f2618a.v = null;
            }
            this.f2618a.q();
        }
    }

    @Override // com.baidu.tieba.voice.j
    public void a(int i) {
        ad m;
        VoiceManager.VoiceModel voiceModel;
        VoiceManager.VoiceModel voiceModel2;
        m = this.f2618a.m();
        if (m != null) {
            m.c(i);
        }
        voiceModel = this.f2618a.v;
        if (voiceModel != null) {
            voiceModel2 = this.f2618a.v;
            voiceModel2.elapse = i;
        }
    }
}
