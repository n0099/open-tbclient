package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendActivity f1652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(RecommendActivity recommendActivity) {
        this.f1652a = recommendActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bb bbVar;
        bbVar = this.f1652a.b;
        bbVar.c.setPosition(1.0f);
    }
}
