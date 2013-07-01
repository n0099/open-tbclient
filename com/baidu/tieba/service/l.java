package com.baidu.tieba.service;
/* loaded from: classes.dex */
class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaActiveService f1414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TiebaActiveService tiebaActiveService) {
        this.f1414a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1414a.d();
    }
}
