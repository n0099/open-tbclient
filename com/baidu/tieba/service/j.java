package com.baidu.tieba.service;
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerformMonitorService f1412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PerformMonitorService performMonitorService) {
        this.f1412a = performMonitorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1412a.b();
    }
}
