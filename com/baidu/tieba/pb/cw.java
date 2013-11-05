package com.baidu.tieba.pb;

import android.widget.Button;
import com.baidu.tieba.write.AudioIcon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements com.baidu.tieba.voice.q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(bt btVar) {
        this.f2110a = btVar;
    }

    @Override // com.baidu.tieba.voice.q
    public void a() {
        AudioIcon audioIcon;
        AudioIcon audioIcon2;
        Button button;
        Button button2;
        AudioIcon audioIcon3;
        AudioIcon audioIcon4;
        audioIcon = this.f2110a.n;
        if (audioIcon != null) {
            audioIcon4 = this.f2110a.n;
            audioIcon4.g();
        }
        audioIcon2 = this.f2110a.r;
        if (audioIcon2 != null) {
            audioIcon3 = this.f2110a.r;
            audioIcon3.g();
        }
        button = this.f2110a.l;
        if (button != null) {
            button2 = this.f2110a.l;
            button2.setEnabled(true);
        }
    }

    @Override // com.baidu.tieba.voice.q
    public void b() {
        AudioIcon audioIcon;
        AudioIcon audioIcon2;
        Button button;
        Button button2;
        AudioIcon audioIcon3;
        AudioIcon audioIcon4;
        audioIcon = this.f2110a.n;
        if (audioIcon != null) {
            audioIcon4 = this.f2110a.n;
            audioIcon4.h();
        }
        audioIcon2 = this.f2110a.r;
        if (audioIcon2 != null) {
            audioIcon3 = this.f2110a.r;
            audioIcon3.h();
        }
        button = this.f2110a.l;
        if (button != null && !this.f2110a.b()) {
            button2 = this.f2110a.l;
            button2.setEnabled(false);
        }
    }
}
