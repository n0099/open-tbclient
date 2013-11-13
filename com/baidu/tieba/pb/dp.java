package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(cp cpVar) {
        this.f2148a = cpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        this.f2148a.f2121a.setVisibility(0);
        pbEditor = this.f2148a.an;
        pbEditor.h();
        pbEditor2 = this.f2148a.an;
        pbEditor2.setVisibility(0);
    }
}
