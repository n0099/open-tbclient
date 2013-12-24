package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Runnable {
    final /* synthetic */ PbEditor a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PbEditor pbEditor) {
        this.a = pbEditor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.e) {
            this.a.d();
        }
    }
}
