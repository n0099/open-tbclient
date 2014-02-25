package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements Runnable {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        cuVar = this.a.C;
        if (!cuVar.z()) {
            cuVar3 = this.a.C;
            cuVar3.b(false);
            return;
        }
        cuVar2 = this.a.C;
        cuVar2.b(true);
    }
}
