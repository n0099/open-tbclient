package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2240a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(cr crVar) {
        this.f2240a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        this.f2240a.f2213a.setVisibility(0);
        pbEditor = this.f2240a.an;
        pbEditor.h();
        pbEditor2 = this.f2240a.an;
        pbEditor2.setVisibility(0);
    }
}
