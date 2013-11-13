package com.baidu.tieba.square;
/* loaded from: classes.dex */
class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareHorizontalScrollView f2390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SquareHorizontalScrollView squareHorizontalScrollView) {
        this.f2390a = squareHorizontalScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        av avVar;
        av avVar2;
        avVar = this.f2390a.f2367a;
        if (avVar != null) {
            avVar2 = this.f2390a.f2367a;
            avVar2.b(this.f2390a);
        }
    }
}
