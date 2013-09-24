package com.baidu.tieba.service;
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaActiveService f1793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TiebaActiveService tiebaActiveService) {
        this.f1793a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1793a.d();
    }
}
