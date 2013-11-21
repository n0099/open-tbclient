package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(cr crVar) {
        this.f2133a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        this.f2133a.f2106a.setVisibility(0);
        pbEditor = this.f2133a.an;
        pbEditor.h();
        pbEditor2 = this.f2133a.an;
        pbEditor2.setVisibility(0);
    }
}
