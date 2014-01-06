package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements Runnable {
    final /* synthetic */ PbEditor a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(PbEditor pbEditor) {
        this.a = pbEditor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.e) {
            this.a.c.k();
        }
    }
}
