package com.baidu.tieba.service;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ TiebaSyncService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TiebaSyncService tiebaSyncService) {
        this.a = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a();
    }
}
