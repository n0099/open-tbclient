package com.baidu.ufosdk.ui;
/* loaded from: classes7.dex */
final class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f3688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.f3688a = bmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.f3688a.b);
    }
}
