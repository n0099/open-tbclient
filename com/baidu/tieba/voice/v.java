package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2056a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.f2056a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ac k;
        k = this.f2056a.k();
        if (k != null) {
            this.f2056a.b(k);
        }
    }
}
