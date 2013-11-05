package com.baidu.tieba.voice;

import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2566a;

    private ai(VoiceManager voiceManager) {
        this.f2566a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(VoiceManager voiceManager, t tVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tieba.voice.s
    public void a(String str, int i) {
        this.f2566a.q();
        this.f2566a.H = 1;
        if (this.f2566a.b == null || str == null) {
            com.baidu.adp.lib.h.d.b("VoiceManager", "RecoreCallback.succ", "data err:" + str + " d:" + i);
        } else if (this.f2566a.f2553a != null) {
            if (i <= 1000) {
                this.f2566a.f2553a.b(2, al.a(R.string.voice_record_short_tip));
                com.baidu.adp.lib.h.d.b("VoiceManager", "RecoreCallback.succ", "voice too short f:" + str + " d:" + i);
            } else if (!str.endsWith(this.f2566a.b)) {
                com.baidu.adp.lib.h.d.b("VoiceManager", "RecoreCallback.succ", "filename error f:" + str + " v:" + this.f2566a.b);
            } else {
                com.baidu.adp.lib.h.d.c("========start submit voice f:" + str + " d:" + i);
                this.f2566a.a(this.f2566a.b, (int) Math.round((i * 1.0d) / 1000.0d));
                this.f2566a.b = null;
            }
        }
    }

    @Override // com.baidu.tieba.voice.s
    public void a(int i, String str) {
        this.f2566a.q();
        com.baidu.adp.lib.h.d.b(getClass().getName(), "RecoreCallback.error", "error: " + str);
        if (this.f2566a.f2553a == null) {
            this.f2566a.H = 1;
        } else if (i != 7) {
            this.f2566a.H = 1;
            if (i == 8) {
                i = 2;
            }
            this.f2566a.f2553a.b(i, str);
            com.baidu.adp.lib.h.d.b("VoiceManager", "RecoreCallback.error", "err:" + i + " " + str);
        } else if (this.f2566a.b != null) {
            this.f2566a.a(this.f2566a.b, com.baidu.adp.lib.voice.a.f517a / LocationClientOption.MIN_SCAN_SPAN);
            this.f2566a.b = null;
            this.f2566a.f2553a.b(3, this.f2566a.d.getString(R.string.voice_record_timeout_tip));
        } else {
            com.baidu.adp.lib.h.d.b("VoiceManager", "RecoreCallback.error", "data err");
        }
    }

    @Override // com.baidu.tieba.voice.s
    public void a(int i) {
        if (this.f2566a.f2553a != null) {
            this.f2566a.f2553a.e(i);
        }
    }

    @Override // com.baidu.tieba.voice.s
    public void b(int i) {
        if (this.f2566a.f2553a != null) {
            this.f2566a.f2553a.d(i / LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    @Override // com.baidu.tieba.voice.s
    public void a() {
        this.f2566a.H = 1;
    }
}
