package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerformMonitorService f2328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PerformMonitorService performMonitorService) {
        this.f2328a = performMonitorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2328a.b();
    }
}
