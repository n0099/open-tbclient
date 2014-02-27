package com.baidu.tieba.write;
/* loaded from: classes.dex */
final class bi implements Runnable {
    final /* synthetic */ bh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.a = bhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WriteActivity writeActivity;
        writeActivity = this.a.a;
        writeActivity.finish();
    }
}
