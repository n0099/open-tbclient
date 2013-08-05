package com.baidu.tieba.recommend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FindInterestFragment findInterestFragment) {
        this.f1637a = findInterestFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        aq aqVar;
        aqVar = this.f1637a.b;
        aqVar.k();
    }
}
