package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class bl implements Runnable {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cu cuVar;
        cuVar = this.a.C;
        cuVar.t();
    }
}
