package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(PbEditor pbEditor, int i) {
        this.b = pbEditor;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a, new ch(this));
    }
}
