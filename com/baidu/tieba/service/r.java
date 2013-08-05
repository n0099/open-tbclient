package com.baidu.tieba.service;
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaSyncService f1712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TiebaSyncService tiebaSyncService) {
        this.f1712a = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1712a.b();
    }
}
