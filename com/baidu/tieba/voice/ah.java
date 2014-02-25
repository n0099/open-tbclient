package com.baidu.tieba.voice;

import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements r {
    final /* synthetic */ VoiceManager a;

    private ah(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(VoiceManager voiceManager, ah ahVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tieba.voice.r
    public void a(String str, int i) {
        this.a.q();
        this.a.H = 1;
        if (this.a.b == null || str == null) {
            com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.succ", "data err:" + str + " d:" + i);
            com.baidu.tieba.util.ae aeVar = new com.baidu.tieba.util.ae();
            aeVar.a("file", str);
            aeVar.a("dur", Integer.valueOf(i));
            cb.b("", -1103, "RecoreCallback.succ: file is null", aeVar.toString());
        } else if (this.a.a != null) {
            if (i <= 1000) {
                this.a.a.a(2, ak.a(R.string.voice_record_short_tip));
                com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.succ", "voice too short f:" + str + " d:" + i);
                com.baidu.tieba.util.ae aeVar2 = new com.baidu.tieba.util.ae();
                aeVar2.a("file", str);
                aeVar2.a("dur", Integer.valueOf(i));
                cb.b("", -1105, "voice too short", aeVar2.toString());
            } else if (!str.endsWith(this.a.b)) {
                com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.succ", "filename error f:" + str + " v:" + this.a.b);
                com.baidu.tieba.util.ae aeVar3 = new com.baidu.tieba.util.ae();
                aeVar3.a("file", str);
                aeVar3.a("dur", Integer.valueOf(i));
                cb.b("", -1106, "RecoreCallback.succ: filename error", aeVar3.toString());
            } else {
                com.baidu.adp.lib.util.f.d("========start submit voice f:" + str + " d:" + i);
                this.a.a(this.a.b, (int) Math.round((i * 1.0d) / 1000.0d));
                this.a.b = null;
            }
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void a(int i, String str) {
        this.a.q();
        com.baidu.adp.lib.util.f.b(getClass().getName(), "RecoreCallback.error", "error: " + str);
        cb.b("", i, "RecoreCallback.error: " + str, "");
        if (this.a.a == null) {
            this.a.H = 1;
        } else if (i != 7) {
            this.a.H = 1;
            if (i == 8) {
                i = 2;
            }
            this.a.a.a(i, str);
            com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.error", "err:" + i + " " + str);
            cb.b("", i, "RecoreCallback.err: " + str, "");
        } else if (this.a.b != null) {
            this.a.a(this.a.b, com.baidu.adp.lib.voice.a.a / LocationClientOption.MIN_SCAN_SPAN);
            this.a.b = null;
            this.a.a.a(3, this.a.d.getString(R.string.voice_record_timeout_tip));
        } else {
            com.baidu.adp.lib.util.f.b("VoiceManager", "RecoreCallback.error", "data err");
            cb.b("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void a(int i) {
        if (this.a.a != null) {
            this.a.a.f(i);
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void b(int i) {
        if (this.a.a != null) {
            this.a.a.e(i / LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    @Override // com.baidu.tieba.voice.r
    public void a() {
        this.a.H = 1;
    }
}
