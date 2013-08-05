package com.baidu.tieba.kn.shake;
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1251a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ShakeActivity shakeActivity) {
        this.f1251a = shakeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.f1251a.f;
        jVar.b();
    }
}
