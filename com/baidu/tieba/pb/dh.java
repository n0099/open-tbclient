package com.baidu.tieba.pb;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements com.baidu.tieba.voice.q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dd f2121a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dd ddVar) {
        this.f2121a = ddVar;
    }

    @Override // com.baidu.tieba.voice.q
    public void a() {
        PbWriteToolView pbWriteToolView;
        Button button;
        Button button2;
        PbWriteToolView pbWriteToolView2;
        PbWriteToolView pbWriteToolView3;
        pbWriteToolView = this.f2121a.f;
        if (pbWriteToolView != null) {
            pbWriteToolView2 = this.f2121a.f;
            if (pbWriteToolView2.getAudioButton() != null) {
                pbWriteToolView3 = this.f2121a.f;
                pbWriteToolView3.getAudioButton().g();
            }
        }
        button = this.f2121a.D;
        if (button != null) {
            button2 = this.f2121a.D;
            button2.setEnabled(true);
        }
    }

    @Override // com.baidu.tieba.voice.q
    public void b() {
        PbWriteToolView pbWriteToolView;
        Button button;
        Button button2;
        PbWriteToolView pbWriteToolView2;
        PbWriteToolView pbWriteToolView3;
        pbWriteToolView = this.f2121a.f;
        if (pbWriteToolView != null) {
            pbWriteToolView2 = this.f2121a.f;
            if (pbWriteToolView2.getAudioButton() != null) {
                pbWriteToolView3 = this.f2121a.f;
                pbWriteToolView3.getAudioButton().h();
            }
        }
        button = this.f2121a.D;
        if (button != null && !this.f2121a.u()) {
            button2 = this.f2121a.D;
            button2.setEnabled(false);
        }
    }
}
