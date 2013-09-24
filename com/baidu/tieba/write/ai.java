package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tieba.voice.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.f2086a = writeActivity;
    }

    @Override // com.baidu.tieba.voice.o
    public void a() {
        AudioIcon audioIcon;
        audioIcon = this.f2086a.n;
        audioIcon.g();
    }

    @Override // com.baidu.tieba.voice.o
    public void b() {
        AudioIcon audioIcon;
        audioIcon = this.f2086a.n;
        audioIcon.h();
    }
}
