package com.baidu.tieba.service;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaActiveService f2449a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TiebaActiveService tiebaActiveService) {
        this.f2449a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2449a.d();
    }
}
