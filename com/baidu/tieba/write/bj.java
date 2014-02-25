package com.baidu.tieba.write;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.a = biVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.a.a;
        writeActivity.finish();
    }
}
