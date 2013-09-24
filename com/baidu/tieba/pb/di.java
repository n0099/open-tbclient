package com.baidu.tieba.pb;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements com.baidu.tieba.voice.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f1606a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(db dbVar) {
        this.f1606a = dbVar;
    }

    @Override // com.baidu.tieba.voice.o
    public void a() {
        PbWriteToolView pbWriteToolView;
        Button button;
        Button button2;
        PbWriteToolView pbWriteToolView2;
        PbWriteToolView pbWriteToolView3;
        pbWriteToolView = this.f1606a.f;
        if (pbWriteToolView != null) {
            pbWriteToolView2 = this.f1606a.f;
            if (pbWriteToolView2.getAudioButton() != null) {
                pbWriteToolView3 = this.f1606a.f;
                pbWriteToolView3.getAudioButton().g();
            }
        }
        button = this.f1606a.D;
        if (button != null) {
            button2 = this.f1606a.D;
            button2.setEnabled(true);
        }
    }

    @Override // com.baidu.tieba.voice.o
    public void b() {
        PbWriteToolView pbWriteToolView;
        Button button;
        Button button2;
        PbWriteToolView pbWriteToolView2;
        PbWriteToolView pbWriteToolView3;
        pbWriteToolView = this.f1606a.f;
        if (pbWriteToolView != null) {
            pbWriteToolView2 = this.f1606a.f;
            if (pbWriteToolView2.getAudioButton() != null) {
                pbWriteToolView3 = this.f1606a.f;
                pbWriteToolView3.getAudioButton().h();
            }
        }
        button = this.f1606a.D;
        if (button != null && !this.f1606a.u()) {
            button2 = this.f1606a.D;
            button2.setEnabled(false);
        }
    }
}
