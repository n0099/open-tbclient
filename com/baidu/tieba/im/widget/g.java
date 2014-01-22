package com.baidu.tieba.im.widget;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ EggBreakerView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EggBreakerView eggBreakerView) {
        this.a = eggBreakerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
