package com.baidu.tieba.kn.shake;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ShakeActivity shakeActivity) {
        this.f1282a = shakeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.f1282a.f;
        jVar.b();
    }
}
