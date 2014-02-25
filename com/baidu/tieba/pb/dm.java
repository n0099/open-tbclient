package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class dm implements Runnable {
    final /* synthetic */ dl a;
    private final /* synthetic */ com.baidu.tieba.data.av b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dl dlVar, com.baidu.tieba.data.av avVar, boolean z, String str, String str2) {
        this.a = dlVar;
        this.b = avVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu cuVar;
        dy dyVar;
        cu cuVar2;
        cu cuVar3;
        ed edVar;
        cu cuVar4;
        dy dyVar2;
        cuVar = this.a.a;
        dyVar = cuVar.aj;
        if (dyVar != null) {
            cuVar4 = this.a.a;
            dyVar2 = cuVar4.aj;
            dyVar2.a(this.b);
        }
        if (this.c) {
            cuVar3 = this.a.a;
            edVar = cuVar3.s;
            edVar.a(this.d, this.e);
        }
        cuVar2 = this.a.a;
        cuVar2.ak();
    }
}
