package com.baidu.tieba.voice;

import android.os.Handler;
import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2026a;

    private ag(r rVar) {
        this.f2026a = rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(r rVar, ag agVar) {
        this(rVar);
    }

    @Override // com.baidu.tieba.voice.q
    public void a(String str, int i) {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        this.f2026a.o();
        this.f2026a.H = 1;
        handler = this.f2026a.F;
        if (handler != null) {
            handler2 = this.f2026a.F;
            runnable = this.f2026a.G;
            handler2.removeCallbacks(runnable);
        }
        if (this.f2026a.b == null || str == null) {
            com.baidu.adp.lib.f.d.b("VoiceManager", "RecoreCallback.succ", "data err:" + str + " d:" + i);
        } else if (this.f2026a.f2041a != null) {
            if (i <= 1000) {
                this.f2026a.f2041a.a(2, ak.a(R.string.voice_record_short_tip));
                com.baidu.adp.lib.f.d.b("VoiceManager", "RecoreCallback.succ", "voice too short f:" + str + " d:" + i);
            } else if (!str.endsWith(this.f2026a.b)) {
                com.baidu.adp.lib.f.d.b("VoiceManager", "RecoreCallback.succ", "filename error f:" + str + " v:" + this.f2026a.b);
            } else {
                com.baidu.adp.lib.f.d.b("========start submit voice f:" + str + " d:" + i);
                this.f2026a.a(this.f2026a.b, i / LocationClientOption.MIN_SCAN_SPAN);
                this.f2026a.b = null;
            }
        }
    }

    @Override // com.baidu.tieba.voice.q
    public void a(int i, String str) {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        this.f2026a.o();
        handler = this.f2026a.F;
        if (handler != null) {
            handler2 = this.f2026a.F;
            runnable = this.f2026a.G;
            handler2.removeCallbacks(runnable);
        }
        com.baidu.adp.lib.f.d.b(getClass().getName(), "RecoreCallback.error", "error: " + str);
        if (this.f2026a.f2041a == null) {
            this.f2026a.H = 1;
        } else if (i != 7) {
            this.f2026a.H = 1;
            if (i == 8) {
                i = 2;
            }
            this.f2026a.f2041a.a(i, str);
            com.baidu.adp.lib.f.d.b("VoiceManager", "RecoreCallback.error", "err:" + i + " " + str);
        } else if (this.f2026a.b != null) {
            this.f2026a.a(this.f2026a.b, com.baidu.adp.lib.voice.a.f459a / LocationClientOption.MIN_SCAN_SPAN);
            this.f2026a.b = null;
            this.f2026a.f2041a.a(3, this.f2026a.d.getString(R.string.voice_record_timeout_tip));
        } else {
            com.baidu.adp.lib.f.d.b("VoiceManager", "RecoreCallback.error", "data err");
        }
    }

    @Override // com.baidu.tieba.voice.q
    public void a(int i) {
        if (this.f2026a.f2041a != null) {
            this.f2026a.f2041a.b(i);
        }
    }

    @Override // com.baidu.tieba.voice.q
    public void b(int i) {
        if (this.f2026a.f2041a != null) {
            this.f2026a.f2041a.a(i / LocationClientOption.MIN_SCAN_SPAN);
        }
    }
}
