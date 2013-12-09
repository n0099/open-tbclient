package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PbEditor f2203a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PbEditor pbEditor) {
        this.f2203a = pbEditor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2203a.e) {
            this.f2203a.d();
        }
    }
}
