package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity, int i) {
        this.a = writeActivity;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b(this.b);
    }
}
