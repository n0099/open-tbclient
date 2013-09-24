package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2025a;

    private af(r rVar) {
        this.f2025a = rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(r rVar, af afVar) {
        this(rVar);
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(String str, int i) {
        ac acVar;
        ai aiVar;
        boolean z;
        ac k;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        ai aiVar2;
        com.baidu.adp.lib.f.d.a("VoiceManager", "Voice-Play-Succ", "");
        acVar = this.f2025a.x;
        if (acVar != null) {
            aiVar = this.f2025a.u;
            if (aiVar == null) {
                return;
            }
            z = this.f2025a.M;
            if (!z) {
                r rVar = this.f2025a;
                aiVar2 = this.f2025a.u;
                rVar.b(aiVar2);
                this.f2025a.x = null;
            }
            this.f2025a.u = null;
            k = this.f2025a.k();
            z2 = this.f2025a.M;
            if (z2 && k != null) {
                ai voiceModel = k.getVoiceModel();
                if (voiceModel != null && i >= 0) {
                    voiceModel.g = i;
                }
                handler = this.f2025a.p;
                if (handler != null) {
                    handler2 = this.f2025a.p;
                    handler2.removeCallbacks(this.f2025a.j);
                    handler3 = this.f2025a.p;
                    handler3.postDelayed(this.f2025a.j, 10L);
                    return;
                }
                return;
            }
            this.f2025a.o();
        }
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(int i, String str) {
        ac acVar;
        ac acVar2;
        ai aiVar;
        ai aiVar2;
        com.baidu.adp.lib.f.d.b("VoiceManager", "Voice-Play-Fail", " " + i + " " + str);
        acVar = this.f2025a.x;
        if (acVar != null) {
            acVar2 = this.f2025a.x;
            acVar2.a(i, str);
            aiVar = this.f2025a.u;
            if (aiVar != null) {
                r rVar = this.f2025a;
                aiVar2 = this.f2025a.u;
                rVar.b(aiVar2);
                this.f2025a.u = null;
            }
            this.f2025a.o();
        }
    }

    @Override // com.baidu.tieba.voice.i
    public void a(int i) {
        ac k;
        ai aiVar;
        ai aiVar2;
        k = this.f2025a.k();
        if (k != null) {
            k.c(i);
        }
        aiVar = this.f2025a.u;
        if (aiVar != null) {
            aiVar2 = this.f2025a.u;
            aiVar2.f = i;
        }
    }
}
