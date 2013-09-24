package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.f2054a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.f2054a.f2041a == null) {
            return;
        }
        i = this.f2054a.H;
        if (i == 2) {
            this.f2054a.f2041a.b();
        }
    }
}
