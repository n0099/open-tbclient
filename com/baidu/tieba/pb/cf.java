package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2112a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PbEditor pbEditor, int i) {
        this.b = pbEditor;
        this.f2112a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2112a, new cg(this));
    }
}
