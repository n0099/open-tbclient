package com.baidu.tieba.service;
/* loaded from: classes.dex */
final class p implements Runnable {
    final /* synthetic */ TiebaSyncService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaSyncService tiebaSyncService) {
        this.a = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
