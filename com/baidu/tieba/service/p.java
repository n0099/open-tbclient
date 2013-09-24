package com.baidu.tieba.service;
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaSyncService f1799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaSyncService tiebaSyncService) {
        this.f1799a = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1799a.b();
    }
}
