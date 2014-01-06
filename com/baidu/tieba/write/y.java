package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ WriteActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WriteActivity writeActivity, int i) {
        this.b = writeActivity;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.a);
    }
}
