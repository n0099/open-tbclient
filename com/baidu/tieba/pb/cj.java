package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cj implements Runnable {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PbEditor pbEditor, int i) {
        this.a = pbEditor;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PbEditor pbEditor = this.a;
        int i = this.b;
        new ck(this);
        pbEditor.a(i);
    }
}
