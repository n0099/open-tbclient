package com.baidu.tieba.voice;

import android.os.Handler;
import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2565a;

    private ah(VoiceManager voiceManager) {
        this.f2565a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(VoiceManager voiceManager, t tVar) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(String str, int i) {
        ae aeVar;
        VoiceManager.VoiceModel voiceModel;
        boolean z;
        ae m;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceManager.VoiceModel voiceModel2;
        com.baidu.adp.lib.h.d.a("VoiceManager", "Voice-Play-Succ", "");
        aeVar = this.f2565a.y;
        if (aeVar != null) {
            voiceModel = this.f2565a.v;
            if (voiceModel != null) {
                z = this.f2565a.M;
                if (!z) {
                    VoiceManager voiceManager = this.f2565a;
                    voiceModel2 = this.f2565a.v;
                    voiceManager.b(voiceModel2);
                    this.f2565a.y = null;
                }
                this.f2565a.v = null;
                m = this.f2565a.m();
                z2 = this.f2565a.M;
                if (!z2 || m == null) {
                    this.f2565a.q();
                    return;
                }
                VoiceManager.VoiceModel voiceModel3 = m.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.f2565a.p;
                if (handler != null) {
                    handler2 = this.f2565a.p;
                    handler2.removeCallbacks(this.f2565a.j);
                    handler3 = this.f2565a.p;
                    handler3.postDelayed(this.f2565a.j, 10L);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(int i, String str) {
        ae aeVar;
        ae aeVar2;
        VoiceManager.VoiceModel voiceModel;
        VoiceManager.VoiceModel voiceModel2;
        com.baidu.adp.lib.h.d.b("VoiceManager", "Voice-Play-Fail", " " + i + " " + str);
        aeVar = this.f2565a.y;
        if (aeVar != null) {
            aeVar2 = this.f2565a.y;
            aeVar2.b(i, str);
            voiceModel = this.f2565a.v;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.f2565a;
                voiceModel2 = this.f2565a.v;
                voiceManager.b(voiceModel2);
                this.f2565a.v = null;
            }
            this.f2565a.q();
        }
    }

    @Override // com.baidu.tieba.voice.j
    public void a(int i) {
        ae m;
        VoiceManager.VoiceModel voiceModel;
        VoiceManager.VoiceModel voiceModel2;
        m = this.f2565a.m();
        if (m != null) {
            m.c(i);
        }
        voiceModel = this.f2565a.v;
        if (voiceModel != null) {
            voiceModel2 = this.f2565a.v;
            voiceModel2.elapse = i;
        }
    }
}
