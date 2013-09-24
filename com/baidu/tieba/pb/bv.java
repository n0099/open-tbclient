package com.baidu.tieba.pb;

import android.widget.Button;
import com.baidu.tieba.write.AudioIcon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.tieba.voice.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(br brVar) {
        this.f1567a = brVar;
    }

    @Override // com.baidu.tieba.voice.o
    public void a() {
        AudioIcon audioIcon;
        AudioIcon audioIcon2;
        Button button;
        Button button2;
        AudioIcon audioIcon3;
        AudioIcon audioIcon4;
        audioIcon = this.f1567a.n;
        if (audioIcon != null) {
            audioIcon4 = this.f1567a.n;
            audioIcon4.g();
        }
        audioIcon2 = this.f1567a.r;
        if (audioIcon2 != null) {
            audioIcon3 = this.f1567a.r;
            audioIcon3.g();
        }
        button = this.f1567a.l;
        if (button != null) {
            button2 = this.f1567a.l;
            button2.setEnabled(true);
        }
    }

    @Override // com.baidu.tieba.voice.o
    public void b() {
        AudioIcon audioIcon;
        AudioIcon audioIcon2;
        Button button;
        Button button2;
        AudioIcon audioIcon3;
        AudioIcon audioIcon4;
        audioIcon = this.f1567a.n;
        if (audioIcon != null) {
            audioIcon4 = this.f1567a.n;
            audioIcon4.h();
        }
        audioIcon2 = this.f1567a.r;
        if (audioIcon2 != null) {
            audioIcon3 = this.f1567a.r;
            audioIcon3.h();
        }
        button = this.f1567a.l;
        if (button != null && !this.f1567a.b()) {
            button2 = this.f1567a.l;
            button2.setEnabled(false);
        }
    }
}
