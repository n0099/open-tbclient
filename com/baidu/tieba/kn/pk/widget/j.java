package com.baidu.tieba.kn.pk.widget;
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PullAndPull f1802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PullAndPull pullAndPull) {
        this.f1802a = pullAndPull;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1802a.invalidate();
        this.f1802a.postDelayed(this, 30000L);
    }
}
