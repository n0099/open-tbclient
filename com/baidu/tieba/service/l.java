package com.baidu.tieba.service;
/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaActiveService f1721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TiebaActiveService tiebaActiveService) {
        this.f1721a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1721a.d();
    }
}
