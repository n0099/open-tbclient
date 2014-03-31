package com.baidu.tieba.write;
/* loaded from: classes.dex */
final class aq implements Runnable {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity, int i) {
        this.a = writeActivity;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
