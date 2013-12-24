package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(cr crVar) {
        this.a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEditor pbEditor;
        PbEditor pbEditor2;
        this.a.a.setVisibility(0);
        pbEditor = this.a.an;
        pbEditor.h();
        pbEditor2 = this.a.an;
        pbEditor2.setVisibility(0);
    }
}
