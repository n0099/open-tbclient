package com.baidu.ufosdk.ui;
/* loaded from: classes22.dex */
final class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f3783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bm bmVar) {
        this.f3783a = bmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.f3783a.b);
    }
}
