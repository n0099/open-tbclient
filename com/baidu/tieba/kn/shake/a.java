package com.baidu.tieba.kn.shake;
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeActivity f1807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ShakeActivity shakeActivity) {
        this.f1807a = shakeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.f1807a.f;
        jVar.b();
    }
}
