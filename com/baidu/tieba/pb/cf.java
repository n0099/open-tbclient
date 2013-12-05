package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PbEditor f2202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PbEditor pbEditor) {
        this.f2202a = pbEditor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2202a.e) {
            this.f2202a.d();
        }
    }
}
