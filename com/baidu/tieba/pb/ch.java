package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2097a;
    final /* synthetic */ PbEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(PbEditor pbEditor, int i) {
        this.b = pbEditor;
        this.f2097a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f2097a, new ci(this));
    }
}
