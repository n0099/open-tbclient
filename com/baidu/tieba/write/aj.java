package com.baidu.tieba.write;
/* loaded from: classes.dex */
final class aj implements Runnable {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WriteActivity writeActivity;
        writeActivity = this.a.a;
        writeActivity.finish();
    }
}
