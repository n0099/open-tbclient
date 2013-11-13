package com.baidu.tieba.service;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaSyncService f2353a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TiebaSyncService tiebaSyncService) {
        this.f2353a = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2353a.b();
    }
}
