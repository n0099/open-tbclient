package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PbEditor f2110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(PbEditor pbEditor) {
        this.f2110a = pbEditor;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2110a.e) {
            this.f2110a.d();
        }
    }
}
