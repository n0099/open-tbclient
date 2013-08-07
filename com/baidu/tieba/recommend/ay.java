package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
class ay implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendActivity f1651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(RecommendActivity recommendActivity) {
        this.f1651a = recommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bb bbVar;
        bbVar = this.f1651a.b;
        bbVar.c.setPosition(0.0f);
    }
}
