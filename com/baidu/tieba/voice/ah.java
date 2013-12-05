package com.baidu.tieba.voice;

import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2720a;

    private ah(VoiceManager voiceManager) {
        this.f2720a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(VoiceManager voiceManager, s sVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tieba.voice.r
    public void a(String str, int i) {
        this.f2720a.q();
        this.f2720a.H = 1;
        if (this.f2720a.b == null || str == null) {
            com.baidu.adp.lib.h.e.b("VoiceManager", "RecoreCallback.succ", "data err:" + str + " d:" + i);
        } else if (this.f2720a.f2708a != null) {
            if (i <= 1000) {
                this.f2720a.f2708a.b(2, ak.a(R.string.voice_record_short_tip));
                com.baidu.adp.lib.h.e.b("VoiceManager", "RecoreCallback.succ", "voice too short f:" + str + " d:" + i);
            } else if (!str.endsWith(this.f2720a.b)) {
                com.baidu.adp.lib.h.e.b("VoiceManager", "RecoreCallback.succ", "filename error f:" + str + " v:" + this.f2720a.b);
            } else {
                com.baidu.adp.lib.h.e.c("========start submit voice f:" + str + " d:" + i);
                this.f2720a.a(this.f2720a.b, (int) Math.round((i * 1.0d) / 1000.0d));
                this.f2720a.b = null;
            }
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void a(int i, String str) {
        this.f2720a.q();
        com.baidu.adp.lib.h.e.b(getClass().getName(), "RecoreCallback.error", "error: " + str);
        if (this.f2720a.f2708a == null) {
            this.f2720a.H = 1;
        } else if (i != 7) {
            this.f2720a.H = 1;
            if (i == 8) {
                i = 2;
            }
            this.f2720a.f2708a.b(i, str);
            com.baidu.adp.lib.h.e.b("VoiceManager", "RecoreCallback.error", "err:" + i + " " + str);
        } else if (this.f2720a.b != null) {
            this.f2720a.a(this.f2720a.b, com.baidu.adp.lib.voice.a.f519a / LocationClientOption.MIN_SCAN_SPAN);
            this.f2720a.b = null;
            this.f2720a.f2708a.b(3, this.f2720a.d.getString(R.string.voice_record_timeout_tip));
        } else {
            com.baidu.adp.lib.h.e.b("VoiceManager", "RecoreCallback.error", "data err");
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void a(int i) {
        if (this.f2720a.f2708a != null) {
            this.f2720a.f2708a.e(i);
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void b(int i) {
        if (this.f2720a.f2708a != null) {
            this.f2720a.f2708a.d(i / LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void a() {
        this.f2720a.H = 1;
    }
}
