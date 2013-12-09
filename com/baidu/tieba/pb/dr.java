package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(cr crVar) {
        this.f2241a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        this.f2241a.f2214a.setVisibility(0);
        pbEditor = this.f2241a.an;
        pbEditor.h();
        pbEditor2 = this.f2241a.an;
        pbEditor2.setVisibility(0);
    }
}
