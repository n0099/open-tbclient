package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f1643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.f1643a = anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FindInterestFragment findInterestFragment;
        aq aqVar;
        findInterestFragment = this.f1643a.f1642a;
        aqVar = findInterestFragment.b;
        aqVar.k();
    }
}
